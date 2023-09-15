package com.example.assignment1;

import javafx.scene.control.*;


public class DisplaytrayController {

    //fields
    public TextField trayname;
    public ComboBox cboxwidth;
    public ComboBox cboxheight;
    public ListView lstDisplayTray;
    public ComboBox<DisplayCase> dtcase;
    public ColorPicker colorpicker;


    public void addDisplayTray(){
        String name=trayname.getText();
        DisplayTray dt = new DisplayTray(name,"",0, 0);
        dt.setTrayIdentifier(dt.getTrayIdentifier());
        dt.setTrayColor(colorpicker.getValue().toString());
        dt.setTrayWidth(Integer.parseInt(cboxwidth.getSelectionModel().getSelectedItem().toString()));
        dt.setTrayHeight(Integer.parseInt(cboxheight.getSelectionModel().getSelectedItem().toString()));
        dtcase.getSelectionModel().getSelectedItem().displaytrays.addDisplayTray(dt);
        System.out.println(dtcase.getSelectionModel().getSelectedItem().displaytrays.head.contents);
        populateTrayListView();
    }

    public void populateTrayListView(){
        dtcase.getSelectionModel().getSelectedItem().displaytrays.addToListView(lstDisplayTray);
    }

    public void populatedtcase(){
        dtcase.getItems().clear();
        JewelleryApplication.displaycases.addToCombo(dtcase);
    }

    public void initialize(){
      cboxheight.getItems().addAll(10,20,30,40,50,60,70,80,90,100);
      cboxwidth.getItems().addAll(10,20,30,40,50,60,70,80,90,100);
      populatedtcase();
    }

}