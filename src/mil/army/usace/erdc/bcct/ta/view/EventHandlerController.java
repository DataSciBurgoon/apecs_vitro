package mil.army.usace.erdc.bcct.ta.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mil.army.usace.erdc.bcct.ta.Loess;
import mil.army.usace.erdc.bcct.ta.MainApp;
import mil.army.usace.erdc.bcct.ta.model.AssayData;
import mil.army.usace.erdc.bcct.ta.model.ChemicalCorrelation;
import mil.army.usace.erdc.bcct.ta.model.ChemicalDataModel;
import mil.army.usace.erdc.bcct.ta.model.ChemicalEstrogenResult;
import mil.army.usace.erdc.bcct.ta.model.EstrogenicAEMVitro;
import mil.army.usace.erdc.bcct.ta.Parser;


public class EventHandlerController implements Initializable{
	
	@FXML public Button fileOpenButton;
	@FXML private Text actionTarget;
	@FXML private Stage stage;
	@FXML public WebView webView;
	@FXML private TableColumn<ChemicalEstrogenResult, Integer> columnID;
	@FXML private TableColumn<ChemicalEstrogenResult, String> columnName;
	@FXML private TableColumn<ChemicalEstrogenResult, Boolean> columnEstrogenic;
	@FXML private TableView<ChemicalEstrogenResult> resultTable;
	
	private ObservableList<ChemicalEstrogenResult> olChems = FXCollections.observableArrayList();
	
	final FileChooser fileChooser = new FileChooser();
	
	@FXML private MainApp mainApp;
	
	private WebEngine webEngine;
	
