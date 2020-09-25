package com.example.dome05;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReallyActivty extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    private PersonAdapter personAdapter1;
    private SoundPool sp;
    private int music;
    private Button display;

    private Button DIALPAD;
    private Button RECENTS;
    private Button CONTACTS;

    public static List<Person> personList = new ArrayList<>();
    public static List<Recent> recentList = new ArrayList<>();

    public static PersonAdapter personAdapter;
    public static RecentAdapter recentAdapter;
    private Receiver1 receiver1;
    private Receiver2 receiver2;
    public static int pp = -1;

    private MyDatabaseHelper dbHelper1;
    private SQLiteDatabase db1;

    private MyDatabaseHelper dbHelper2;
    private SQLiteDatabase db2;

    private ProgressBar progressBar;


    public static final int UPDATE_TEXT = 1;
    public static final int DISPLAY_TEXT = 2;

//    @SuppressLint("HandlerLeak")
//    Handler handler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case DISPLAY_TEXT:
//                    //将读到的数据给到recycleView上显示
//                    RecyclerView recyclerView = findViewById(R.id.person_list);
//                    LinearLayoutManager layoutManager = new LinearLayoutManager(ReallyActivty.this);
//                    recyclerView.setLayoutManager(layoutManager);
//                    personAdapter = new PersonAdapter(personList);
//                    recyclerView.setAdapter(personAdapter);
//                    break;
//                default:
//                    break;
//            }
//        }
//    };

//    class NumThread extends Thread {
//        public Handler mHandler;
//
//        @SuppressLint("HandlerLeak")
//        public void run() {
//            Looper.prepare();
//            mHandler = new Handler() {
//                //定义消息处理的方法
//                @Override
//                public void handleMessage(@NonNull Message msg) {
//                    super.handleMessage(msg);
//                    if (msg.what == UPDATE_TEXT) {
//
//                        Log.d("TEST", "SUCCESS");
//
//                        Message message = new Message();
//                        message.what = DISPLAY_TEXT;
//                        dbHelper1 = new MyDatabaseHelper(ReallyActivty.this, "People.db", null, 1);
//                        db1 = dbHelper1.getWritableDatabase();
//                        //读数据
//                        initPersons();
//                        handler.sendMessage(message);
//                    }
//                }
//            };
//            Looper.loop();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.really_main);
        replaceFragment(new PersonFragment());

        DialPadFragment dialPadFragment = (DialPadFragment) getSupportFragmentManager().findFragmentById(R.id.dialpad_frag);
        PersonFragment personFragment = (PersonFragment) getSupportFragmentManager().findFragmentById(R.id.person_frag);

        recyclerView = (RecyclerView) findViewById(R.id.person_list);
        personAdapter1 = new PersonAdapter(personList);
        display = (Button) findViewById(R.id.display);
        sp = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        music = sp.load(this, R.raw.doink, 1);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        DIALPAD = (Button) findViewById(R.id.btn_DIALPAD);
        RECENTS = (Button) findViewById(R.id.btn_RECENTS);
        CONTACTS = (Button) findViewById(R.id.btn_CONTACTS);
        // FAVOURITES = (Button) findViewById(R.id.btn_FAVOURITES);
        DIALPAD.setOnClickListener(this);
        RECENTS.setOnClickListener(this);
        CONTACTS.setOnClickListener(this);
        //  FAVOURITES.setOnClickListener(this);


