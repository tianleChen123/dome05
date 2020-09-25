package com.example.dome05;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Random;

public class PlayService extends IntentService {

    public PlayService() {
        super("PlayService");
    }

    private MediaPlayer mediaPlayer;

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        assert intent != null;

        int musicId = intent.getIntExtra("MusicId", 0);
        //Toast.makeText(this, "musicId:" + musicId, Toast.LENGTH_SHORT).show();
        PlayMusic(musicId);

    }

    @Override
    public void onDestroy() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        }, 5000);    //延时5s执行

        super.onDestroy();
    }

    private void PlayMusic(int MusicId) {
        mediaPlayer = MediaPlayer.create(this, MusicId);
        mediaPlayer.start();
    }

}
