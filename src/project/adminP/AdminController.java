package project.adminP;

import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import project.bdUtil.DbConnection;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.ResultSet;



public class AdminController implements Initializable {

    @FXML private TextField tfFirstName;
    @FXML private TextField tfLastName;
    @FXML private TextField tfEmail;
    @FXML private TableView<UserData> UserTable;
    @FXML private TableColumn<UserData, String> idColumn;
    @FXML private TableColumn<UserData, String> firstNameColumn;
    @FXML private TableColumn<UserData, String> lastNameColumn;
    @FXML private TableColumn<UserData, String> emailColumn;
    @FXML private TableColumn<UserData, String> doBColumn;


    private DbConnection dc;
    private ObservableList<UserData> data ;
    private String sqlStart ="SELRCT * FROM USER";



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dc = new DbConnection();
    }

    @FXML
    private void loadUserData(ActionEvent event){
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


    }






}
