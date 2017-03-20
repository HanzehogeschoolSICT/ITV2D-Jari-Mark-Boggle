package Controller;

import Model.Cell;
import Model.Model;
import View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BottomController implements Initializable {
    private ArrayList<ArrayList<Cell>> allfound;
    private View view;
    private Model model;
    @FXML
    private ComboBox solutionsbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void Init(Model model, View view) {
        this.model = model;
        this.view = view;
        update(model.getallfound());
    }

    public void update(ArrayList<ArrayList<Cell>> allfound) {
        this.allfound = allfound;
        fillComboBox();
        view.updateview();
    }

    public void fillComboBox() {
        solutionsbox.getItems().clear();
        solutionsbox.setPromptText("Amount of words found: " + allfound.size());
        for (int i = 0; i < allfound.size(); i++) {
            String str = ": ";
            for (int j = 0; j < allfound.get(i).size(); j++) {
                str += allfound.get(i).get(j).getContent();
            }
            solutionsbox.getItems().add(i + 1 + str);
        }
    }

    public void selectfound(ActionEvent event) {
        if (!solutionsbox.getItems().isEmpty()) {
            String str = ((ComboBox) event.getSource()).getSelectionModel().getSelectedItem().toString();
            int index = Integer.parseInt(str.substring(0, str.indexOf(":"))) - 1;
            view.updateview(allfound.get(index));
        }
    }


}
