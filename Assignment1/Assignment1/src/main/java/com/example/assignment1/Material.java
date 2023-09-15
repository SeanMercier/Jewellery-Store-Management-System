package com.example.assignment1;

public class Material {

    private String matname;
    private String matdescription;
    private double matquantity;
    private int matquality;

    public Material(String matname, String matdescription, double matquantity, int matquality) {
        this.matname = matname;
        this.matdescription = matdescription;
        this.matquantity = matquantity;
        this.matquality = matquality;
    }

    @Override
    public String toString() {
        return "Material: " +
                matname + ".    Description:  " +
                matdescription + ".    Quality level: " +
                matquality + ".    Quantity: " +
                matquantity +
                " grams.";
    }


    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public String getMatdescription() {
        return matdescription;
    }

    public void setMatdescription(String matdescription) {
        this.matdescription = matdescription;
    }

    public double getMatquantity() {
        return matquantity;
    }

    public void setMatquantity(double matquantity) {
        this.matquantity = matquantity;
    }

    public int getMatquality() {
        return matquality;
    }

    public void setMatquality(int matquality) {
        this.matquality = matquality;
    }

}
