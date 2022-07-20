package project.adminP;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AttractionData {

    private final StringProperty idAttractionSend;
    private final StringProperty attractionName;
    private final StringProperty attractionLocation;
    private final StringProperty attractionDescription;
    // idAttractionSend attractionName attractionLocation attractionDescription

    public AttractionData(String idattractionsend, String attractionname,String attractionlocation,String attractiondescription){
        System.out.println("AttractionData start");
        this.idAttractionSend = new SimpleStringProperty(idattractionsend);
        this.attractionName = new SimpleStringProperty(attractionname);
        this.attractionLocation = new SimpleStringProperty(attractionlocation);
        this.attractionDescription = new SimpleStringProperty(attractiondescription);
        System.out.println("AttractionData end");
    }


    public String getIdAttractionSend() {
        return idAttractionSend.get();
    }
    public StringProperty idAttractionSendProperty() {
        return idAttractionSend;
    }
    public void setIdAttractionSend(String idAttractionSend) {
        this.idAttractionSend.set(idAttractionSend);
    }
    public String getAttractionName() {
        return attractionName.get();
    }
    public StringProperty attractionNameProperty() {
        return attractionName;
    }
    public void setAttractionName(String attractionName) {
        this.attractionName.set(attractionName);
    }
    public String getAttractionLocation() {
        return attractionLocation.get();
    }
    public StringProperty attractionLocationProperty() {
        return attractionLocation;
    }
    public void setAttractionLocation(String attractionLocation) {
        this.attractionLocation.set(attractionLocation);
    }
    public String getAttractionDescription() {
        return attractionDescription.get();
    }
    public StringProperty attractionDescriptionProperty() {
        return attractionDescription;
    }
    public void setAttractionDescription(String attractionDescription) {
        this.attractionDescription.set(attractionDescription);
    }
}
