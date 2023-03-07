package com.example.youtubelightjava.model;

import java.util.ArrayList;

public class Feed {

    public ArrayList<Short> shorts = new ArrayList<>();
    public int profile;
    public int video;

    public Feed(ArrayList<Short> shorts) {
        this.shorts = shorts;
    }

    public Feed(int profile, int video) {
        this.profile = profile;
        this.video = video;
    }
}
