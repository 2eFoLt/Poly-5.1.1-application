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
import com.example.proba.model.FastFood;

import java.util.List;

public class FastFoodAdapter extends RecyclerView.Adapter<FastFoodAdapter.FastFoodViewHolder> {
    Context context;
    List<FastFood> fastfood;

    public FastFoodAdapter(Context context, List<FastFood> fastfood) {
        this.context = context;
        this.fastfood = fastfood;
    }

    @NonNull
    @Override
    public FastFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View FastFoodItems = LayoutInflater.from(context).inflate(R.layout.fastfood_item, parent, false);
        return new FastFoodAdapter.FastFoodViewHolder(FastFoodItems);
    }

    @Override
    public void onBindViewHolder(@NonNull FastFoodViewHolder holder, int position) {
        holder.fastfood_bg.setBackgroundColor(Color.parseColor(fastfood.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + fastfood.get(position).getImg(),"drawable",context.getPackageName());
        holder.fastfood_image.setImageResource(imageId);
        holder.fastfood_title.setText(fastfood.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return fastfood.size();
    }

    public static final class FastFoodViewHolder extends RecyclerView.ViewHolder{
        LinearLayout fastfood_bg;
        ImageView fastfood_image;
        TextView fastfood_title;




        public FastFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            fastfood_bg = itemView.findViewById(R.id.fastfood_bg);
            fastfood_image = itemView.findViewById(R.id.fastfood_img);
            fastfood_title = itemView.findViewById(R.id.fastfood_title);
        }
    }
}
