package Controller;

import Model.Model;
import View.View;

/**
 * Created by mark on 9-3-2017.
 */
public class Controller {
    private Model model;
    private View view;



public Controller(Model model,View view){
    this.view=view;
    this.model=model;
}
}
