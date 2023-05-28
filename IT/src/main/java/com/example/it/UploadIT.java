package com.example.it;

public class UploadIT {
    public String name;
    public String url;
    public UploadIT(){
    }
    public UploadIT(String name, String url){
        this.name = name;
        this.url = url;
    }
    public String setName(){
        return name;
    }
    public String getUrl(){
        return url;
    }
}
