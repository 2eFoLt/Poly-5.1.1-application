package com.example.proba.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proba.BeefActivity;
import com.example.proba.DessertActivity;
import com.example.proba.FastfoodActivity;
import com.example.proba.Hot_DogActivity;
import com.example.proba.PizzaActivity;
import com.example.proba.R;
import com.example.proba.SaladActivity;
import com.example.proba.model.food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    Context context;
    List<food> foods;

    public FoodAdapter(Context context, List<food> foods) {
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View FoodItems = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false);
        return new FoodAdapter.FoodViewHolder(FoodItems);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.ff_bg.setBackgroundColor(Color.parseColor(foods.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + foods.get(position).getImg(), "drawable", context.getPackageName());
        holder.ff_image.setImageResource(imageId);
        holder.ff_title.setText(foods.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                if (holder.getAdapterPosition() == 0){
                    intent =  new Intent(context, FastfoodActivity.class);
                } else if (holder.getAdapterPosition() == 1) {
                    intent = new Intent(context, PizzaActivity.class);
                } else if (holder.getAdapterPosition() == 2) {
                    intent= new Intent(context, SaladActivity.class);
                } else if (holder.getAdapterPosition() == 3){
                    intent = new Intent(context, DessertActivity.class);
                } else if (holder.getAdapterPosition() == 4){
                    intent = new Intent(context, BeefActivity.class);
                } else {
                    intent =  new Intent(context, Hot_DogActivity.class);
                }
                context.startActivity(intent);




                //Intent intent = new Intent(context,FfLayoutActivity.class);
                //context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static final class FoodViewHolder extends RecyclerView.ViewHolder{

        LinearLayout ff_bg;
        ImageView ff_image;
        TextView ff_title;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            ff_bg = itemView.findViewById(R.id.ff_bg);
            ff_image = itemView.findViewById(R.id.ff_image);
            ff_title = itemView.findViewById(R.id.ff_title);

        }

    }
}
