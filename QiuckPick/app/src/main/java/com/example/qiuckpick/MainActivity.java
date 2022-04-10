package com.example.qiuckpick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.qiuckpick.adapter.CategoryAdapter;
import com.example.qiuckpick.adapter.FoodAdapter;
import com.example.qiuckpick.model.Category;
import com.example.qiuckpick.model.food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, foodRecycler;
    CategoryAdapter categoryAdapter;
    FoodAdapter FoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Профиль"));
        categoryList.add(new Category(2,"Заказы"));
        categoryList.add(new Category(3,"Адреса"));
        categoryList.add(new Category(4,"Промокоды"));

        setCategoryRecycler(categoryList);

       List<food>foodsList = new ArrayList<>();
        foodsList.add(new food(1,"fastfood", "Фастфуд","#424345"));
        foodsList.add(new food(2,"pizza", "Пицца","#424345"));
        foodsList.add(new food(3,"salad", "Постное","#424345"));
        foodsList.add(new food(4,"dessert","Десерты","#424345"));
        foodsList.add(new food(5,"meat","Стейки","#424345"));
        foodsList.add(new food(6, "hot_dog", "Хот-Доги","#424345"));

        setFoodRecycler(foodsList);





    }

    private void setFoodRecycler(List<food> foodsList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        foodRecycler = findViewById(R.id.foodRecycler);
        foodRecycler.setLayoutManager(layoutManager);

        FoodAdapter= new FoodAdapter(this, foodsList);
        foodRecycler.setAdapter(FoodAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}