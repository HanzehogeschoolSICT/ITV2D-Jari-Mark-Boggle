package sample;

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

public class Controller implements Initializable {
    @FXML
    private Canvas drawvas;

    private int n=4;
    private char[][] array=new char[n][n];

    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\mark\\Dropbox\\jaar 2\\OOP3\\opdr\\week 2\\quicksort\\untitled1\\src\\TextFile\\dict.txt"));
            while ((line=input.readLine())!= null){
                System.out.println(line);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }

        //setting up the 2d array.

        for (int i = 0; i<array.length;i++){
            for (int j= 0; j<array.length;j++) {
                array[i][j] = CreateChar();
                DrawRectangle(i,j,Color.ALICEBLUE);
                System.out.println(array[i][j]);
            }
        }
    }

    public void DrawRectangle(int xaxis, int yaxis,Color col){

        gc = drawvas.getGraphicsContext2D();
        double xoffset=  (drawvas.getWidth()/n);
        double yoffset=  (drawvas.getHeight()/n);
        gc.setFill(col);
        gc.setStroke(Color.DARKGREY);
        gc.fillRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);
        gc.strokeRect(xaxis*xoffset,yaxis*yoffset,xoffset,yoffset);



    }

    public char CreateChar(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return c;
    }
}
