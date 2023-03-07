package com.example.youtubelightjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.youtubelightjava.R;
import com.example.youtubelightjava.adapter.FeedAdapter;
import com.example.youtubelightjava.adapter.FilterAdapter;
import com.example.youtubelightjava.databinding.ActivityMainBinding;
import com.example.youtubelightjava.model.Feed;
import com.example.youtubelightjava.model.Filter;
import com.example.youtubelightjava.model.ObjectType;
import com.example.youtubelightjava.model.Short;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ActivityMainBinding binding;
    RecyclerView filterList;
    RecyclerView feedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    void init() {
        Objects.requireNonNull(getSupportActionBar()).hide();

        filterList = binding.filterList;
        feedList = binding.feedList;

        filterList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        feedList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

        ArrayList<Short> shorts = new ArrayList<>();
        ArrayList<Filter> filters = new ArrayList<>();
        ArrayList<Feed> feeds = new ArrayList<>();

        shortLoad(shorts);
        filterLoad(filters);
        feedLoad(shorts, feeds);

        FilterAdapter filterAdapter = new FilterAdapter(filters);
        FeedAdapter feedAdapter = new FeedAdapter(context, feeds);

        filterList.setAdapter(filterAdapter);
        feedList.setAdapter(feedAdapter);
    }

    void filterLoad(ArrayList<Filter> filters) {
        filters.add(new Filter(ObjectType.exploreFilter, ""));
        filters.add(new Filter(ObjectType.verticalLineFilter, ""));
        filters.add(new Filter(ObjectType.commonFilter, "Computer Programming"));
        filters.add(new Filter(ObjectType.commonFilter, "Android Native"));
        filters.add(new Filter(ObjectType.commonFilter, "Mobile Development"));
    }

    void feedLoad(ArrayList<Short> shorts, ArrayList<Feed> feeds) {
        feeds.add(new Feed(R.drawable.image1, R.drawable.video1));
        feeds.add(new Feed(shorts));
        feeds.add(new Feed(R.drawable.image2, R.drawable.video2));
        feeds.add(new Feed(R.drawable.image3, R.drawable.video3));
        feeds.add(new Feed(R.drawable.image1, R.drawable.video1));
        feeds.add(new Feed(R.drawable.image2, R.drawable.video2));
        feeds.add(new Feed(shorts));
        feeds.add(new Feed(R.drawable.image3, R.drawable.video3));
    }

    void shortLoad(ArrayList<Short> shorts) {
        shorts.add(new Short(R.drawable.short_video1, "Drawing App | HTML CSS & JavaScript", "79K views"));
        shorts.add(new Short(R.drawable.short_video2, "Software engineer status for WhatsApp coder status 2022 programmers #coding #viral #shorts", "1.4M views"));
        shorts.add(new Short(R.drawable.short_video3, "Albert Einstein doing physics | very rare video footage #shorts", "3.3M views"));
        shorts.add(new Short(R.drawable.short_video1, "Drawing App | HTML CSS & JavaScript", "79K views"));
        shorts.add(new Short(R.drawable.short_video2, "Software engineer status for WhatsApp coder status 2022 programmers #coding #viral #shorts", "1.4M views"));
        shorts.add(new Short(R.drawable.short_video3, "Albert Einstein doing physics | very rare video footage #shorts", "3.3M views"));
        shorts.add(new Short(R.drawable.short_video1, "Drawing App | HTML CSS & JavaScript", "79K views"));
        shorts.add(new Short(R.drawable.short_video2, "Software engineer status for WhatsApp coder status 2022 programmers #coding #viral #shorts", "1.4M views"));
        shorts.add(new Short(R.drawable.short_video3, "Albert Einstein doing physics | very rare video footage #shorts", "3.3M views"));
    }
}
