package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.PizzaAdapter;
import com.example.proba.adapter.SushiAdapter;
import com.example.proba.model.Pizza;
import com.example.proba.model.Sushi;

import java.util.ArrayList;
import java.util.List;

public class SushiActivity extends AppCompatActivity {
    SushiAdapter SushiAdapter;
    RecyclerView sushi_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushi);

        List<Sushi> sushiList = new ArrayList<>();
        sushiList.add(new Sushi(1,"sushi1","Якитория","#FFFFFFFF"));
        sushiList.add(new Sushi(2,"sushi2","Много лосося","#FFFFFFFF"));
        sushiList.add(new Sushi(3,"sushi3","Bluefin","#FFFFFFFF"));
        sushiList.add(new Sushi(4,"sushi4","Тануки","#FFFFFFFF"));
        sushiList.add(new Sushi(5,"sushi5","Нияма","#FFFFFFFF"));
        sushiList.add(new Sushi(6,"sushi6","Naomi Sushi","#FFFFFFFF"));
        sushiList.add(new Sushi(7,"sushi7","Море рыбы","#FFFFFFFF"));


        setsushi_recycler(sushiList);
    }

    private void setsushi_recycler(List<Sushi> sushiList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        sushi_recycler= findViewById(R.id.sushi_recycler);
        sushi_recycler.setLayoutManager(layoutManager);

        SushiAdapter= new SushiAdapter(this,sushiList);
        sushi_recycler.setAdapter(SushiAdapter);
    }
}