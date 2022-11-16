package com.example.eccopokeapi;

public class PokeModel {
    private final String mName;
    private int mId;
    private String mUrl;

    public PokeModel(String name){
        mName = name;
    }

    public PokeModel(String name, String url, int id){
        mName   = name;
        mUrl    = url;
        mId     = id;
    }

    public String getmName(){
        return mName;
    }
    public String getmUrl(){
        return mUrl;
    }
    public int getmId(){
        return mId;
    }
}
