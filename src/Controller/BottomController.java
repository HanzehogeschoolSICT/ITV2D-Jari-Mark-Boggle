package Controller;

import Model.Model;
import Model.Cell;
import View.View;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringJoiner;

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
        view.updateview();
    }
    public void fillComboBox(){
       printer();
       solutionsbox.getItems().clear();
       solutionsbox.setPromptText("Amount of words found: "+allfound.size());
        for (int i= 0;i<allfound.size();i++ ){
            String str = ": ";
            for (int j=0;j<allfound.get(i).size();j++) {
                str+= allfound.get(i).get(j).getContent();
            }
            solutionsbox.getItems().add(i+str);
        }
    }


    //add combo box change listener which will only send the needed allfound list... so that it is easy to view
    public void selectfound(ActionEvent event){
        if (!solutionsbox.getItems().isEmpty()) {
            String str = ((ComboBox) event.getSource()).getSelectionModel().getSelectedItem().toString();
            int index = Integer.parseInt(str.substring(0, str.indexOf(":")));
            System.out.println(index);
            view.updateview(allfound.get(index));
        }
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