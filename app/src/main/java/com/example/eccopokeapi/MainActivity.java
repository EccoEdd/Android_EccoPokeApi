package com.example.eccopokeapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.example.eccopokeapi.databinding.ActivityMainBinding;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<PokeModel> mExampleList;
    String url = "https://pokeapi.co/api/v2/pokemon?offse=1&limit=201";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mExampleList = new ArrayList<>();

        binding.btnLoad.setOnClickListener(v -> LoadPokemon());
    }

    private void LoadPokemon() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {

                        Toast.makeText(
                                MainActivity.this,
                                response.optString("count", "XD"),
                                Toast.LENGTH_SHORT
                        ).show();
                        Log.i("Volley", "onCreate: " + response);

                        JSONArray jsonArray = response.getJSONArray("results");

                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject result = jsonArray.getJSONObject(i);
                            String name = result.getString("name");
                            mExampleList.add(new PokeModel(name));
                        }

                        PokeAdapter adapter = new PokeAdapter(mExampleList);
                        binding.ListPkmn.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {

                });

        SingletonRequest.getInstance(this).addToRequestQue(request);
    }
}