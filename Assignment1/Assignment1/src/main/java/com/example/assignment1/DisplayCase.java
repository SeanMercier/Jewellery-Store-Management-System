package com.example.assignment1;

public class DisplayCase {

    //Fields
    private String casename;
    private String type;
    private boolean lighting;

    //List of trays
    public DisplayTrayList displaytrays=new DisplayTrayList();

    //Constructor
    public DisplayCase(String casename, String type, boolean lighting) {
        this.casename = casename;
        this.type = type;
        this.lighting = lighting;
    }


    //Methods
    @Override
    public String toString() {
        return "DisplayCase: " +
                 casename + ".   Type: " +
                 type + ".   Lighting: " +
                 lighting +
                '.';
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isLighting() {
        return lighting;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

}