package com.example.assignment1;

public class ItemOfJewellery {

    //List of materials
    public DisplayMaterialList displaymats= new DisplayMaterialList();

    private String itemDescription;
    private String type;
    private String gender;
    private double retailprice;
    private String image;

    public ItemOfJewellery(String itemDescription, String type, String gender, double retailprice, String image) {
        this.itemDescription = itemDescription;
        this.type = type;
        this.gender = gender;
        this.retailprice = retailprice;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item of jewellery: " +
                itemDescription + ".    Gender: " +
                gender + ".    Type: " +
                type + ".    Price: " +
                "€" + retailprice +
                image +
                '.';
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(double retailprice) {
        this.retailprice = retailprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
