package project.adminP;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import project.bdUtil.DbConnection;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.ResultSet;

public class AdminController implements Initializable {

    // elementy pierwszej zakładki User
    @FXML private TextField tfFirstName;
    @FXML private TextField tfLastName;
    @FXML private TextField tfEmail;
    @FXML private DatePicker dpDateOfBirth;
    @FXML private TableView<UserData> userTable;
    @FXML private TableColumn<UserData, String> idColumn;
    @FXML private TableColumn<UserData, String> firstNameColumn;
    @FXML private TableColumn<UserData, String> lastNameColumn;
    @FXML private TableColumn<UserData, String> emailColumn;
    @FXML private TableColumn<UserData, String> doBColumn;

    //elementy zakładki Attraction
    @FXML private TextField tfAtractionName;
    @FXML private TextField tfAtractionLocation;
    @FXML private TextArea taAttractionDescription;
    @FXML private TableView<AttractionData> attractionTable;
    @FXML private TableColumn<AttractionData, String> columnAttractionId;
    @FXML private TableColumn<AttractionData, String> columnAttractionName;
    @FXML private TableColumn<AttractionData, String> columnAttractionLocation;
    @FXML private TableColumn<AttractionData, String> columnAttractionDescription;

    private DbConnection dc;
    private ObservableList<UserData> dataUser ;
    private ObservableList<AttractionData> dataAttr ;

    //private String sqlStart ="SELECT * FROM USER";
    private String sqlStart ="SELECT * FROM ";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dc = new DbConnection();
        System.out.println("initialize Admin controler");
        loadUserData();
    }
    //user function
    @FXML
    private void loadUserData() {
        try{
            Connection conn = DbConnection.getConnection();
            this.dataUser = FXCollections.observableArrayList();
            System.out.println("userLoad");

            ResultSet rs = conn.createStatement().executeQuery(sqlStart+"USER");
            while(rs.next()){
                this.dataUser.add(new UserData(rs.getString(1), rs.getString(2),rs.getString(3)
                        ,rs.getString(4),rs.getString(5)));
            }

        }catch ( SQLException ex){
            ex.printStackTrace();
            System.err.println("Error:" + ex);
        }

        this.idColumn.setCellValueFactory(new PropertyValueFactory<UserData,String>("idSend"));
        this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<UserData,String>("firstName"));
        this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<UserData,String>("lastName"));
        this.emailColumn.setCellValueFactory(new PropertyValueFactory<UserData,String>("email"));
        this.doBColumn.setCellValueFactory(new PropertyValueFactory<UserData,String>("DoB"));

        this.userTable.setItems(null);
        this.userTable.setItems(this.dataUser);
    }

    @FXML
    private void addUser(ActionEvent Event){
        String sqlInsert = "INSERT INTO USER(US_ID,US_NAME,US_SNAME,US_EMAIL,US_DOB) VALUES (?,?,?,?,?);";
        try{
           Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            int tempID = new IdBananas().bananasFuction("userID");
            stmt.setString(1,String.valueOf(tempID));
            stmt.setString(2,this.tfFirstName.getText());
            stmt.setString(3,this.tfLastName.getText());
            stmt.setString(4,this.tfEmail.getText());
            stmt.setString(5,this.dpDateOfBirth.getEditor().getText());

            stmt.execute();
            conn.close();

        }catch (SQLException ex){
            ex.printStackTrace();
            System.err.println("Error:" + ex);
        }finally {
            loadUserData();
        }
    }

    @FXML
    private void clearFields(ActionEvent event){
        this.idColumn.setText("");
        this.tfFirstName.setText("");
        this.tfLastName.setText("");
        this.tfEmail.setText("");
        this.dpDateOfBirth.setValue(null);
    }

    // Attraction funcion   this.dataAttr = FXCollections.observableArrayList();

    @FXML
    private void loadAttractionData() {
        try {
            Connection conn = DbConnection.getConnection();
            this.dataAttr = FXCollections.observableArrayList();
            System.out.println("attractionLoad");

            ResultSet rs = conn.createStatement().executeQuery(sqlStart + "ATTRACTION");
            System.out.println("przed while");
            while (rs.next()) {
                this.dataAttr.add(new AttractionData(rs.getString(1), rs.getString(2), rs.getString(3)
                        , rs.getString(4)));
            }
            System.out.println("loadAttractionData try end ");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error:" + ex);
        }

        this.columnAttractionId.setCellValueFactory(new PropertyValueFactory<AttractionData,String>("idAttractionSend"));
        this.columnAttractionName.setCellValueFactory(new PropertyValueFactory<AttractionData,String>("attractionName"));
        this.columnAttractionLocation.setCellValueFactory(new PropertyValueFactory<AttractionData,String>("attractionLocation"));
        this.columnAttractionDescription.setCellValueFactory(new PropertyValueFactory<AttractionData,String>("attractionDescription"));
        System.out.println("loadAttractionData setproperty value ");
        this.attractionTable.setItems(null);
        this.attractionTable.setItems(this.dataAttr);
        System.out.println("loadAttractionData last line");
    }
    @FXML
    private void addAttraction(ActionEvent Event){
        String sqlInsert = "INSERT INTO ATTRACTION(ATT_ID,ATT_NAME,ATT_ADRESS,ATT_DESCRIPTION) VALUES (?,?,?,?);";
        try{
            System.out.println("przed conn");
            Connection conn = DbConnection.getConnection();
            System.out.println("po conn");
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            int tempID = new IdBananas().bananasFuction("AttractionID");
            System.out.println("temp id : "+tempID);
            stmt.setString(1,String.valueOf(tempID));
            stmt.setString(2,this.tfAtractionName.getText());
            stmt.setString(3,this.tfAtractionLocation.getText());
            stmt.setString(4,this.taAttractionDescription.getText());


            stmt.execute();
            conn.close();

        }catch (SQLException ex){
            ex.printStackTrace();
            System.err.println("Error:" + ex);
        }finally {
            loadAttractionData();
        }
    }




}
