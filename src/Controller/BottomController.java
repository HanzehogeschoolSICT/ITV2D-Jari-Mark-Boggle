package Controller;

import Model.Model;
import View.View;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by mark on 11-3-2017.
 */
public class BottomController implements Initializable {
    private View view;
    private  Model model;
    @FXML
    private ComboBox solutionsbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Init(Model model, View view){
        this.model= model;
        this.view =view;
    }

}