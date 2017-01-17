package mil.army.usace.erdc.bcct.ta.test;

import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import mil.army.usace.erdc.bcct.ta.Parser;
import mil.army.usace.erdc.bcct.ta.model.AssayData;
import mil.army.usace.erdc.bcct.ta.model.ChemicalDataModel; 


public class ParserTest {

	@Test
	public void testGetChemicalDataModels() {
		Parser parser = new Parser(new File("data2.txt"));
		ArrayList<ChemicalDataModel> chemicalDataModels = parser.getChemicalDataModels();
		for(ChemicalDataModel chemicalDataModel : chemicalDataModels){
			if(chemicalDataModel.getChemicalName().contentEquals("Estriol")){
				HashMap<String, AssayData> hmAssayData = chemicalDataModel.getAssayData();
				AssayData assayData = hmAssayData.get("ATG_CIS");
				assertEquals(-1.045757491, assayData.getSortedLogc()[0], 0.001);
				assertEquals(0.771637143, assayData.getResponse()[0], 0.001);
				
			}
			else if(chemicalDataModel.getChemicalName().contentEquals("17-Methyltestosterone")){
				System.out.println("blah");
				HashMap<String, AssayData> hmAssayData = chemicalDataModel.getAssayData();
				AssayData assayData = hmAssayData.get("ATG_CIS");
				assertEquals(-1.096910013, assayData.getSortedLogc()[0], 0.001);
				assertEquals(2.937475506, assayData.getSortedResponse()[0], 0.001);
			}
			else{
				fail("Didn't actually enter the if statements");
			}
		}
	}

}