//        final NumThread numThread = new NumThread();
//        numThread.start();
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        Message message = new Message();
//                        message.what = UPDATE_TEXT;
//                        //往数据库里插入数据
//                        initAll();
//                        numThread.mHandler.sendMessage(message);
//                    }
//                }).start();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_DIALPAD:
                replaceFragment(new DialPadFragment());

                DIALPAD.setBackgroundResource(R.drawable.dialpadgreen);
                RECENTS.setBackgroundResource(R.drawable.recent);
                CONTACTS.setBackgroundResource(R.drawable.contact);
                sp.play(music, 1, 1, 0, 0, 1);
                break;


            case R.id.btn_RECENTS:
                replaceFragment(new RecentFragment());
                RECENTS.setBackgroundResource(R.drawable.recentgreen);
                DIALPAD.setBackgroundResource(R.drawable.dialpad);
                CONTACTS.setBackgroundResource(R.drawable.contact);

                sp.play(music, 1, 1, 0, 0, 1);
                break;

            case R.id.btn_CONTACTS:
                replaceFragment(new PersonFragment());
                CONTACTS.setBackgroundResource(R.drawable.contactgreen);
                DIALPAD.setBackgroundResource(R.drawable.dialpad);
                RECENTS.setBackgroundResource(R.drawable.recent);
                sp.play(music, 1, 1, 0, 0, 1);
                break;

