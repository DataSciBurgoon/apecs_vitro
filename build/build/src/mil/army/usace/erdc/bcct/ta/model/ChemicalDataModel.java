package mil.army.usace.erdc.bcct.ta.model;

import java.util.HashMap;

public class ChemicalDataModel {
	
	private String chemicalName;
	
	//Key: assayName
	//Value: AssayData object
	private HashMap assayData;
	
	public ChemicalDataModel(String chemicalName, HashMap assayData){
		this.chemicalName = chemicalName;
		this.assayData = assayData;
	}
	
	public String getChemicalName(){
		return chemicalName;
	}
	
	public HashMap<String, AssayData> getAssayData(){
		return assayData;
	}

}
