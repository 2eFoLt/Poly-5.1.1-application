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

import com.example.proba.DessertActivity;
import com.example.proba.R;
import com.example.proba.model.Dessert;
import com.example.proba.model.Sushi;

import java.util.List;

public class SushiAdapter extends RecyclerView.Adapter<SushiAdapter.SushiViewHolder> {

    Context context;
    List<Sushi> sushi;

    public SushiAdapter(Context context, List<Sushi> sushi) {
        this.context = context;
        this.sushi = sushi;
    }

    @NonNull
    @Override
    public SushiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View SushiItems = LayoutInflater.from(context).inflate(R.layout.sushi_item, parent, false);
        return new SushiAdapter.SushiViewHolder(SushiItems);
    }

    @Override
    public void onBindViewHolder(@NonNull SushiViewHolder holder, int position) {
        holder.sushi_bg.setBackgroundColor(Color.parseColor(sushi.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + sushi.get(position).getImg(),"drawable",context.getPackageName());
        holder.sushi_img.setImageResource(imageId);
        holder.sushi_title.setText(sushi.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return sushi.size();
    }

    public static final class SushiViewHolder extends RecyclerView.ViewHolder{

        LinearLayout sushi_bg;
        ImageView sushi_img;
        TextView sushi_title;


        public SushiViewHolder(@NonNull View itemView) {
            super(itemView);
            sushi_bg =itemView.findViewById(R.id.sushi_bg);
            sushi_img = itemView.findViewById(R.id.sushi_image);
            sushi_title = itemView.findViewById(R.id.sushi_title);

        }
    }
}
