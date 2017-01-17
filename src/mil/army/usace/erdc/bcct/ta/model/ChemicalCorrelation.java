package mil.army.usace.erdc.bcct.ta.model;

import java.util.HashMap;

public class ChemicalCorrelation {
	
	private HashMap<String, Double> hmAssayCorrelation;
	private String chemicalName;
	
	public ChemicalCorrelation(String chemicalName, HashMap<String, Double>hmAssayCorrelation){
		this.chemicalName = chemicalName;
		this.hmAssayCorrelation = hmAssayCorrelation;
	}
	
	public HashMap<String, Double> getAssayCorrelationValues(){
		return hmAssayCorrelation;
	}
	
	public String getChemicalname(){
		return chemicalName;
	}

}
