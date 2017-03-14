package Main;

import Controller.*;
import Model.Model;
import View.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private View view;
    private Model model;
    private Controller controller;
    private BottomController bottom;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.model = new Model();
        this.controller = new Controller();
        this.bottom= new BottomController();
        this.view = new View();

        // Creating main pane;
        BorderPane root = new BorderPane();


        // setting up the center view and init
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/View.fxml"));
        loader.setController(view);
        root.setCenter(loader.load());
        view.InitModel(model);

        // setting up the top controlloader and init
        FXMLLoader controlloader = new FXMLLoader(getClass().getResource("/Controller/Controller.fxml"));
        controlloader.setController(controller);
        root.setTop(controlloader.load());
        controller.Init(model,view,bottom);

        // setting up the bottom controller and init
        FXMLLoader bottomloader = new FXMLLoader(getClass().getResource("/Controller/BottomController.fxml"));
        bottomloader.setController(bottom);
        root.setBottom(bottomloader.load());
        bottom.Init(model,view);


        // futher initialization
        primaryStage.setTitle("Boggle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
