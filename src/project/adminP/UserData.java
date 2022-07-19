package project.adminP;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData  {

    private final StringProperty idSend;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty email;
    private final StringProperty DoB;
    //  idSend  firstName   lastName    email    DoB

    //int id
    public UserData(String idsend, String firstname, String lastname, String email, String dob ) {
        this.idSend = new SimpleStringProperty(idsend);
        this.firstName = new SimpleStringProperty(firstname);
        this.lastName = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.DoB = new SimpleStringProperty(dob);
    }


    public String getIdSend() {
        return idSend.get();
    }
    public StringProperty idSendProperty() {
        return idSend;
    }
    public void setIdSend(String idSend) {
        this.idSend.set(idSend);
    }
    public String getFirstName() {
        return firstName.get();
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    public String getLastName() {
        return lastName.get();
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    public String getEmail() {
        return email.get();
    }
    public StringProperty emailProperty() {
        return email;
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public String getDoB() {
        return DoB.get();
    }
    public StringProperty doBProperty() {
        return DoB;
    }
    public void setDoB(String doB) {
        this.DoB.set(doB);
    }



}
