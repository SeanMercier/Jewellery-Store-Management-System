package com.example.assignment1;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MaterialController {
    public TextField materialdescription;
    public TextField txtmatquantity;
    public ComboBox cboxmatquality;
    public ComboBox cboxmattype;

    public ComboBox<DisplayCase> popcbcase;
    public ComboBox<DisplayTray> populatetraysmat;
    public ComboBox<ItemOfJewellery> popcbioj;

    public ListView<Material> lstofMaterials;

    public void addMaterial() {
        String description=materialdescription.getText();
        Material mats = new Material("",description,0,0);
        mats.setMatname(cboxmattype.getSelectionModel().getSelectedItem().toString());
        mats.setMatquantity(Double.parseDouble(txtmatquantity.getText().toString()));
        mats.setMatquality(Integer.parseInt(cboxmatquality.getSelectionModel().getSelectedItem().toString()));
        popcbioj.getSelectionModel().getSelectedItem().displaymats.addMaterial(mats);
        System.out.println(popcbioj.getSelectionModel().getSelectedItem().displaymats.head.contents);
        populateMatListView();
    }

    public void initialize() {
        cboxmatquality.getItems().addAll("1","2","3","4","5","6", "7","8","9","10");
        cboxmattype.getItems().addAll("Gold", "Platinum", "Diamond", "Emerald", "Silver","Ruby");
        populatematcase();
    }

    public void populatematcase(){
        popcbioj.getItems().clear();
    }

    public void populateMatListView(){
        popcbioj.getSelectionModel().getSelectedItem().displaymats.addToListView(lstofMaterials);
    }

    public void populatedisplaycasemat(){
        popcbcase.getItems().clear();
        JewelleryApplication.displaycases.addToCombo(popcbcase);
    }

    public void populatetraysmat(){
        DisplayCase dc;
        dc=popcbcase.getSelectionModel().getSelectedItem();
        if(dc != null) {
            populatetraysmat.getItems().clear();
            dc.displaytrays.addToComboBox(populatetraysmat);
        }
    }

    public void populateiojsmat(){
        DisplayCase dc2;
        DisplayTray dt;
        dc2=popcbcase.getSelectionModel().getSelectedItem();
        dt=populatetraysmat.getSelectionModel().getSelectedItem();
        if(dc2 != null) {
            populatetraysmat.getItems().clear();
            dc2.displaytrays.addToComboBox(populatetraysmat);
            if(dt != null) {
                popcbioj.getItems().clear();
                dt.displayiojs.addToComboBox(popcbioj);
            }
        }
    }
}
