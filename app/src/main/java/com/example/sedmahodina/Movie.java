package com.example.sedmahodina;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("name")
    public String name;
    @SerializedName("description")
    public String description;
    @SerializedName("image")
    public String image;

}
