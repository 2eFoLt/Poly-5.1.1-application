package com.example.proba.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proba.FastfoodActivity;
import com.example.proba.PizzaActivity;
import com.example.proba.R;
import com.example.proba.model.FastFood;
import com.example.proba.model.Pizza;


public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    Context context;
    List<Pizza> pizzas;

    public PizzaAdapter(Context context, List<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }


    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View PizzaItems = LayoutInflater.from(context).inflate(R.layout.pizza_item, parent, false);
        return new PizzaAdapter.PizzaViewHolder(PizzaItems);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        holder.pizza_bg.setBackgroundColor(Color.parseColor(pizzas.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + pizzas.get(position).getImg(),"drawable",context.getPackageName());
        holder.pizza_img.setImageResource(imageId);
        holder.pizza_title.setText(pizzas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    public static final class PizzaViewHolder extends RecyclerView.ViewHolder{
        LinearLayout pizza_bg;
        ImageView pizza_img;
        TextView pizza_title;


        public PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            pizza_bg = itemView.findViewById(R.id.pizza_bg);
            pizza_img = itemView.findViewById(R.id.pizza_image);
            pizza_title = itemView.findViewById(R.id.pizza_title);
        }
    }
}