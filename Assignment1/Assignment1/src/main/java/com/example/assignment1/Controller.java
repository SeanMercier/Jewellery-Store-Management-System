package com.example.assignment1;

import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
public class Controller {

    //fields

    public TextField textname;
    public ListView lstDisplayCase;
    public ListView viewStockList;
    public ComboBox cboxtype;
    @FXML
    public CheckBox lightingcheckbox;


    //methods

    public void addDisplayCase() {
        String name=textname.getText(); //passes the text from the text field in as the case name
        DisplayCase dc = new DisplayCase(name,"",true);
        boolean lighting= lightingcheckbox.isSelected();
        dc.setLighting(lighting);
        dc.setType((String) cboxtype.getSelectionModel().getSelectedItem());
        JewelleryApplication.displaycases.addDisplayCase(dc);
        System.out.println(JewelleryApplication.displaycases.head.contents);
        populateListView();
    }

    public void lightonoff(){
    }

    //populates the list view of display cases with cases.
    public void populateListView(){
        JewelleryApplication.displaycases.addToListView(lstDisplayCase);
    }

    public void initialize(){
        cboxtype.getItems().addAll("Wall","Freestanding");
    }

    public void viewAllStock() {
        // goes through each display case, its corresponding trays and items of jewellery and adds each list to the stock list.
        viewStockList.getItems().clear();
        Node tempDC = JewelleryApplication.displaycases.head;
        while (tempDC != null) {
            Node tempDT = ((DisplayCase) (tempDC.contents)).displaytrays.head;
            viewStockList.getItems().add(((DisplayCase) (tempDC.contents)).toString());
            while (tempDT != null) {
                Node tempIOJ = ((DisplayTray) (tempDT.contents)).displayiojs.head;
                viewStockList.getItems().add("\t " + ((DisplayTray) (tempDT.contents)).toString());
                while(tempIOJ != null){
                    viewStockList.getItems().add("\t \t" + tempIOJ.contents);
                tempIOJ = tempIOJ.nextNode;
                }
                tempDT = tempDT.nextNode;
            }
            tempDC = tempDC.nextNode;
        }
    }

    //Calls the viewAllStock() method to populate the stock's listview.
    public void viewStockList(){
        viewAllStock();
    }

    //Resets the linked list
    public void reset(){
        JewelleryApplication.displaycases.head = null;
    }

    //calls the save() method which store all the cases, their corresponding trays, items of jewellery and materials in a list view.
    public void saveAll(){
        try {
            save();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //loads all the display cases in the listview
    public void loadAll() {
        try {
            load();
            populateListView();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{DisplayCaseList.class, DisplayCase.class, DisplayTrayList.class, DisplayTray.class, DisplayIOJList.class, ItemOfJewellery.class, DisplayMaterialList.class, Material.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Assignment1.xml"));
        JewelleryApplication.displaycases = (DisplayCaseList) is.readObject();
        is.close();

        //load all cases
        Node tempCase = JewelleryApplication.displaycases.head;
        lstDisplayCase.getItems().clear();

        while (tempCase != null){
            lstDisplayCase.getItems().add(tempCase);
            tempCase = tempCase.nextNode;
        }
    }

    /*
     * The save method uses the XStream component to write all the product objects in the products ArrayList
     * to the products.xml file stored on the hard disk.
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Assignment1.xml"));
        out.writeObject(JewelleryApplication.displaycases);
        out.close();
    }
}
