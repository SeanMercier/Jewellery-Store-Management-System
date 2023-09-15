package com.example.assignment1;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;


public class DisplayTrayList {
    Node head=null;

    public void addDisplayTray(DisplayTray DT){
        Node dtnode=new Node();
        dtnode.contents=DT;
        dtnode.nextNode=head;
        head=dtnode;
    }

   public void addToComboBox(ComboBox trayview){
        trayview.getItems().clear();
        Node temp = head;
        while(temp!=null){
            trayview.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

    public void addToItemList(ObservableList ol){
        ol.clear();
        Node temp = head;
        while(temp!=null){
            ol.add(temp.contents);
            temp = temp.nextNode;
        }
    }

    public void addToListView(ListView trayview){
        trayview.getItems().clear();
        Node temp = head;
        while(temp!=null){
            trayview.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }
}
