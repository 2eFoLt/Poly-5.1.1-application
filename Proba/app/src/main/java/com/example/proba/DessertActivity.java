package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.DessertAdapter;
import com.example.proba.adapter.SushiAdapter;
import com.example.proba.model.Dessert;
import com.example.proba.model.Sushi;

import java.util.ArrayList;
import java.util.List;

public class DessertActivity extends AppCompatActivity {
    DessertAdapter DessertAdapter;
    RecyclerView dessert_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);


        List<Dessert> dessertList = new ArrayList<>();
        dessertList.add(new Dessert(1,"dessert1","Mon Bon","#FFFFFFFF"));
        dessertList.add(new Dessert(2,"dessert2","Народный кондитер","#FFFFFFFF"));
        dessertList.add(new Dessert(3,"dessert3","Синнабон","#FFFFFFFF"));
        dessertList.add(new Dessert(4,"dessert4","Пекарня Буханка","#FFFFFFFF"));
        dessertList.add(new Dessert(5,"dessert5","Tortmedovik","#FFFFFFFF"));
        dessertList.add(new Dessert(6,"dessert6","Rusyagoda","#FFFFFFFF"));



        setdessert_recycler(dessertList);
    }

    private void setdessert_recycler(List<Dessert> dessertList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        dessert_recycler= findViewById(R.id.dessert_recycler);
        dessert_recycler.setLayoutManager(layoutManager);

        DessertAdapter= new DessertAdapter(this, dessertList);
        dessert_recycler.setAdapter(DessertAdapter);
    }
}