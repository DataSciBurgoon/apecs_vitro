package mil.army.usace.erdc.bcct.ta;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import mil.army.usace.erdc.bcct.ta.model.AssayData;
import mil.army.usace.erdc.bcct.ta.model.ChemicalDataModel;

public class Parser {
	
	private File inputFile;
	private ArrayList<ChemicalDataModel> chemicalDataModels = new ArrayList<ChemicalDataModel>();
	
	public Parser(File inputFile){
		this.inputFile = inputFile;
		parseFile();
	}
	
	public ArrayList<ChemicalDataModel> getChemicalDataModels(){
		return chemicalDataModels;
	}
	
	private double[] convertDoubles(ArrayList<Double> doubles)
	{
	    double[] ret = new double[doubles.size()];
	    Iterator<Double> iterator = doubles.iterator();
	    int i = 0;
	    while(iterator.hasNext())
	    {
	        ret[i] = iterator.next();
	        i++;
	    }
	    return ret;
	}
	
	private void parseFile(){
		String chemicalName = new String("");
		String assayName = new String("");
		Path filepath = Paths.get(inputFile.getAbsolutePath());
		try (BufferedReader reader = Files.newBufferedReader(filepath,
                StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 1;
            ArrayList<Double> logc = new ArrayList<Double>();
            ArrayList<Double> response = new ArrayList<Double>();
            HashMap<String, AssayData> hmAssayData = new HashMap<String, AssayData>();
            ChemicalDataModel chemicalDataModel;
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                if(lineNumber > 1){
                	String[] entries = line.split("\t");
                	//If we've seen this chemical before...
                	if(chemicalName.equalsIgnoreCase(entries[0])){
                		//If we've seen this assayName before...
                		if(assayName.equalsIgnoreCase(entries[3])){
                			logc.add(new Double(entries[7]));
                			response.add(new Double(entries[8]));
//                			System.out.println("we've seen this chemical and assay before");
                		}
                		//Same chemical, new assay
                		//convert the ArrayList<Double> to primitive double[]
                		//Create a new AssayData object
                		//Assign that to the HashMap with assayName as the key
                		//Create new objects for assayName, logc, response
                		//Add new values to logc and response ArrayLists<Double>
                		else{
                			double[] dLogc = this.convertDoubles(logc);
                			double[] dResponse = this.convertDoubles(response);
                			AssayData assayData = new AssayData(dLogc, dResponse);
                			hmAssayData.put(assayName, assayData);
                			assayName = new String(entries[3]);
                			logc = new ArrayList<Double>();
                			response = new ArrayList<Double>();
                			logc.add(new Double(entries[7]));
                			response.add(new Double(entries[8]));
//                			System.out.println("we've seen this chemical before, but new assay");
                		}
                	}
                	//First chemical in the file, which also means a new assay
                	else if(chemicalName.contentEquals("")){
                		chemicalName = entries[0];
                		assayName = entries[3];
                		logc.add(new Double(entries[7]));
                		response.add(new Double(entries[8]));
//                		System.out.println("this is the first chemical we've seen");
                	}
                	//New chemical, but not the first chemical in the file, means a new assay, too
                	else{
                		double[] dLogc = this.convertDoubles(logc);
            			double[] dResponse = this.convertDoubles(response);
            			AssayData assayData = new AssayData(dLogc, dResponse);
            			hmAssayData.put(assayName, assayData);
            			chemicalDataModel = new ChemicalDataModel(chemicalName, hmAssayData);
            			chemicalDataModels.add(chemicalDataModel);
            			hmAssayData = new HashMap<String, AssayData>();
                		chemicalName = new String(entries[0]);
                		assayName = new String(entries[3]);
//                		System.out.println("assayName: " + assayName);
                		logc = new ArrayList<Double>();
                		response = new ArrayList<Double>();
//                		System.out.println("new chemical, not the first, thus a new assay, too");
                	}
                }
                lineNumber++;
                
                
                
            }
            double[] dLogc = this.convertDoubles(logc);
			double[] dResponse = this.convertDoubles(response);
			AssayData assayData = new AssayData(dLogc, dResponse);
			hmAssayData.put(assayName, assayData);
			chemicalDataModel = new ChemicalDataModel(chemicalName, hmAssayData);
			chemicalDataModels.add(chemicalDataModel);
//			System.out.println("at the end");
			reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	

}
