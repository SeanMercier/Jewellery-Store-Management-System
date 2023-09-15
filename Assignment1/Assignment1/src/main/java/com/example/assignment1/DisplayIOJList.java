package com.example.assignment1;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class DisplayIOJList {
    Node head=null;
    public void addIOJ(ItemOfJewellery IOJ) {
            Node iojnode=new Node();
            iojnode.contents=IOJ;
            iojnode.nextNode=head;
            head=iojnode;
        }

    public void addToComboBox(ComboBox iojview){
        iojview.getItems().clear();
        Node temp = head;
        while(temp!=null){
            iojview.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

        public void addToListView(ListView iojview){
            iojview.getItems().clear();
            Node temp = head;
            while(temp!=null){
                iojview.getItems().add(temp.contents);
                temp = temp.nextNode;
            }
        }

        //Removes the selected item of jewellery from the linked list by skipping the selected item once the list updates.
        public void removeIOJ(ItemOfJewellery IOJ){
            if(head.contents.equals(IOJ)) {
                head = head.nextNode;
            }
            else {
                Node temp=head;
                while(temp.nextNode != null){
                    if(temp.nextNode.contents.equals(IOJ)){
                        temp.nextNode = temp.nextNode.nextNode; break;}
                    temp = temp.nextNode;
                }
            }
        }
    }

