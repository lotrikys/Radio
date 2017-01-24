package org.itstep.pastukhov.internetradio;


import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


/**
 * Created by lotrik on 15.01.17.
 */

public class Playback {

    Context mContext;

    public void startPlay(Context context) {

        mContext = context;

        Uri stream = Uri.parse("http://online-radioroks.tavrmedia.ua/RadioROKS");

        TrackSelector trackSelector =
                new DefaultTrackSelector();

        LoadControl loadControl = new DefaultLoadControl(new DefaultAllocator(true, 1000), 5000,
                10000, 5000, 5000);

        SimpleExoPlayer player =
                ExoPlayerFactory.newSimpleInstance(mContext, trackSelector, loadControl);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(mContext,
                Util.getUserAgent(mContext, "Internet Radio"), null);

        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

        MediaSource audioSource = new ExtractorMediaSource(stream,
                dataSourceFactory, extractorsFactory, null, null);

        player.prepare(audioSource);
        player.setPlayWhenReady(true);

    }


}
