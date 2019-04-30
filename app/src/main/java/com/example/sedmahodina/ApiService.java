package com.example.sedmahodina;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {// seznam příkaz, které se budou volat na server

    @GET("/movies")
    Call<ArrayList<Movie>> /*tohe je návratová jodnota*/ getAllMovies(/*tady by byly vstupní parametry*/);
}
