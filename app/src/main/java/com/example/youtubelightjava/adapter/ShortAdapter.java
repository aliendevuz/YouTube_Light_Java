package com.example.youtubelightjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubelightjava.R;
import com.example.youtubelightjava.databinding.ItemShortViewBinding;
import com.example.youtubelightjava.model.Short;

import java.util.ArrayList;

public class ShortAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Short> shorts;

    ShortAdapter(ArrayList<Short> shorts) {
        this.shorts = shorts;
    }

    static class ShortViewHolder extends RecyclerView.ViewHolder {

        ImageView video;
        TextView title;
        TextView views;
        ShortViewHolder(View view) {
            super(view);
            ItemShortViewBinding binding = ItemShortViewBinding.bind(view);
            video = binding.shortVideo;
            title = binding.shortTitle;
            views = binding.shortViews;
        }
    }

    void init(ShortViewHolder holder, Short _short) {
        holder.video.setImageResource(_short.video);
        holder.title.setText(_short.title);
        holder.views.setText(_short.views);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShortViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_short_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ShortViewHolder) init((ShortViewHolder) holder, shorts.get(position));
    }

    @Override
    public int getItemCount() {
        return shorts.size();
    }
}
