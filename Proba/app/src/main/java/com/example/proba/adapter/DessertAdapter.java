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

import com.example.proba.BurgerkingActivity;
import com.example.proba.ChokolateActivity;
import com.example.proba.FarshActivity;
import com.example.proba.KFCActivity;
import com.example.proba.MacActivity;
import com.example.proba.NarodKondActivity;
import com.example.proba.NewYorkBurgerActivity;
import com.example.proba.R;
import com.example.proba.SubwayActivity;
import com.example.proba.model.Dessert;

import java.util.List;

public class DessertAdapter extends RecyclerView.Adapter<DessertAdapter.DessertViewHolder> {
    Context context;
    List<Dessert> desserts;

    public DessertAdapter(Context context, List<Dessert> desserts) {
        this.context = context;
        this.desserts = desserts;
    }

    @NonNull
    @Override
    public DessertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View DessertItems = LayoutInflater.from(context).inflate(R.layout.dessert_item, parent, false);
        return new DessertAdapter.DessertViewHolder(DessertItems);
    }

    @Override
    public void onBindViewHolder(@NonNull DessertViewHolder holder, int position) {
        holder.dessert_bg.setBackgroundColor(Color.parseColor(desserts.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + desserts.get(position).getImg(),"drawable",context.getPackageName());
        holder.dessert_img.setImageResource(imageId);
        holder.dessert_title.setText(desserts.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (holder.getAdapterPosition()== 0) {
                    intent = new Intent(context, ChokolateActivity.class);
                }else if (holder.getAdapterPosition()==1){
                    intent = new Intent(context, NarodKondActivity.class);
                }else if (holder.getAdapterPosition()==2){
                    intent = new Intent(context, BurgerkingActivity.class);
                }else if (holder.getAdapterPosition()==3){
                    intent = new Intent(context, KFCActivity.class);
                }else if (holder.getAdapterPosition()==4){
                    intent = new Intent(context, NewYorkBurgerActivity.class);
                }else if (holder.getAdapterPosition()==5){
                    intent = new Intent(context, FarshActivity.class);
                }
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return desserts.size();
    }

    public static final class DessertViewHolder extends RecyclerView.ViewHolder{
        LinearLayout dessert_bg;
        ImageView dessert_img;
        TextView dessert_title;

        public DessertViewHolder(@NonNull View itemView) {
            super(itemView);
            dessert_bg = itemView.findViewById(R.id.dessert_bg);
            dessert_img = itemView.findViewById(R.id.dessert_image);
            dessert_title = itemView.findViewById(R.id.dessert_title);

        }
    }


}
