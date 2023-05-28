package com.example.electronics;

public class Upload3 {
    public String name ;
    public String url;
    public Upload3(){
    }
    public Upload3(String name, String url){
        this.name = name;
        this.url = url;
    }
    public String getName(){
        return name;
    }
    public String getUrl(){
        return url;
    }
}
