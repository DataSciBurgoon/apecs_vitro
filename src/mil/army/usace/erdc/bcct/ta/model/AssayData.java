package mil.army.usace.erdc.bcct.ta.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.util.Pair;

public class AssayData {
	
	private double[] logc;
	private double[] response;
	private double[] avgLogC;
	private double[] avgResponse;
	private List<Pair<Double, Double>> avgResponses = new ArrayList<Pair<Double, Double>>();
	private List<Pair<Double, Double>> cleanResponses = new ArrayList<Pair<Double, Double>>();
	
	private List<Pair<Double, Double>> pairedResponses = new ArrayList<Pair<Double, Double>>();
	private double[] sortedLogc;
	private double[] sortedResponse;
	
	public AssayData(double[] logc, double[] response){
		this.logc = logc;
		this.response = response;
		//hackAndSlash();
		sortAndReady();
	}
	
	public double[] getSortedLogc(){
		return this.sortedLogc;
	}
	
	public double[] getSortedResponse(){
		return this.sortedResponse;
	}
	
	public double[] getLogC(){
		return logc;
	}
	
	public double[] getResponse(){
		return response;
	}
	
	public double[] getAvgLogC(){
		return this.avgLogC;
	}
	
	public double[] getAvgResponse(){
		return this.avgResponse;
	}
	
	//The Loess function in the Apache Commons expects monotonically increasing X values,
	//which means I need to calc the mean of them and return just one X value
//	private void hackAndSlash(){
//		//HashMap<Double, Double> hmCandAvg = new HashMap<Double, Double>();
//		HashMap<Double, ArrayList<Double>> hmTemp = new HashMap<Double, ArrayList<Double>>();
//		ArrayList<Double> responseVal = new ArrayList<Double>();
//		int i = 0;
//		for(double logc : logc){
//			if(hmTemp.containsKey(new Double(logc))){
//				responseVal.add(new Double(response[i]));
//				i++;
//			}
//			else if(i == 0){
//				responseVal.add(new Double(response[i]));
//				hmTemp.put(new Double(logc), responseVal);
//				i++;
//			}
//			else{
//				responseVal = new ArrayList<Double>();
//				responseVal.add(new Double(response[i]));
//				hmTemp.put(new Double(logc), responseVal);
//				i++;
//			}
//		}
//		Set<Double> keyset = hmTemp.keySet();
//		int j = 0;
//		this.avgLogC = new double[keyset.size()];
//		this.avgResponse = new double[keyset.size()];
//		for(Double key : keyset){
//			Double sum = 0.0;
//			ArrayList<Double> responses = hmTemp.get(key);
//			for(Double responseVals : responses){
//				sum += responseVals;
//			}
//			Double avgResponseVal = new Double(sum.doubleValue() / responses.size());
//			this.avgLogC[j] = key.doubleValue();
//			this.avgResponse[j] = avgResponseVal.doubleValue();
//			this.avgResponses.add(new Pair<Double, Double>(key, avgResponseVal));
//			j++;
//		}
//	}
//	
//	private void sortAndReady(){
//		Collections.sort(this.avgResponses, Comparator.comparing((Pair<Double, Double> avr) -> avr.getFirst()));
//		int i = 0;
//		for(Pair<Double, Double> pairedAVR : this.avgResponses){
//			this.avgLogC[i] = pairedAVR.getFirst().doubleValue();
//			this.avgResponse[i] = pairedAVR.getSecond().doubleValue();
//			i++;
//		}
//	}
	
	private void sortAndReady(){
		int i = 0;
		for(double logcVal : logc){
			pairedResponses.add(new Pair(new Double(logcVal), new Double(response[i])));
			i++;
		}
		Collections.sort(this.pairedResponses, Comparator.comparing((Pair<Double, Double> pairedData) -> pairedData.getFirst()));
		int j = 0;
		this.sortedLogc = new double[pairedResponses.size()];
		this.sortedResponse = new double[pairedResponses.size()];
		
		int howManyTimes = 0;
		ArrayList<Double> valuesSeen = new ArrayList<Double>();
		
		//Need to do some jittering to accommodate the NonMonotonicException thingie
		List<Pair<Double, Double>> tempResponses = new ArrayList<Pair<Double, Double>>();
		List<Pair<Double, Double>> tempResponsesForAvg = new ArrayList<Pair<Double, Double>>();
		double responseHolder = 0.0;
		for(Pair<Double, Double> pairedData : this.pairedResponses){
			if(valuesSeen.isEmpty()){
				valuesSeen.add(pairedData.getFirst());
				tempResponses.add(new Pair<Double, Double>(new Double(pairedData.getFirst()), new Double(pairedData.getSecond())));
				responseHolder += pairedData.getSecond().doubleValue();
				howManyTimes++;
			}
			else if(valuesSeen.contains(new Double(pairedData.getFirst()))){
//				tempResponses.add(new Pair(new Double(pairedData.getFirst() + (howManyTimes * 0.00000001 )), new Double(pairedData.getSecond())));
				tempResponses.add(new Pair<Double, Double>(new Double(pairedData.getFirst()), new Double(pairedData.getSecond())));
				responseHolder += pairedData.getSecond().doubleValue();
				howManyTimes++;
			}
			else{
				valuesSeen.add(pairedData.getFirst());
				responseHolder += pairedData.getSecond().doubleValue();
				double avgResponse = responseHolder / howManyTimes;
				howManyTimes = 1;
				tempResponses.add(new Pair<Double, Double>(new Double(pairedData.getFirst()), new Double(pairedData.getSecond())));
				tempResponsesForAvg.add(new Pair<Double, Double>(new Double(pairedData.getFirst()), new Double(avgResponse)));
				responseHolder = 0.0;
			}
		}
		
		for(Pair<Double, Double> pairedData : tempResponses){
			//System.out.println(pairedData.getFirst().doubleValue());
			this.sortedLogc[j] = pairedData.getFirst().doubleValue();
			this.sortedResponse[j] = pairedData.getSecond().doubleValue();
			j++;
		}
		
		int k = 0;
		this.avgLogC = new double[tempResponsesForAvg.size()];
		this.avgResponse = new double[tempResponsesForAvg.size()];
		for(Pair<Double, Double> pairedData : tempResponsesForAvg){
			//System.out.println(pairedData.getFirst().doubleValue());
			this.avgLogC[k] = pairedData.getFirst().doubleValue();
			this.avgResponse[k] = pairedData.getSecond().doubleValue();
			k++;
		}
		
	}

}
