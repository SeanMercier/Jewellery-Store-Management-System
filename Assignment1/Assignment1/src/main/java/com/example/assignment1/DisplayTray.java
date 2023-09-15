package com.example.assignment1;

public class DisplayTray {

    //List of items of jewellery
    public DisplayIOJList displayiojs=new DisplayIOJList();

    //fields
    private String trayIdentifier;
    private String trayColor;
    private int trayWidth;
    private int trayHeight;

    //constructor
    public DisplayTray(String trayIdentifier, String trayColor, int trayWidth, int trayHeight) {
        this.trayIdentifier = trayIdentifier;
        this.trayColor = trayColor;
        this.trayWidth = trayWidth;
        this.trayHeight = trayHeight;
    }

    @Override
    public String toString() {
        return "DisplayTray: " +
                trayIdentifier + ".  Colour: " +
                trayColor + ".  Height: " +
                trayHeight+ ".  Width " +
                trayWidth +
                '.';
    }

    //methods
    public String getTrayIdentifier() {
        return trayIdentifier;
    }

    public void setTrayIdentifier(String trayIdentifier) {
        this.trayIdentifier = trayIdentifier;
    }

    public String getTrayColor() {
        return trayColor;
    }

    public void setTrayColor(String trayColor) {
        this.trayColor = trayColor;
    }

    public int getTrayWidth(){
        return trayWidth;
    }

    public void setTrayWidth(int trayWidth){
        this.trayWidth = trayWidth;
    }

    public int getTrayHeight(){
        return trayHeight;
    }

    public void setTrayHeight(int trayHeight){
        this.trayHeight = trayHeight;
    }
}