//            case R.id.btn_FAVOURITES:
//                sp.play(music,1,1,0,0,1);
//                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.top_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void init() {
        dbHelper1 = new MyDatabaseHelper(this, "People.db", null, 1);
        db1 = dbHelper1.getWritableDatabase();
        //initData();

        //RecyclerView填数据
        initPersons();
        RecyclerView recyclerView = findViewById(R.id.person_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        personAdapter = new PersonAdapter(personList);
        recyclerView.setAdapter(personAdapter);

        //注册动态广播
        IntentFilter intentFilter1 = new IntentFilter("MY_ACTION");
        IntentFilter intentFilter2 = new IntentFilter("MY_ACTION");
        intentFilter1.setPriority(200);
        intentFilter2.setPriority(50);
        receiver1 = new Receiver1();
        receiver2 = new Receiver2();
        registerReceiver(receiver1, intentFilter1);
        registerReceiver(receiver2, intentFilter2);
    }

    public void init2() {
        dbHelper2 = new MyDatabaseHelper(this, "People.db", null, 1);
        db2 = dbHelper2.getWritableDatabase();
        //initData();

        //RecyclerView填数据
        initRecents();
        RecyclerView recyclerView = findViewById(R.id.recent_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recentAdapter = new RecentAdapter(recentList);
        recyclerView.setAdapter(recentAdapter);

        //注册动态广播
        IntentFilter intentFilter1 = new IntentFilter("MY_ACTION");
        IntentFilter intentFilter2 = new IntentFilter("MY_ACTION");
        intentFilter1.setPriority(200);
        intentFilter2.setPriority(50);
        receiver1 = new Receiver1();
        receiver2 = new Receiver2();
        registerReceiver(receiver1, intentFilter1);
        registerReceiver(receiver2, intentFilter2);

    }

    public void unregister() {
        unregisterReceiver(receiver1);
        unregisterReceiver(receiver2);
    }

    public void initPersons() {
        personList.clear();
        Cursor cursor = db1.query("Person", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int pid = cursor.getInt(cursor.getColumnIndex("pid"));
            int imageId = cursor.getInt(cursor.getColumnIndex("iid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String num = cursor.getString(cursor.getColumnIndex("num"));
            int musicId = cursor.getInt(cursor.getColumnIndex("mid"));
            personList.add(new Person(pid, imageId, name, num, musicId));
        }
        cursor.close();
    }

    public void initRecents() {
        recentList.clear();
        Cursor cursor = db2.query("Recent", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int pid = cursor.getInt(cursor.getColumnIndex("pid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String timelong = cursor.getString(cursor.getColumnIndex("timelong"));
            recentList.add(new Recent(pid, name, phone, time, timelong));
        }
        cursor.close();
    }

    public void initAll() {
        dbHelper1 = new MyDatabaseHelper(this, "People.db", null, 1);
        db1 = dbHelper1.getWritableDatabase();
        ContentValues values = new ContentValues();
        List<Integer> imgIds = new ArrayList<>();
        imgIds.add(R.drawable.img_1);
        imgIds.add(R.drawable.img_2);
        imgIds.add(R.drawable.img_3);
        imgIds.add(R.drawable.img_4);
        imgIds.add(R.drawable.img_5);
        imgIds.add(R.drawable.img_6);
        imgIds.add(R.drawable.img_7);
        imgIds.add(R.drawable.img_8);
        imgIds.add(R.drawable.img_9);
        imgIds.add(R.drawable.img_10);
        imgIds.add(R.drawable.img_11);
        imgIds.add(R.drawable.img_12);
        imgIds.add(R.drawable.img_13);
        imgIds.add(R.drawable.img_14);
        imgIds.add(R.drawable.img_15);
        imgIds.add(R.drawable.img_16);
        imgIds.add(R.drawable.img_17);
        imgIds.add(R.drawable.img_18);
        imgIds.add(R.drawable.img_19);
        imgIds.add(R.drawable.img_20);
        imgIds.add(R.drawable.img_21);
        imgIds.add(R.drawable.img_22);
        imgIds.add(R.drawable.img_23);
        imgIds.add(R.drawable.img_24);
        imgIds.add(R.drawable.img_25);
        for (int i = 1; i <= 25; i++) {
            values.put("pid", i);
            values.put("iid", imgIds.get(i - 1));
            values.put("name", "Person" + i);
            values.put("num", "123456789" + i);
            values.put("mid", R.raw.bird);
            db1.insert("Person", null, values);
            values.clear();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remove_all:
                AlertDialog.Builder dialog = new AlertDialog.Builder(ReallyActivty.this);
                dialog.setTitle("Waring!!!");
                dialog.setMessage("确认全部删除吗？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        personList.clear();
                        personAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ReallyActivty.this, "没有删除联系人", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;

            case R.id.add:
                initRecents();
                recentAdapter.notifyDataSetChanged();
                break;

            case R.id.start:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initAll();
                    }
                }).start();

                // initAll();
                break;

            case R.id.display:

                ChangeTask changeTask = new ChangeTask();
                changeTask.execute();

            default:
                break;
        }

        return true;
    }

    public void initData() {
        ContentValues values = new ContentValues();
        List<Integer> imgIds = new ArrayList<>();
        imgIds.add(R.drawable.img_1);
        imgIds.add(R.drawable.img_2);
        imgIds.add(R.drawable.img_3);
        imgIds.add(R.drawable.img_4);
        imgIds.add(R.drawable.img_5);
        imgIds.add(R.drawable.img_6);
        imgIds.add(R.drawable.img_7);
        imgIds.add(R.drawable.img_8);
        imgIds.add(R.drawable.img_9);
        imgIds.add(R.drawable.img_10);
        imgIds.add(R.drawable.img_11);
        imgIds.add(R.drawable.img_12);
        imgIds.add(R.drawable.img_13);
        imgIds.add(R.drawable.img_14);
        imgIds.add(R.drawable.img_15);
        imgIds.add(R.drawable.img_16);
        imgIds.add(R.drawable.img_17);
        imgIds.add(R.drawable.img_18);
        imgIds.add(R.drawable.img_19);
        imgIds.add(R.drawable.img_20);
        imgIds.add(R.drawable.img_21);
        imgIds.add(R.drawable.img_22);
        imgIds.add(R.drawable.img_23);
        imgIds.add(R.drawable.img_24);
        imgIds.add(R.drawable.img_25);
        for (int i = 1; i <= 25; i++) {
            values.put("pid", i);
            values.put("iid", imgIds.get(i - 1));
            values.put("name", "Person" + i);
            values.put("num", "123456789" + i);
            values.put("mid", R.raw.bird);
            db1.insert("Person", null, values);
            values.clear();
        }
    }


    class ChangeTask extends AsyncTask<String, Integer, String> {

        public ChangeTask() {
        }

        @Override
        protected String doInBackground(String... strings) {
            int i = 0;
            if (i != 100) {
                for (i = 0; i <= 100; i += 20) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(i);
                }
            }
            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);

            if (progressBar.getProgress() == 100) {
                progressBar.setVisibility(View.GONE);
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            init();
        }
    }


}