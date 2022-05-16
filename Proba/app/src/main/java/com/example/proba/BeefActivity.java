package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.BeefAdapter;
import com.example.proba.model.Beef;


import java.util.ArrayList;
import java.util.List;

public class BeefActivity extends AppCompatActivity {
    BeefAdapter BeefAdapter;
    RecyclerView beef_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beef);

        List<Beef> beefList = new ArrayList<>();
        beefList.add(new Beef(1,"beef1","Torro Grill","#FFFFFFFF"));
        beefList.add(new Beef(2,"beef2","Elegant Стейк Хаус","#FFFFFFFF"));
        beefList.add(new Beef(3,"beef3","800°c Contemporary Steak","#FFFFFFFF"));
        beefList.add(new Beef(4,"beef4","Chef Steak & Kebab","#FFFFFFFF"));
        beefList.add(new Beef(5,"beef5","Стейки Good Prime","#FFFFFFFF"));
        beefList.add(new Beef(6,"beef6","Стейк Хаус Бутчер","#FFFFFFFF"));

        setbeef_recycler(beefList);

    }

    private void setbeef_recycler(List<Beef> beefList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        beef_recycler = findViewById(R.id.beef_recycler);
        beef_recycler.setLayoutManager(layoutManager);

        BeefAdapter= new BeefAdapter(this, beefList);
        beef_recycler.setAdapter(BeefAdapter);

    }
}