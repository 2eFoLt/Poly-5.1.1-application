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
import com.example.proba.FarshActivity;
import com.example.proba.KFCActivity;
import com.example.proba.MacActivity;
import com.example.proba.NewYorkBurgerActivity;
import com.example.proba.R;
import com.example.proba.SubwayActivity;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (holder.getAdapterPosition()== 0) {
                    intent = new Intent(context, MacActivity.class);
                }else if (holder.getAdapterPosition()==1){
                    intent = new Intent(context, SubwayActivity.class);
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
