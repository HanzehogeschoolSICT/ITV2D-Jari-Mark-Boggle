package View;

import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class View implements Initializable {
    private Model model;

    @FXML
    private Canvas drawvas;



    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
    public void InitModel(Model model){
        this.model = model;
        for (int i=0;i<model.getArraysize(); i++) {
        for (int j=0;j<model.getArraysize(); j++) {
            DrawRectangle(i,j);
        }
        }
    }

    public void DrawRectangle(int xaxis, int yaxis,Color col){

        gc = drawvas.getGraphicsContext2D();
        double xoffset=  (drawvas.getWidth()/model.getArraysize());
        double yoffset=  (drawvas.getHeight()/model.getArraysize());
        gc.setFill(col);
        gc.setStroke(Color.DARKGREY);
        gc.fillRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);
        gc.strokeRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);



    }
    public void DrawRectangle(int xaxis, int yaxis){
        gc = drawvas.getGraphicsContext2D();
        double xoffset=  (drawvas.getWidth()/model.getArraysize());
        double yoffset=  (drawvas.getHeight()/model.getArraysize());
        gc.setFill(Color.ALICEBLUE);
        gc.setStroke(Color.DARKGREY);
        gc.fillRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);
        gc.strokeRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);
    }

}
