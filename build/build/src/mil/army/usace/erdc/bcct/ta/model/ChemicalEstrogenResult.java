package mil.army.usace.erdc.bcct.ta.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ChemicalEstrogenResult {
	
	//private String chemicalName;
	//private boolean isEstrogenic;
	private SimpleStringProperty chemicalName;
	private SimpleBooleanProperty isEstrogenic;
	private SimpleIntegerProperty chemID;
	
	private double distance;
	private double xcoord;
	private double ycoord;
	
	public ChemicalEstrogenResult(String chemicalName, boolean isEstrogenic, double distance, double xcoord, double ycoord, int id){
		this.chemicalName = new SimpleStringProperty(chemicalName);
		this.isEstrogenic = new SimpleBooleanProperty(isEstrogenic);
		this.chemID = new SimpleIntegerProperty(id);
		this.distance = distance;
	}
	
	public SimpleStringProperty chemicalNameProperty(){
		return this.chemicalName;
	}
	
	public SimpleIntegerProperty idProperty(){
		return this.chemID;
	}
	
	public SimpleBooleanProperty isEstrogenicProperty(){
		return this.isEstrogenic;
	}
	
	
	
	public String getChemicalName(){
		return this.chemicalName.get();
	}
	
	public boolean getIsEstrogenic(){
		return this.isEstrogenic.get();
	}
	
	public int getID(){
		return this.chemID.get();
	}
	
	public double getDistance(){
		return this.distance;
	}
	
	public double getXCoord(){
		return this.xcoord;
	}
	
	public double getYCoord(){
		return this.ycoord;
	}

}
