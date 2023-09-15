package com.example.assignment1;

import javafx.scene.control.ListView;

public class DisplayMaterialList {

    Node head=null;

    public void addMaterial(Material material){
        Node matnode= new Node();
        matnode.contents=material;
        matnode.nextNode=head;
        head=matnode;
    }

    public void addToListView(ListView matview){
        matview.getItems().clear();
        Node temp = head;
        while(temp!=null){
            matview.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }
}
