package com.example.youtubelightjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubelightjava.R;
import com.example.youtubelightjava.databinding.ItemFeedCommonBinding;
import com.example.youtubelightjava.databinding.ItemFeedShortsBinding;
import com.example.youtubelightjava.model.Feed;
import com.example.youtubelightjava.model.ObjectType;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Feed> feeds;

    public FeedAdapter(Context context, ArrayList<Feed> feeds) {
        this.context = context;
        this.feeds = feeds;
    }

    static class CommonFeedViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView feedProfile;
        ImageView feedVideo;

        CommonFeedViewHolder(View view) {
            super(view);
            ItemFeedCommonBinding binding = ItemFeedCommonBinding.bind(view);
            feedProfile = binding.feedProfile;
            feedVideo = binding.feedVideo;
        }
    }

    static class ShortsFeedViewHolder extends RecyclerView.ViewHolder {

        RecyclerView shorts;
        ShortsFeedViewHolder(View view) {
            super(view);
            ItemFeedShortsBinding binding = ItemFeedShortsBinding.bind(view);
            shorts = binding.feedShorts;
        }
    }

    void commonInit(CommonFeedViewHolder holder, Feed feed) {
        holder.feedProfile.setImageResource(feed.profile);
        holder.feedVideo.setImageResource(feed.video);
    }

    void shortsInit(ShortsFeedViewHolder holder, Feed feed) {
        holder.shorts.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        ShortAdapter adapter = new ShortAdapter(feed.shorts);
        holder.shorts.setAdapter(adapter);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ObjectType.shortsFeed)
            return new ShortsFeedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_shorts, parent, false));
        else
            return new CommonFeedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_common, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommonFeedViewHolder) commonInit((CommonFeedViewHolder) holder, feeds.get(position));
        if (holder instanceof ShortsFeedViewHolder) shortsInit((ShortsFeedViewHolder) holder, feeds.get(position));
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (feeds.get(position).shorts.size() > 0)
            return ObjectType.shortsFeed;
        return ObjectType.commonFeed;
    }
}
