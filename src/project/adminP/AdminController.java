package project.adminP;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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


    private DbConnection dc;
    private ObservableList<UserData> data ;
    private String sqlStart ="SELECT * FROM USER";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dc = new DbConnection();
        System.out.println("initialize Admin controler");
        loadUserData();
    }

  @FXML
    private void loadUserData() {
        try{
            Connection conn = DbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sqlStart);
            while(rs.next()){
                this.data.add(new UserData(rs.getString(1), rs.getString(2),rs.getString(3)
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
        this.userTable.setItems(this.data);
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



}
