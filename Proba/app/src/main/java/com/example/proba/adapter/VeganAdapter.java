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
import com.example.proba.model.vegan;

import java.util.List;

public class VeganAdapter extends RecyclerView.Adapter<VeganAdapter.VeganViewHolder> {
    Context context;
    List<vegan> vegans;

    public VeganAdapter(Context context, List<vegan> vegans) {
        this.context = context;
        this.vegans = vegans;
    }

    @NonNull
    @Override
    public VeganViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View VeganItems = LayoutInflater.from(context).inflate(R.layout.vegan_item, parent, false);
        return new VeganAdapter.VeganViewHolder(VeganItems);
    }

    @Override
    public void onBindViewHolder(@NonNull VeganViewHolder holder, int position) {
        holder.vegan_bg.setBackgroundColor(Color.parseColor(vegans.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_"+ vegans.get(position).getImg(),"drawable",context.getPackageName());
        holder.vegan_img.setImageResource(imageId);
        holder.vegan_title.setText(vegans.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return vegans.size();
    }

    public final static class VeganViewHolder extends RecyclerView.ViewHolder{
        LinearLayout vegan_bg;
        ImageView vegan_img;
        TextView vegan_title;


        public VeganViewHolder(@NonNull View itemView) {
            super(itemView);
            vegan_bg = itemView.findViewById(R.id.vegan_bg);
            vegan_img = itemView.findViewById(R.id.vegan_image);
            vegan_title = itemView.findViewById(R.id.vegan_title);
        }
    }
}
