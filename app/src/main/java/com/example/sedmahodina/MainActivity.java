package com.example.sedmahodina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        // adapter = new CustomListAdapter(MainActivity.this, new ArrayList<Movie>()); --> tady jsou totiž data daná napevno v array listu - v on Response je tam mrskneme přes odpověď
        //  listView.setAdapter(adapter);

        ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        // už zároveň musí být instancí toho retrofitu
        // takže přes instanci apiService budu volat příkazy, které jsou v RetrofitInstance??

        Call<ArrayList<Movie>> call = apiService.getAllMovies(); // tímhle se volá, ale zároveň je to ve frontě --> aby to mělo pořadí a hlavně odpovědi aby měli své pořadí
        call.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) { // tady se pracuje se správnou opovědí

                adapter = new CustomListAdapter(MainActivity.this, response.body());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) { // tady se pracuje v příadě chyby
                Toast.makeText(MainActivity.this, "Chybička se vloudila", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
