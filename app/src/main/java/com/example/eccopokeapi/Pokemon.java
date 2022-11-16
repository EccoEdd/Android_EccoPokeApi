package com.example.eccopokeapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pokemon {

    @JsonProperty("name")
    public String name;

    @JsonProperty("name")
    public String getName() {return name;}

    /*private final String name;

    public Pokemon(String name){
        this.name = name;
    }*/
}
