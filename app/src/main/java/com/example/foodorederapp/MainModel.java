package com.example.foodorederapp;

public class MainModel {
    Integer image;
    String imagename,imageprice;

    public MainModel(Integer image, String imagename,String imageprice){
        this.image=image;
        this.imagename=imagename;
        this.imageprice=imageprice;
    }
    public Integer getImage(){
        return image;
    }
    public String getImagename(){
        return imagename;
    }
    public String getImageprice(){
        return imageprice;
    }
}
