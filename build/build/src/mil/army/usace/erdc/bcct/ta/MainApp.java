package mil.army.usace.erdc.bcct.ta;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import mil.army.usace.erdc.bcct.ta.view.EventHandlerController;

public class MainApp extends Application {
	
	private Stage primaryStage;
	@FXML private WebView webview = new WebView();
	private WebEngine webengine = webview.getEngine();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("APECS (in vitro)");
		
        showPersonOverview();
	}
	
	public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

	public static void main(String[] args) {
		launch(args);
	}
}
