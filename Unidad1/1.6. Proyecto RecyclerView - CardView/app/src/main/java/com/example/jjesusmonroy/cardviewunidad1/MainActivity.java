package com.example.jjesusmonroy.cardviewunidad1;

import android.graphics.Color;
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
        recyclerView=findViewById(R.id.recycler);
        lista = new ArrayList<>();

        lista.add(new DataProvider("Rock","Life can't get much better",Color.MAGENTA));
        lista.add(new DataProvider("Rock alternativo","Streseed out", Color.RED));
        lista.add(new DataProvider("Raegaeton","Criminal", Color.BLUE));
        adapter=new Adapter(lista);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }
}
