package sample;

import Model.Model;
import View.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private View view;
    private Model model;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/sample.fxml"));
        this.view = new View();
        loader.setController(view);
        GridPane root = loader.load();


        //Creating and connecting model
        model = new Model();
        view.InitModel(model);



        // futher initializatipn;;
        primaryStage.setTitle("Boggle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
