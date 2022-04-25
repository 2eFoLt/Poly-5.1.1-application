package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.FastFoodAdapter;
import com.example.proba.model.FastFood;

import java.util.ArrayList;
import java.util.List;

public class FastfoodActivity extends AppCompatActivity {
    FastFoodAdapter FastFoodAdapter;
    RecyclerView fastfood_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ff_item);

        List<FastFood> FastFoodList = new ArrayList<>();
        FastFoodList.add(new FastFood(1,"fastfood1","McDonald's","#FF000000"));
        FastFoodList.add(new FastFood(2,"fastfood2","Subway","#FF000000"));
        FastFoodList.add(new FastFood(3,"fastfood3","Burger King","#FF000000"));
        FastFoodList.add(new FastFood(4,"fastfood4","KFC","#FF000000"));
        FastFoodList.add(new FastFood(5,"fastfood5","NewYork Burger","#FF000000"));
        FastFoodList.add(new FastFood(6,"fastfood6","#Farsh","#FF000000"));



        setfastfood_recycler(FastFoodList);

    }

    private void setfastfood_recycler(List<FastFood> FastFoodList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        fastfood_recycler= findViewById(R.id.fastfood_recycler);
        fastfood_recycler.setLayoutManager(layoutManager);

        FastFoodAdapter= new FastFoodAdapter(this,FastFoodList);
        fastfood_recycler.setAdapter(FastFoodAdapter);

    }
}