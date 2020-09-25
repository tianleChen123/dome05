package com.example.dome05;

public class Recent {
    private int pid;
    private String name;
    private String phone;
    private String time;
    private String timelong;

    public Recent(int pid, String name, String phone, String time, String timelong) {
        this.pid = pid;
        this.name = name;
        this.phone = phone;
        this.time = time;
        this.timelong = timelong;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimelong() {
        return timelong;
    }

    public void setTimelong(String timelong) {
        this.timelong = timelong;
    }
}
