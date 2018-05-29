package com.example.jjesusmonroy.jjesusmonroyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<DataProvider> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        lista = new ArrayList<>();


        lista.add(new DataProvider("Monroy Salcedo Jose de Jesus","14400968","ISC"));
        lista.add(new DataProvider("Sanchez Carrillo Betsy del Carmen","14401007","ISC"));
        lista.add(new DataProvider("Gutierrez Rojas Bryan","14400945","ISC"));
        lista.add(new DataProvider("Regla Torres Andrea","15400568","II"));
        adapter= new RecyclerAdapter(lista);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }
}
