package com.example.dome05;

public class Person {

    private int pid;
    private int imageId;
    private String name;
    private String num;
    private int musicId;

    public Person(int pid, int imageId, String name, String num, int musicId) {
        this.pid = pid;
        this.imageId = imageId;
        this.name = name;
        this.num = num;
        this.musicId = musicId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }
}
