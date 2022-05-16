package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.VeganAdapter;
import com.example.proba.model.Beef;
import com.example.proba.model.vegan;

import java.util.ArrayList;
import java.util.List;

public class VeganActivity extends AppCompatActivity {
    VeganAdapter VeganAdapter;
    RecyclerView vegan_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);
        List<vegan> veganList = new ArrayList<>();
        veganList.add(new vegan(1,"vegan1","Джаганнат","#FFFFFFFF"));
        veganList.add(new vegan(2,"vegan2","Fresh","#FFFFFFFF"));
        veganList.add(new vegan(3,"vegan5","Gabs and co","#FFFFFFFF"));
        veganList.add(new vegan(4,"vegan3","REfresh","#FFFFFFFF"));
        veganList.add(new vegan(5,"vegan4","Sattva","#FFFFFFFF"));

        

        setvegan_recycler(veganList);
    }

    private void setvegan_recycler(List<vegan> veganList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        vegan_recycler = findViewById(R.id.vegan_recycler);
        vegan_recycler.setLayoutManager(layoutManager);

        VeganAdapter = new VeganAdapter(this,veganList);
        vegan_recycler.setAdapter(VeganAdapter);
    }
}