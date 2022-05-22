package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proba.adapter.FastFoodAdapter;
import com.example.proba.adapter.KfcAdapter;
import com.example.proba.model.KFC;

import java.util.ArrayList;
import java.util.List;

public class KFCActivity extends AppCompatActivity {
    KfcAdapter KfcAdapter;
    RecyclerView kfc_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kfcactivity);
        List<KFC> KFCList = new ArrayList<>();
        KFCList.add(new KFC(1,"shef","Шефбургер        139₱","#F4F4F4"));
        KFCList.add(new KFC(2,"shef1","Чизбургер       134₱","#F4F4F4"));
        KFCList.add(new KFC(3,"shef2","Шефбургер Де    Люкс 164₱","#F4F4F4"));
        KFCList.add(new KFC(4,"shef3","Шефбургер Де    Люкс острый 139₱","#F4F4F4"));
        KFCList.add(new KFC(5,"shef4","Шефбургер Джуниор    250₱","#F4F4F4"));
        KFCList.add(new KFC(6,"shef5","Шефбургер оригинальный  109₱","#F4F4F4"));

        setkfc_recycler(KFCList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        kfc_recycler.setLayoutManager(mLayoutManager);
    }

    private void setkfc_recycler(List<KFC> kfcList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        kfc_recycler= findViewById(R.id.kfc_recycler);
        kfc_recycler.setLayoutManager(layoutManager);

        KfcAdapter= new KfcAdapter(this,kfcList);
        kfc_recycler.setAdapter(KfcAdapter);
    }
}