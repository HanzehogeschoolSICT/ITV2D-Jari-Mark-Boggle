package sample;

import Controller.Controller;
import Model.Model;
import View.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private View view;
    private Model model;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.controller = new Controller();
        this.model = new Model();
        this.view = new View();
        // Creating main pane;
        BorderPane root = new BorderPane();


        // setting up the center view; // init
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/sample.fxml"));
        loader.setController(view);
        root.setCenter(loader.load());
        view.InitModel(model);

        // setting up the top controlloader. // init
        FXMLLoader controlloader = new FXMLLoader(getClass().getResource("/Controller/sample.fxml"));
        controlloader.setController(controller);
        root.setTop(controlloader.load());
        controller.Init(model,view);



        // futher initializatipn;;
        primaryStage.setTitle("Boggle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
