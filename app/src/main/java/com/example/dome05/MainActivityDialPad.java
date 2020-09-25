package com.example.dome05;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDialPad extends AppCompatActivity implements View.OnClickListener {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialpad);

        sp = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        music = sp.load(this, R.raw.doink, 1);

        textseeview = (TextView) findViewById(R.id.text_seeview);
        textdialview = (TextView) findViewById(R.id.text_dialview);

        delete = (Button) findViewById(R.id.btn_delete);
        btnone = (Button) findViewById(R.id.btn_one);
        btntwo = (Button) findViewById(R.id.btn_two);
        btnthree = (Button) findViewById(R.id.btn_three);
        btnfour = (Button) findViewById(R.id.btn_four);
        btnfive = (Button) findViewById(R.id.btn_five);
        btnsix = (Button) findViewById(R.id.btn_six);
        btnseven = (Button) findViewById(R.id.btn_seven);
        btneight = (Button) findViewById(R.id.btn_eight);
        btnnine = (Button) findViewById(R.id.btn_nine);
        btnzero = (Button) findViewById(R.id.btn_zero);
        btnxing = (Button) findViewById(R.id.btn_xing);
        btnjing = (Button) findViewById(R.id.btn_jing);
        dial = (Button) findViewById(R.id.btn_dial);
        DIALPAD = (Button) findViewById(R.id.btn_DIALPAD);
        RECENTS = (Button) findViewById(R.id.btn_RECENTS);
        CONTACTS = (Button) findViewById(R.id.btn_CONTACTS);
        // FAVOURITES = (Button) findViewById(R.id.btn_FAVOURITES);
        delete.setOnClickListener(this);
        btnone.setOnClickListener(this);
        btntwo.setOnClickListener(this);
        btnthree.setOnClickListener(this);
        btnfour.setOnClickListener(this);
        btnfive.setOnClickListener(this);
        btnsix.setOnClickListener(this);
        btnseven.setOnClickListener(this);
        btneight.setOnClickListener(this);
        btnnine.setOnClickListener(this);
        btnzero.setOnClickListener(this);
        dial.setOnClickListener(this);
        btnxing.setOnClickListener(this);
        btnjing.setOnClickListener(this);
        DIALPAD.setOnClickListener(this);
        RECENTS.setOnClickListener(this);
        CONTACTS.setOnClickListener(this);
        FAVOURITES.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_delete:
                all = all.substring(0, all.length() - 1);
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_one:
                tempText = (TextView) findViewById(R.id.btn_one);
                all += 1;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_two:
                tempText = (TextView) findViewById(R.id.btn_two);
                all += 2;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_three:
                tempText = (TextView) findViewById(R.id.btn_three);
                all += 3;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_four:
                tempText = (TextView) findViewById(R.id.btn_four);
                all += 4;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_five:
                tempText = (TextView) findViewById(R.id.btn_five);
                all += 5;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_six:
                tempText = (TextView) findViewById(R.id.btn_six);
                all += 6;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_seven:
                tempText = (TextView) findViewById(R.id.btn_seven);
                all += 7;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_eight:
                tempText = (TextView) findViewById(R.id.btn_eight);
                all += 8;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_nine:
                tempText = (TextView) findViewById(R.id.btn_nine);
                all += 9;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_xing:
                tempText = (TextView) findViewById(R.id.btn_xing);
                all += "*";
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_zero:
                tempText = (TextView) findViewById(R.id.btn_zero);
                all += 0;
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_jing:
                tempText = (TextView) findViewById(R.id.btn_jing);
                all += "#";
                textseeview.setText(all);
                textdialview.setText(all);
                sp.play(music, 1, 1, 0, 0, 1);
                break;

            case R.id.btn_DIALPAD:
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_RECENTS:
                sp.play(music, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_CONTACTS:
                sp.play(music, 1, 1, 0, 0, 1);
                break;
//            case R.id.btn_FAVOURITES:
//                sp.play(music,1,1,0,0,1);
//                break;
            default:
                break;
        }
    }
}