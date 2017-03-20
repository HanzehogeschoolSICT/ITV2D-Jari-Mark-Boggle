package View;

import Model.Cell;
import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class View implements Initializable {
    private Model model;
    private Cell[][] array;

    @FXML
    private Canvas drawvas;
    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = drawvas.getGraphicsContext2D();
    }


    public void InitModel(Model model) {
        this.model = model;
        updateview();
    }

    public void updateview() {
        this.array = model.getArray();
        clear();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                DrawRectangle(i, j, new ArrayList<Cell>());
            }
        }
    }

    public void updateview(ArrayList<Cell> found) {
        this.array = model.getArray();
        clear();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                DrawRectangle(i, j, found);
            }
        }
    }

    public void DrawRectangle(int xaxis, int yaxis, ArrayList<Cell> found) {
        double xoffset = (drawvas.getWidth() / array.length);
        double yoffset = (drawvas.getHeight() / array.length);
        double textheight = yoffset / 4;
        gc.setStroke(Color.DARKGREY);

        InnerShadow is = new InnerShadow();
        is.setOffsetX(2);
        is.setOffsetY(2);
        is.setColor(Color.DIMGREY);
        if (found.contains(array[xaxis][yaxis])) {
            gc.setFill(Color.rgb(160 + (80 / found.size() * found.indexOf(array[xaxis][yaxis])), 248, 255));
        } else {
            gc.setFill(Color.ALICEBLUE);

        }
        gc.setEffect(is);
        gc.fillRect((xaxis) * xoffset, (yaxis) * yoffset, xoffset, yoffset);

        gc.setEffect(null);

        gc.setFill(Color.BLACK);
        gc.setFontSmoothingType(FontSmoothingType.LCD);
        gc.setFont(Font.font("Helvetica", FontWeight.BOLD, textheight));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);

        gc.fillText(Character.toString(model.getArray()[xaxis][yaxis].getContent()), (xaxis) * xoffset + xoffset / 2, (yaxis) * yoffset + xoffset / 2);
        gc.strokeRect(xaxis * xoffset, yaxis * yoffset, xoffset, yoffset);
    }

    public void clear() {
        gc.clearRect(0, 0, drawvas.getWidth(), drawvas.getHeight());
    }
}
