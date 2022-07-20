package project.loginapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import project.adminP.IdBananas;

public class LoginApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("login");
        primaryStage.setScene(scene);
        //primaryStage.;
        primaryStage.show();

        String testy = String.valueOf(new IdBananas().bananasFuction("pliczek"));
        System.out.println(testy);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
