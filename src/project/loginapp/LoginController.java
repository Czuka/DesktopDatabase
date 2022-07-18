package project.loginapp;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML private Label dbstatus;
    @FXML private Label loginStatus;
    @FXML private ComboBox<AcountEnum> cbAcount;
    @FXML private TextField tfUsername;
    @FXML private TextField tfPassword;
    @FXML private Button btnLogin;
    @FXML private Button tbnRestart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(this.loginModel.isDatabaseConnected() ){
            this.dbstatus.setText("Connected to Database");
        } else {
            this.dbstatus.setText("Not Connected to Database");
        }
        this.cbAcount.setItems(FXCollections.observableArrayList(AcountEnum.values()));
    }

    @FXML public void RestartEvent(ActionEvent event){
        System.out.println("restart buton");
        Stage stage = (Stage)this.tbnRestart.getScene().getWindow();
        stage.close();

        try {
            Stage restartStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("login.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            restartStage.setTitle("login");
            restartStage.setScene(scene);
            restartStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void  LoginEvent(ActionEvent event){
        try{
            System.out.println("Action eve"); //

            //zablokować brak wartości w comboboxie

            if (this.loginModel.isLogin(this.tfUsername.getText(), this.tfPassword.getText(), ((AcountEnum) this.cbAcount.getValue()).toString())) {
                System.out.println("logowanie przeszło"); //
                Stage stage = (Stage)this.btnLogin.getScene().getWindow();
                stage.close();

                switch (((AcountEnum) this.cbAcount.getValue()).toString()){
                    case "Admin":
                        adminLogin();
                        break;
                    case "User":
                        userLogin();
                        break;
                }
            }else{
                this.loginStatus.setText("Wrong Creditials");
            }
        }catch (Exception localExeption) {
            localExeption.printStackTrace();
        }
    }

    private void userLogin() {
        try{

            System.out.println("user login start");
            Stage userStage = new Stage();
            FXMLLoader loaderUser = new FXMLLoader();
            Pane rootUser = (Pane)loaderUser.load(getClass().getResource("/project/userP/UserFXML.fxml").openStream());
            Scene userScene = new Scene(rootUser);

            userStage.setScene(userScene);
            userStage.setTitle("User dashboard");
            userStage.show();

        }catch (IOException ex) {
            System.out.println("userLogin catch");
            ex.printStackTrace();
        }
    }

    private void adminLogin() {
        try {
            System.out.println("adminLogin");
            FXMLLoader loaderAdmin = new FXMLLoader(getClass().getResource("/project/adminP/adminFXML.fxml"));
            Parent rootAdmin = loaderAdmin.load();
            Stage stageAdmin = new Stage();

            stageAdmin.setTitle("Admin dashboard");
            stageAdmin.setScene(new Scene(rootAdmin));

            stageAdmin.show();
            System.out.println("after admin show");


        } catch (IOException ex) {
            System.out.println("adminLogin catch");
            ex.printStackTrace();
        }
    }
}
