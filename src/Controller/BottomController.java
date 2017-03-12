package Controller;

import Model.Model;
import Model.Cell;
import View.View;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by mark on 11-3-2017.
 */
public class BottomController implements Initializable {
    private ArrayList<ArrayList<Cell>> allfound;
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
        update(model.getallfound());
    }

    public void update(ArrayList<ArrayList<Cell>> allfound){
        this.allfound=allfound;
        fillComboBox();
    }
    public void fillComboBox(){
       printer();
    }

    public void printer(){
        System.out.println("---");
        for (int i= 0;i<allfound.size();i++ ){
            for (int j=0;j<allfound.get(i).size();j++) {

                System.out.print(allfound.get(i).get(j).getContent());
            }
            System.out.println();
        }
        System.out.println();
    }



}