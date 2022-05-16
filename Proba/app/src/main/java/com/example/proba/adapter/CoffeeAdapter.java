package com.example.proba.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proba.R;
import com.example.proba.model.Coffee;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {
    Context context;
    List<Coffee> coffees;

    public CoffeeAdapter(Context context, List<Coffee> coffees) {
        this.context = context;
        this.coffees = coffees;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View CoffeeItems = LayoutInflater.from(context).inflate(R.layout.coffee_item, parent, false);
        return new CoffeeAdapter.CoffeeViewHolder(CoffeeItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        holder.coffee_bg.setBackgroundColor(Color.parseColor(coffees.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_"+ coffees.get(position).getImg(),"drawable",context.getPackageName());
        holder.coffee_img.setImageResource(imageId);
        holder.coffee_title.setText(coffees.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }

    public static final class CoffeeViewHolder extends RecyclerView.ViewHolder{
        LinearLayout coffee_bg;
        ImageView coffee_img;
        TextView coffee_title;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            coffee_bg = itemView.findViewById(R.id.coffee_bg);
            coffee_img = itemView.findViewById(R.id.coffee_image);
            coffee_title =itemView.findViewById(R.id.coffee_title);
        }
    }
}
