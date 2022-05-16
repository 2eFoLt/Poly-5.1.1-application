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
import com.example.proba.model.Beef;

import java.util.List;

public class BeefAdapter extends RecyclerView.Adapter<BeefAdapter.BeefViewHolder> {
    Context context;
    List<Beef> beefs;

    public BeefAdapter(Context context, List<Beef> beefs) {
        this.context = context;
        this.beefs = beefs;
    }

    @NonNull
    @Override
    public BeefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View BeefItems = LayoutInflater.from(context).inflate(R.layout.beef_item, parent, false);
        return new BeefAdapter.BeefViewHolder(BeefItems);
    }

    @Override
    public void onBindViewHolder(@NonNull BeefViewHolder holder, int position) {
        holder.beef_bg.setBackgroundColor(Color.parseColor(beefs.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + beefs.get(position).getImg(),"drawable",context.getPackageName());
        holder.beef_img.setImageResource(imageId);
        holder.beef_title.setText(beefs.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return beefs.size();
    }

    public static final class BeefViewHolder extends RecyclerView.ViewHolder {
        LinearLayout beef_bg;
        ImageView beef_img;
        TextView beef_title;

        public BeefViewHolder(@NonNull View itemView) {
            super(itemView);
            beef_bg = itemView.findViewById(R.id.beef_bg);
            beef_img = itemView.findViewById(R.id.beef_image);
            beef_title = itemView.findViewById(R.id.beef_title);
        }
    }
}
