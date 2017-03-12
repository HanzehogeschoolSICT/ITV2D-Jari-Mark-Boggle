package View;

import Model.Model;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

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
     gc = drawvas.getGraphicsContext2D();
    }


    public void InitModel(Model model){
        this.model = model;
        updateview();
    }

    public void updateview(){
        clear();
        for (int i=0;i<model.getArraysize(); i++) {
            for (int j=0;j<model.getArraysize(); j++) {
                DrawRectangle(i,j);
            }
        }
    }

    public void DrawRectangle(int xaxis, int yaxis,Color col){
        int tetheight=40;
        gc = drawvas.getGraphicsContext2D();
        double xoffset=  (drawvas.getWidth()/model.getArraysize());
        double yoffset=  (drawvas.getHeight()/model.getArraysize());
        gc.setFill(col);
        gc.setStroke(Color.DARKGREY);
        gc.fillRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);
        gc.strokeRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);



    }
    public void DrawRectangle(int xaxis, int yaxis){
        double xoffset=  (drawvas.getWidth()/model.getArraysize());
        double yoffset=  (drawvas.getHeight()/model.getArraysize());
        double textheight=yoffset/4;


        gc.setStroke(Color.DARKGREY);

        InnerShadow is = new InnerShadow();
        is.setOffsetX(2);
        is.setOffsetY(2);
        is.setColor(Color.DIMGREY);
        gc.setFill(Color.ALICEBLUE);
        gc.setEffect(is);
        gc.fillRect((xaxis)*xoffset,(yaxis)*yoffset,xoffset,yoffset);

        gc.setEffect(null);

        gc.setFill(Color.BLACK);
        gc.setFontSmoothingType(FontSmoothingType.LCD);
        gc.setFont(Font.font("Helvetica", FontWeight.BOLD, textheight));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);

        gc.fillText(Character.toString(model.getArray()[xaxis][yaxis].getContent()),(xaxis)*xoffset+xoffset/2,(yaxis)*yoffset+xoffset/2);
        gc.strokeRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);

    }

    public void clear(){
        gc.clearRect(0,0,drawvas.getWidth(),drawvas.getHeight());
    }
}
