package com.example.assignment1;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class DisplayCaseList {

    Node head=null;


    public void addDisplayCase(DisplayCase DC){
        Node dcnode=new Node();
        dcnode.contents=DC;
        dcnode.nextNode=head;
        head=dcnode;
    }

    //clears the list view, if the head of the list isn't null, it adds the display case to the list and moves to the next node
    public void addToListView(ListView lw){
        lw.getItems().clear();
        Node temp = head;
        while(temp!=null){
            lw.getItems().add(temp.contents);
            temp = temp.nextNode;
        }

    }

    //populates the combo box with the list view of display cases
    public void addToCombo(ComboBox lw){
        lw.getItems().clear();
        Node temp = head;
        while(temp!=null){
            lw.getItems().add(temp.contents);
            temp = temp.nextNode;
        }

    }
}
