package com.example.dome05;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Date;

public class DialPadFragment extends Fragment {

    private TextView textseeview;
    private TextView textdialview;

    private SoundPool sp;
    private int music;

    private Button delete;
    private Button btnone;
    private Button btntwo;
    private Button btnthree;
    private Button btnfour;
    private Button btnfive;
    private Button btnsix;
    private Button btnseven;
    private Button btneight;
    private Button btnnine;
    private Button btnzero;
    private Button btnxing;
    private Button btnjing;

    private Button dial;

    private Button DIALPAD;
    private Button RECENTS;
    private Button CONTACTS;
    private Button FAVOURITES;

    private TextView tempText;
    private String all = "";

    private MyDatabaseHelper dbHelper1;
    private SQLiteDatabase db1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_dialpad, container, false);

        sp = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        music = sp.load(getContext(), R.raw.doink, 1);

        textseeview = (TextView) view.findViewById(R.id.text_seeview);
        textdialview = (TextView) view.findViewById(R.id.text_dialview);
        delete = (Button) view.findViewById(R.id.btn_delete);
        btnone = (Button) view.findViewById(R.id.btn_one);
        btntwo = (Button) view.findViewById(R.id.btn_two);
        btnthree = (Button) view.findViewById(R.id.btn_three);
        btnfour = (Button) view.findViewById(R.id.btn_four);
        btnfive = (Button) view.findViewById(R.id.btn_five);
        btnsix = (Button) view.findViewById(R.id.btn_six);
        btnseven = (Button) view.findViewById(R.id.btn_seven);
        btneight = (Button) view.findViewById(R.id.btn_eight);
        btnnine = (Button) view.findViewById(R.id.btn_nine);
        btnzero = (Button) view.findViewById(R.id.btn_zero);
        btnxing = (Button) view.findViewById(R.id.btn_xing);
        btnjing = (Button) view.findViewById(R.id.btn_jing);
        dial = (Button) view.findViewById(R.id.btn_dial);
        DIALPAD = (Button) view.findViewById(R.id.btn_DIALPAD);
        RECENTS = (Button) view.findViewById(R.id.btn_RECENTS);
        CONTACTS = (Button) view.findViewById(R.id.btn_CONTACTS);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all = all.substring(0, all.length() - 1);
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_one);
                all += 1;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_two);
                all += 2;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_three);
                all += 3;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });

        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_four);
                all += 4;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_five);
                all += 5;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_six);
                all += 6;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_seven);
                all += 7;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_eight);
                all += 8;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_nine);
                all += 9;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_zero);
                all += 0;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnjing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_jing);
                all += "#";
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        btnxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempText = (TextView) view.findViewById(R.id.btn_xing);
                all += "*";
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
            }
        });
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = all.toString();
                Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
                Date time = new Date();
                int time2 = time.getMinutes();
                dbHelper1 = new MyDatabaseHelper(getContext(), "People.db", null, 1);
                db1 = dbHelper1.getWritableDatabase();
                ContentValues values2 = new ContentValues();
                values2.put("name", data);
                values2.put("phone", data);
                values2.put("time", time2);
                values2.put("timelong", "14min");
                db1.insert("Recent", null, values2);
                values2.clear();
            }
        });
        return view;
    }
}