	private HashMap<String, double[]> hmEstradiolAssayData = new HashMap<String, double[]>();
	
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.load("startup.html");
    }
	
	public void handleSubmitButtonAction(ActionEvent event) {
		//actionTarget.setText("Sign in button pressed");
        //System.out.println("yep, here");
        File file = fileChooser.showOpenDialog(stage);
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        if (file != null) {
        	String[] assayNames = {"ATG_CIS", "ATG_TRANS", "NVS_NR_hER", "OT_ER_ERaERa_0480", 
        			"OT_ER_ERaERa_1440", "OT_ER_ERaERb_0480", "OT_ER_ERaERb_1440", 
        			"OT_ER_ERbERb_0480", "OT_ER_ERbERb_1440", "TOX21_ERa_BLA_Agonist"};
        	
        	Set<String> setAssayNames = new HashSet<String>(Arrays.asList(assayNames));
        	ArrayList x = new ArrayList();
        	
        	
//            System.out.println("here's the file: " + file.toString());
            Parser parser = new Parser(file);
            ArrayList<ChemicalDataModel> chemicalDataModels = parser.getChemicalDataModels();
            ArrayList<ChemicalCorrelation> chemicalCorrelations = new ArrayList<ChemicalCorrelation>();
            parseEstradiolInput();
            for(ChemicalDataModel chemicalDataModel : chemicalDataModels){
            	HashMap<String, AssayData> hmAssayData = chemicalDataModel.getAssayData();
            	HashMap<String, Double> hmAssayCorrelation = new HashMap<String, Double>();
            	hmAssayData.forEach((assayName, assayData) -> {
            		if(setAssayNames.contains(assayName)){
//            			System.out.println("chemical name: " + chemicalDataModel.getChemicalName());
//            			System.out.println(assayName);
            			Loess loess = new Loess(assayData);
            			if(!loess.getFlag()){
            				AssayData loessAssayData = loess.getLoessResults();
                			double[] chemicalResponse = loessAssayData.getResponse();
                			double[] estradiolResponse = hmEstradiolAssayData.get(assayName);
                			for(int i = 0; i < chemicalResponse.length; i++){
//                				System.out.println("chemicalResponse: " + chemicalResponse[i] + "\testradiolResponse: " + estradiolResponse[i]);
                			}
                			PearsonsCorrelation pc = new PearsonsCorrelation();
                			double correlation = pc.correlation(estradiolResponse, chemicalResponse);
                			hmAssayCorrelation.put(new String(assayName), new Double(correlation));
            			}
            			else{
            				hmAssayCorrelation.put(new String(assayName), new Double(0.0));
            			}
            		}
            		
            	});
            	ChemicalCorrelation chemicalCorrelation = new ChemicalCorrelation(
            			chemicalDataModel.getChemicalName(), hmAssayCorrelation);
            	chemicalCorrelations.add(chemicalCorrelation);
            }
            double[] preds = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
            ArrayList<ChemicalEstrogenResult> alChemicalEstrogenResults = new ArrayList<ChemicalEstrogenResult>();
            EstrogenicAEMVitro estrogenAEM = new EstrogenicAEMVitro();
            double[] estrogenCorr = {1.000,1.0000,1.0000,1.0000,1.00000,1.00000,1.00000,1.00000, 1.0000, 1.0000};
            double[] estrogen_score = estrogenAEM.score0(estrogenCorr, preds);
            double[] estrogenAE = {estrogenAEM.ACTIVATION[2][0], estrogenAEM.ACTIVATION[2][1]};
            
//            System.out.println(estrogenAEM.ACTIVATION[2][0]);
//            System.out.println(estrogenAEM.ACTIVATION[2][1]);
            
            ArrayList<ChemicalEstrogenResult> alChemicalEstrogenResult = new ArrayList<ChemicalEstrogenResult>();
            try{
            	OutputStream os = new FileOutputStream("estrogen_results.json");
        		JsonWriter jsonWriter = Json.createWriter(os);
//            	String output = "chemical_name, is_estrogenic, distance, xcoord, ycoord";
//            	out.write(output);
        		int q = 0;
            	for(ChemicalCorrelation chemicalCorrelation : chemicalCorrelations){
                	HashMap<String, Double> hmCorrelationValue = chemicalCorrelation.getAssayCorrelationValues();
                	double[] response = new double[10];
                	int i = 0;
                	for(String assayName : assayNames){
//                		System.out.println("assayName: " + assayName);
                		try{
                			response[i] = hmCorrelationValue.get(assayName).doubleValue();
                		}
                		catch(NullPointerException e){
                			response[i] = 0.0;
                		}
                		
                		i++;
                	}
//                	for(double corr : response){
//                		System.out.println("response: " + corr);
//                	}
                	EstrogenicAEMVitro aem = new EstrogenicAEMVitro();
            		double[] output_scores = aem.score0(response, preds);
//            		double[] output_scores = aem.score0(estrogenCorr, preds);
            		Double ae1 = new Double(aem.ACTIVATION[2][0]);
            		Double ae2 = new Double(aem.ACTIVATION[2][1]);
            		double distance = Math.sqrt(Math.pow(estrogenAE[0]-ae1, 2.0) + Math.pow(estrogenAE[1]-ae2, 2.0));
            		JsonObjectBuilder lowjob = Json.createObjectBuilder();
            		if(distance <= 1.35){
            			ChemicalEstrogenResult chemicalEstrogenResult = new ChemicalEstrogenResult(
            					chemicalCorrelation.getChemicalname(), true, distance, ae1, ae2, q);
            			alChemicalEstrogenResult.add(chemicalEstrogenResult);
            			olChems.add(chemicalEstrogenResult);
//            			out.newLine();
//            			out.write(chemicalCorrelation.getChemicalname() + ",true" + "," + distance + "," + ae1 + "," + ae2);
//            			System.out.println(chemicalCorrelation.getChemicalname() + ",true" + "," + distance + "," + ae1 + "," + ae2);
            			lowjob.add("chemical_name", chemicalCorrelation.getChemicalname());
            			lowjob.add("is_estrogenic", true);
            			lowjob.add("distance", distance);
            			lowjob.add("xcoord", ae1.doubleValue());
            			lowjob.add("ycoord", ae2.doubleValue());
            			jsonArrayBuilder.add(lowjob);
            			q++;
            		}
            		else{
            			ChemicalEstrogenResult chemicalEstrogenResult = new ChemicalEstrogenResult(
            					chemicalCorrelation.getChemicalname(), false, distance, ae1, ae2, q);
            			alChemicalEstrogenResult.add(chemicalEstrogenResult);
            			olChems.add(chemicalEstrogenResult);
//            			out.newLine();
//            			out.write(chemicalCorrelation.getChemicalname() + ",false" + "," + distance + "," + ae1 + "," + ae2);
//            			System.out.println(chemicalCorrelation.getChemicalname() + ",false" + "," + distance + "," + ae1 + "," + ae2);
            			lowjob.add("chemical_name", chemicalCorrelation.getChemicalname());
            			lowjob.add("is_estrogenic", false);
            			lowjob.add("distance", distance);
            			lowjob.add("xcoord", ae1.doubleValue());
            			lowjob.add("ycoord", ae2.doubleValue());
            			jsonArrayBuilder.add(lowjob);
            			q++;
            		}
                }
            	JsonArray jsonArray = jsonArrayBuilder.build();
            	jsonWriter.writeArray(jsonArray);
            	jsonWriter.close();
//            	out.flush();
//            	out.close();
//            	fileWriter.close();
            	System.out.println("done!");
            	
//            	columnID.setCellValueFactory(
//            			new PropertyValueFactory<ChemicalEstrogenResult, Integer>("id"));
//            	columnName.setCellValueFactory(
//            			new PropertyValueFactory<ChemicalEstrogenResult, String>("chemicalName"));
//            	
//            	columnEstrogenic.setCellValueFactory(
//            			new PropertyValueFactory<ChemicalEstrogenResult, Boolean>("isEstrogenic"));
            	
            	resultTable.setItems(olChems);
            	columnID.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
                columnName.setCellValueFactory(cellData -> cellData.getValue().chemicalNameProperty());
                columnEstrogenic.setCellValueFactory(cellData -> cellData.getValue().isEstrogenicProperty());
            	
                webView.setVisible(true);
                webEngine = webView.getEngine();
                if(!webEngine.isJavaScriptEnabled()){
                	webEngine.setJavaScriptEnabled(true);
                }
                //webEngine.setJavaScriptEnabled(true);
                File file2 = new File("index.html");
                webEngine.load(file2.toURI().toURL().toString());
                
            }
            catch(IOException e){
            	e.printStackTrace();
            }
        }
        
    }
	
	private void parseEstradiolInput(){
		Path filepath = Paths.get("in_vitro_estradiol.txt");
		try (BufferedReader reader = Files.newBufferedReader(filepath,
                StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 1;
            hmEstradiolAssayData.put("ATG_CIS", new double[50]);
            hmEstradiolAssayData.put("ATG_TRANS", new double[50]);
            hmEstradiolAssayData.put("NVS_NR_hER", new double[50]);
            hmEstradiolAssayData.put("OT_ER_ERaERa_0480", new double[50]);
            hmEstradiolAssayData.put("OT_ER_ERaERa_1440", new double[50]);
            hmEstradiolAssayData.put("OT_ER_ERaERb_0480", new double[50]);
            hmEstradiolAssayData.put("OT_ER_ERaERb_1440", new double[50]);
            hmEstradiolAssayData.put("OT_ER_ERbERb_0480", new double[50]);
            hmEstradiolAssayData.put("OT_ER_ERbERb_1440", new double[50]);
            hmEstradiolAssayData.put("TOX21_ERa_BLA_Agonist", new double[50]);
            while ((line = reader.readLine()) != null) {
            	if(lineNumber > 1){
            		String[] entries = line.split("\t");
            		hmEstradiolAssayData.get("ATG_CIS")[lineNumber-2] = Double.parseDouble(entries[0]);
            		hmEstradiolAssayData.get("ATG_TRANS")[lineNumber-2] = Double.parseDouble(entries[1]);
            		hmEstradiolAssayData.get("NVS_NR_hER")[lineNumber-2] = Double.parseDouble(entries[2]);
            		hmEstradiolAssayData.get("OT_ER_ERaERa_0480")[lineNumber-2] = Double.parseDouble(entries[3]);
            		hmEstradiolAssayData.get("OT_ER_ERaERa_1440")[lineNumber-2] = Double.parseDouble(entries[4]);
            		hmEstradiolAssayData.get("OT_ER_ERaERb_0480")[lineNumber-2] = Double.parseDouble(entries[5]);
            		hmEstradiolAssayData.get("OT_ER_ERaERb_1440")[lineNumber-2] = Double.parseDouble(entries[6]);
            		hmEstradiolAssayData.get("OT_ER_ERbERb_0480")[lineNumber-2] = Double.parseDouble(entries[7]);
            		hmEstradiolAssayData.get("OT_ER_ERbERb_1440")[lineNumber-2] = Double.parseDouble(entries[8]);
            		hmEstradiolAssayData.get("TOX21_ERa_BLA_Agonist")[lineNumber-2] = Double.parseDouble(entries[9]);
            	}
            	lineNumber++;
            }
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void setStage(Stage stage){
		this.stage = stage;
	}

}
