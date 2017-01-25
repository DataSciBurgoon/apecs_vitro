package mil.army.usace.erdc.bcct.ta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.math3.analysis.interpolation.LoessInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;

import mil.army.usace.erdc.bcct.ta.model.AssayData;

public class Loess {
	
	private AssayData assayData;
	private AssayData loessAssayData;
	private boolean flag = false;
	

	public Loess(AssayData assayData){
		this.assayData = assayData;
		calcLoess();
	}
	
	private double getMax(double[] inputArray){ 
	    double maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
	 
	  // Method for getting the minimum value
	  private double getMin(double[] inputArray){ 
	    double minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	  } 
	
	private void calcLoess(){
		LoessInterpolator li = new LoessInterpolator(0.75, 4);
//		double[] logc = assayData.getAvgLogC();
//		double[] logc = assayData.getSortedLogc();
		try{
//			System.out.println(assayData.getAvgLogC().length);
//			System.out.println(assayData.getAvgResponse().length);
//			if(assayData.getAvgResponse().length == 2){
//				System.out.println("here");
//			}
			PolynomialSplineFunction psf = li.interpolate(assayData.getAvgLogC(), assayData.getAvgResponse());
//			PolynomialFunction blah = psf.getPolynomials()[5];
//			double blah2 = blah.value(0);
//			double[] newY = li.smooth(assayData.getAvgLogC(), assayData.getAvgResponse());
			double[] newX = interpolate(getMin(assayData.getAvgLogC()), getMax(assayData.getAvgLogC()), 49);
			double maxResponse = maxResponse();
			double[] newY = predictVals(psf, newX, maxResponse);
			
			
			
			this.loessAssayData = new AssayData(newX, newY);
//			System.out.println("new assay data: " + newX[0] + "\t" + newY[0]);
		}
		catch(NonMonotonicSequenceException e){
			for(double logc : assayData.getSortedLogc()){
//				System.out.println("logc: " + logc);
			}
			e.printStackTrace();
		}
		catch(NumberIsTooSmallException e){
			System.out.println("There was a problem -- too few datapoints for a chemical-assay combination");
			flag = true;
		}
		catch(NoDataException e){
			System.out.println("There was a problem -- a case of no data for a chemical-assay combination");
			flag = true;
		}
	}
	
	public boolean getFlag(){
		return this.flag;
	}
	
	private double maxResponse(){
		double[] responses = assayData.getAvgResponse();
		double maxResponse = 0.0;
		for(double response : responses){
			if(maxResponse < response){
				maxResponse = response;
			}
		}
		return maxResponse;
	}
	
	private double[] predictVals(PolynomialSplineFunction psf, double[] newX, double maxResponse){
		double[] newVals = new double[newX.length];
		int i = 0;
		for(double x : newX){
			try{
				if(psf.value(x) > maxResponse){
					newVals[i] = maxResponse;
				}
				else{
					newVals[i] = psf.value(x);
				}
				
			}
			catch(OutOfRangeException e){
				newVals[i] = psf.getKnots()[psf.getKnots().length - 1];
			}
			i++;
		}
		return newVals;
	}
	
//	//The Loess function in the Apache Commons expects monotonically increasing X values,
//	//which means I need to calc the mean of them and return just one X value
//	private HashMap<Double, Double> hackAndSlash(){
//		double[] logCVals = assayData.getLogC();
//		double[] response = assayData.getResponse();
//		HashMap<Double, Double> hmCandAvg = new HashMap<Double, Double>();
//		HashMap<Double, ArrayList<Double>> hmTemp = new HashMap<Double, ArrayList<Double>>();
//		int i = 0;
//		for(double logc : logCVals){
//			if(hmTemp.containsKey(new Double(logc))){
//				ArrayList<Double> responseVal = hmTemp.get(new Double(logc));
//				responseVal.add(new Double(response[i]));
//				i++;
//			}
//		}
//		Set<Double> keyset = hmTemp.keySet();
//		for(Double key : keyset){
//			Double sum = 0.0;
//			ArrayList<Double> responses = hmTemp.get(key);
//			for(Double responseVals : responses){
//				sum += responseVals;
//			}
//			Double avgResponse = new Double(sum.doubleValue() / responses.size()); 
//			hmCandAvg.put(key, avgResponse);
//		}
//		return hmCandAvg;
//	}
	
	
	private double[] interpolate(double start, double end, int count) {
	    if (count < 2) {
	        throw new IllegalArgumentException("interpolate: illegal count!");
	    }
	    double[] array = new double[count + 1];
	    for (int i = 0; i <= count; ++ i) {
	        array[i] = start + i * (end - start) / count;
	    }
	    return array;
	}
	
	public AssayData getLoessResults(){
		return this.loessAssayData;
	}

}
