package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.proba.adapter.CategoryAdapter;
import com.example.proba.adapter.FoodAdapter;
import com.example.proba.model.Category;
import com.example.proba.model.food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView  foodRecycler, categoryRecycler;
    FoodAdapter FoodAdapter;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<food>foodsList = new ArrayList<>();
        foodsList.add(new food(1,"ff", "Фастфуд","#424345"));
        foodsList.add(new food(2,"pizzacolor", "Пицца","#424345"));
        foodsList.add(new food(3,"sushi", "Суши","#424345"));
        foodsList.add(new food(4,"postnoe", "Постное","#424345"));
        foodsList.add(new food(5,"pancakes","Десерты","#424345"));
        foodsList.add(new food(6,"steak","Стейки","#424345"));
        foodsList.add(new food(7, "coffee", "Кофе","#424345"));

        setFoodRecycler(foodsList);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Профиль"));
        categoryList.add(new Category(2,"Заказы"));
        categoryList.add(new Category(3,"Адреса"));
        categoryList.add(new Category(4,"Промокоды"));

        setCategoryRecycler(categoryList);

    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    private void setFoodRecycler(List<food> foodsList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        foodRecycler = findViewById(R.id.foodRecycler);
        foodRecycler.setLayoutManager(layoutManager);

        FoodAdapter= new FoodAdapter(this, foodsList);
        foodRecycler.setAdapter(FoodAdapter);
    }

}