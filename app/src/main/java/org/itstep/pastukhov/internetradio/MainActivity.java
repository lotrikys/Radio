package org.itstep.pastukhov.internetradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleExoPlayerView simpleExoPlayerView;
        simpleExoPlayerView = (SimpleExoPlayerView)findViewById(R.id.player);

        Playback playback = new Playback();
        playback.startPlay(getApplicationContext(), simpleExoPlayerView);
    }
}
