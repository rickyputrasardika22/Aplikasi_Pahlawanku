package com.ahmfarisi.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);

        data.addAll(DataPahlawan.ambilDataPahlawan());
        tampilDataCard();
//        tampilDataGrid();
    }

    private void tampilDataCard(){
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard varAdapterCard = new AdapterCard(data, MainActivity.this);
        rvPahlawan.setAdapter(varAdapterCard);
    }

    private void tampilDataGrid(){
        rvPahlawan.setLayoutManager(new GridLayoutManager(this, 2));
        AdapterGrid varAdapterGrid = new AdapterGrid(data, MainActivity.this);
        rvPahlawan.setAdapter(varAdapterGrid);
    }
}