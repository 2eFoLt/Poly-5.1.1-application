package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.CoffeeAdapter;
import com.example.proba.model.Coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeActivity extends AppCompatActivity {
    RecyclerView coffee_recycler;
    CoffeeAdapter CoffeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        List<Coffee> coffeeList = new ArrayList<>();
        coffeeList.add(new Coffee(1,"coffee1","Шоколадница","#FFFFFFFF"));
        coffeeList.add(new Coffee(2,"coffee2","Udcкафе","#FFFFFFFF"));
        coffeeList.add(new Coffee(3,"coffee3","Coffee Bean","#FFFFFFFF"));
        coffeeList.add(new Coffee(4,"coffee4","Cofix","#FFFFFFFF"));
        coffeeList.add(new Coffee(5,"coffee5","Кофемания","#FFFFFFFF"));
        coffeeList.add(new Coffee(6,"coffee6","Daily Green","#FFFFFFFF"));

        setcoffee_recycler(coffeeList);
    }

    private void setcoffee_recycler(List<Coffee> coffeeList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        coffee_recycler = findViewById(R.id.coffee_recycler);
        coffee_recycler.setLayoutManager(layoutManager);

        CoffeeAdapter = new CoffeeAdapter(this,coffeeList);
        coffee_recycler.setAdapter(CoffeeAdapter);


    }
}