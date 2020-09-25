package com.example.dome05;

public class Music {

    private int musicId;
    private String musicName;

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public Music(int musicId, String musicName) {
        this.musicId = musicId;
        this.musicName = musicName;
    }
}
