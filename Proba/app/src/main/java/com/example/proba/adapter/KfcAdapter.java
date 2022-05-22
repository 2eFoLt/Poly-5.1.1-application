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
import com.example.proba.model.KFC;

import java.util.List;

public class KfcAdapter extends RecyclerView.Adapter<KfcAdapter.KfcViewHolder> {
    Context context;
    List<KFC> kfc;

    public KfcAdapter(Context context, List<KFC> kfc) {
        this.context = context;
        this.kfc = kfc;
    }

    @NonNull
    @Override
    public KfcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View KFCItems = LayoutInflater.from(context).inflate(R.layout.kfc_item, parent, false);
        return new KfcAdapter.KfcViewHolder(KFCItems);
    }

    @Override
    public void onBindViewHolder(@NonNull KfcViewHolder holder, int position) {
        holder.kfc_bg.setBackgroundColor(Color.parseColor(kfc.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + kfc.get(position).getImg(),"drawable",context.getPackageName());
        holder.kfc_image.setImageResource(imageId);
        holder.kfc_title.setText(kfc.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return kfc.size();
    }

    public static final class KfcViewHolder extends RecyclerView.ViewHolder {
        LinearLayout kfc_bg;
        ImageView kfc_image;
        TextView kfc_title;
        public KfcViewHolder(@NonNull View itemView) {
            super(itemView);
            kfc_bg = itemView.findViewById(R.id.kfc_bg);
            kfc_image = itemView.findViewById(R.id.kfc_image);
            kfc_title = itemView.findViewById(R.id.kfc_title);
        }
    }
}
