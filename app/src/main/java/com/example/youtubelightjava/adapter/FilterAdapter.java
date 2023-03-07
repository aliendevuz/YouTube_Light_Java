package com.example.youtubelightjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubelightjava.R;
import com.example.youtubelightjava.databinding.ItemFilterCommonBinding;
import com.example.youtubelightjava.model.Filter;
import com.example.youtubelightjava.model.ObjectType;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Filter> filters;

    public FilterAdapter(ArrayList<Filter> filters) {
        this.filters =filters;
    }

    static class CommonFilterViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        CommonFilterViewHolder(View view) {
            super(view);
            ItemFilterCommonBinding binding = ItemFilterCommonBinding.bind(view);
            title = binding.filterTitle;
        }
    }

    static class VLineFilterViewHolder extends RecyclerView.ViewHolder {

        VLineFilterViewHolder(View view) {
            super(view);
        }
    }

    static class ExploreFilterViewHolder extends RecyclerView.ViewHolder {

        ExploreFilterViewHolder(View view) {
            super(view);
        }
    }

    void commonInit(CommonFilterViewHolder holder, Filter filter) {
        holder.title.setText(filter.title);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ObjectType.commonFilter)
            return new CommonFilterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_common, parent, false));
        else if (viewType == ObjectType.exploreFilter)
            return new ExploreFilterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_explore, parent, false));
        else
            return new VLineFilterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_vertical_line, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommonFilterViewHolder) commonInit((CommonFilterViewHolder) holder, filters.get(position));
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    @Override
    public int getItemViewType(int position) {
        return filters.get(position).filterType;
    }
}
