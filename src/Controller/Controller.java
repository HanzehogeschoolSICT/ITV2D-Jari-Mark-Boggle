package Controller;

import Model.Model;
import View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.locks.Lock;

/**
 * Created by mark on 9-3-2017.
 */
public class Controller implements Initializable {


    @FXML
    private ComboBox combobox;
    private Model model;
    private View view;
    private BottomController bottom;





    public View getView() {
        return view;
    }

    public void changecombobox(){

    }
    public void SetSize(ActionEvent event){
        String set= ((ComboBox)event.getSource()).getSelectionModel().getSelectedItem().toString();
        int arraysize = Integer.parseInt(set.substring(0,set.indexOf("x")));
        model.setarraysize(arraysize);
        bottom.update(model.getallfound());


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    for (int i= 2;i<=10;i++ ){
         combobox.getItems().add(i+"x"+i);}
         Init(model,view, bottom);
    }

    public void Init(Model model, View view,BottomController bottom){
        this.model= model;
        this.view =view;
        this.bottom= bottom;
    }
}
