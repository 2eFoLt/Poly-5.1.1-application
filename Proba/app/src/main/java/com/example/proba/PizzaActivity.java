package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.PizzaAdapter;
import com.example.proba.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaActivity extends AppCompatActivity {
    PizzaAdapter PizzaAdapter;
    RecyclerView pizza_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);


        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza(1,"pizza21","Papajons","#FF000000"));
        pizzaList.add(new Pizza(2,"pizza13","Zotman Pizza","#FF000000"));
        pizzaList.add(new Pizza(3,"pizza20","PizzaHut","#FF000000"));
        pizzaList.add(new Pizza(4,"pizza19","JamesItalian","#FF000000"));
        pizzaList.add(new Pizza(5,"pizza18","Eazzy Pizzy","#FF000000"));
        pizzaList.add(new Pizza(6,"pizza22","Dominos Pizza","#FF000000"));
        pizzaList.add(new Pizza(7,"pizza23","Dodo_Pizza","#FF000000"));


        setpizza_recycler(pizzaList);
    }

    private void setpizza_recycler(List<Pizza> pizzaList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        pizza_recycler= findViewById(R.id.pizza_recycler);
        pizza_recycler.setLayoutManager(layoutManager);

        PizzaAdapter= new PizzaAdapter(this,pizzaList);
        pizza_recycler.setAdapter(PizzaAdapter);
    }
}


