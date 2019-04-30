package com.example.sedmahodina;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance { // singleton

    private static Retrofit retrofit;

    private static final String BASE_URL = "http://private-d3f446-czechitasandroid.apiary-mock.com/"; // sem se budeme připojovat


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
//Kvuli apiary -- nemáme opravdické api
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL) // nastaví URL na které bude komunikovat
                    .addConverterFactory(GsonConverterFactory.create(gson)) // tady přidá konverter na
                    .build();
        }
        return retrofit;
    }
}

