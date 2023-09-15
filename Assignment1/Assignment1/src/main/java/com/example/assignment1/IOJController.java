package com.example.assignment1;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class IOJController {


    public TextField IOJname;
    public ListView<ItemOfJewellery> lstItemofj;
    public ListView searchediojlist;
    public ComboBox cboxgender;
    public ComboBox cboxtype2;
    public ComboBox<DisplayCase> popdcaseioj;
    public ComboBox<DisplayTray> popdtrayioj;
    public TextField textiojprice;
    public Label lblvtotalvalue;

    public TextField txtfieldsearchioj;

    public void addIOJ() {
        String name=IOJname.getText();
        ItemOfJewellery ioj = new ItemOfJewellery(name,"","",0,"");
        ioj.setType(cboxtype2.getSelectionModel().getSelectedItem().toString());
        ioj.setGender(cboxgender.getSelectionModel().getSelectedItem().toString());
        ioj.setRetailprice(Double.parseDouble(textiojprice.getText().toString()));
        ioj.setImage(ioj.getImage());
        popdtrayioj.getSelectionModel().getSelectedItem().displayiojs.addIOJ(ioj);
        System.out.println(popdtrayioj.getSelectionModel().getSelectedItem().displayiojs.head.contents);
        populateIOJListView();
    }

    //removes the selected item in the item of jewellery list view.
    public void deleteIOJ() {
        if(popdtrayioj.getSelectionModel().getSelectedIndex()>=0){
            ItemOfJewellery item = lstItemofj.getSelectionModel().getSelectedItem();
            popdtrayioj.getSelectionModel().getSelectedItem().displayiojs.removeIOJ(item);
            populateIOJListView();
        }
    }

    public void initialize(){
        cboxgender.getItems().addAll("Male","Female","Other");
        cboxtype2.getItems().addAll("Ring","Necklace","Bracelet","Watch","Earring");
        populateiojcase();
    }

    public void populateiojcase(){
        popdtrayioj.getItems().clear();
    }

    public void populateIOJListView(){
        popdtrayioj.getSelectionModel().getSelectedItem().displayiojs.addToListView(lstItemofj);
    }

    public void populatedisplaycaseioj(){
        popdcaseioj.getItems().clear();
        JewelleryApplication.displaycases.addToCombo(popdcaseioj);
    }

    public void populatetraycase(){
        DisplayCase dc;
        dc=popdcaseioj.getSelectionModel().getSelectedItem();
        if(dc != null) {
            popdtrayioj.getItems().clear();
            dc.displaytrays.addToComboBox(popdtrayioj);
        }
    }

    public void valueAllStock(){
        double totalval = 0;
        Node tempDC = JewelleryApplication.displaycases.head;
        while (tempDC != null) {
            Node tempDT = ((DisplayCase) (tempDC.contents)).displaytrays.head;
            while (tempDT != null) {
                Node tempIOJ = ((DisplayTray) (tempDT.contents)).displayiojs.head;
                while(tempIOJ != null){
                    totalval += ((ItemOfJewellery) (tempIOJ.contents)).getRetailprice();
                    tempIOJ = tempIOJ.nextNode;
                }
                tempDT = tempDT.nextNode;
            }
            tempDC = tempDC.nextNode;
        }
        lblvtotalvalue.setText("Total Value of the Stock : € " + totalval);
    }

    public void viewStockValue(){
        valueAllStock();
    }

    public void searchIOJ() {
        searchediojlist.getItems().clear();
        String iojsearched = txtfieldsearchioj.getText();
        Node tempDC2 = JewelleryApplication.displaycases.head;
        while (tempDC2 != null) {
            Node tempDT2 = ((DisplayCase) (tempDC2.contents)).displaytrays.head;
            while (tempDT2 != null) {
                Node tempIOJ2 = ((DisplayTray) (tempDT2.contents)).displayiojs.head;
                while (tempIOJ2 != null) {
                    if(iojsearched.equals(((ItemOfJewellery) (tempIOJ2.contents)).getItemDescription())){
                        searchediojlist.getItems().add(tempIOJ2.contents);
                    }
                    Node tempMAT2 = ((ItemOfJewellery) (tempIOJ2.contents)).displaymats.head;
                    while (tempMAT2 != null) {
                        if (iojsearched.equals(((ItemOfJewellery) (tempIOJ2.contents)).getItemDescription()))
                        searchediojlist.getItems().add(tempMAT2.contents);
                        tempMAT2 = tempMAT2.nextNode;
                    }
                    tempIOJ2 = tempIOJ2.nextNode;
                }
                tempDT2 = tempDT2.nextNode;
            }
            tempDC2 = tempDC2.nextNode;
        }
    }

}
