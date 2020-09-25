package com.example.dome05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MusicActivity extends AppCompatActivity {

    public static List<Music> musicList = new ArrayList<>();
    private MusicAdapter musicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        //int position = getIntent().getIntExtra("position", 0);
        //Toast.makeText(this, "position:" + position, Toast.LENGTH_SHORT).show();

        //recyclerView填数据
        initMusic();
        RecyclerView recyclerView = findViewById(R.id.music_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        musicAdapter = new MusicAdapter(musicList);
        recyclerView.setAdapter(musicAdapter);


    }


    public void initMusic() {
        musicList.add(new Music(R.raw.alarm, "alarm"));
        musicList.add(new Music(R.raw.bird, "bird"));
        musicList.add(new Music(R.raw.backroad, "backroad"));
        musicList.add(new Music(R.raw.big, "big"));
        musicList.add(new Music(R.raw.bollywood, "bollywood"));
        musicList.add(new Music(R.raw.bussa, "bussa"));
        musicList.add(new Music(R.raw.caffeine, "caffeine"));
        musicList.add(new Music(R.raw.cairo, "cairo"));
        musicList.add(new Music(R.raw.calypso, "calypso"));
        musicList.add(new Music(R.raw.champagne, "champagne"));
        musicList.add(new Music(R.raw.club, "club"));
        musicList.add(new Music(R.raw.crayon, "crayon"));
        musicList.add(new Music(R.raw.cricket, "cricket"));
        musicList.add(new Music(R.raw.curve, "curve"));
        musicList.add(new Music(R.raw.dancin, "dancin"));
        musicList.add(new Music(R.raw.dear, "dear"));
        musicList.add(new Music(R.raw.ding, "ding"));
        musicList.add(new Music(R.raw.doink, "doink"));
        musicList.add(new Music(R.raw.don, "don"));
        musicList.add(new Music(R.raw.dont, "dont"));
        musicList.add(new Music(R.raw.drip, "drip"));
        musicList.add(new Music(R.raw.eastern, "eastern"));
        musicList.add(new Music(R.raw.enterexus, "enterexus"));
        musicList.add(new Music(R.raw.free, "free"));
        musicList.add(new Music(R.raw.funk, "funk"));
        musicList.add(new Music(R.raw.gimme, "gimme"));
        musicList.add(new Music(R.raw.glacial, "glacial"));
        musicList.add(new Music(R.raw.growl, "growl"));
        musicList.add(new Music(R.raw.halfway, "halfway"));
        musicList.add(new Music(R.raw.heaven, "heaven"));
        musicList.add(new Music(R.raw.highwire, "highwire"));
        musicList.add(new Music(R.raw.kzurb, "kzurb"));
        musicList.add(new Music(R.raw.loopyle, "loopyle"));
        musicList.add(new Music(R.raw.losangeles2019, "losangeles2019"));
        musicList.add(new Music(R.raw.lovef, "lovef"));
        musicList.add(new Music(R.raw.midunt, "midunt"));
        musicList.add(new Music(R.raw.mildlyarmang, "mildlyarmang"));
        musicList.add(new Music(R.raw.moonbeam, "moonbeam"));
        musicList.add(new Music(R.raw.nairobi, "nairobi"));
        musicList.add(new Music(R.raw.nassau, "nassau"));
        musicList.add(new Music(R.raw.nimits, "nimits"));
        musicList.add(new Music(R.raw.ontunt, "ontunt"));
        musicList.add(new Music(R.raw.organdub, "organdub"));
        musicList.add(new Music(R.raw.paradisesland, "paradisesland"));
        musicList.add(new Music(R.raw.pixiedust, "pixiedust"));
        musicList.add(new Music(R.raw.pizzicato, "pizzicato"));
        musicList.add(new Music(R.raw.plasticpipe, "plasticpipe"));
        musicList.add(new Music(R.raw.playa, "playa"));
        musicList.add(new Music(R.raw.radiation, "radiation"));
        musicList.add(new Music(R.raw.ringclassic02, "ringclassic02"));
        musicList.add(new Music(R.raw.roadtrip, "roadtrip"));
        musicList.add(new Music(R.raw.safari, "safari"));
        musicList.add(new Music(R.raw.seville, "seville"));
        musicList.add(new Music(R.raw.silkyway, "silkyway"));
        musicList.add(new Music(R.raw.spaceeed, "spaceeed"));
        musicList.add(new Music(R.raw.steppinout, "steppinout"));
        musicList.add(new Music(R.raw.tada, "tada"));
        musicList.add(new Music(R.raw.terminated, "terminated"));
        musicList.add(new Music(R.raw.thirdeye, "thirdeye"));
        musicList.add(new Music(R.raw.tinkerbell, "tinkerbell"));
        musicList.add(new Music(R.raw.tweeters, "tweeters"));
        musicList.add(new Music(R.raw.twirlaway, "twirlaway"));
        musicList.add(new Music(R.raw.voila, "voila"));
        musicList.add(new Music(R.raw.world, "world"));
    }

}