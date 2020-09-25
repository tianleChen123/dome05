package com.example.dome05;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment {

    public static List<Person> personList = new ArrayList<>();
    public static PersonAdapter personAdapter;


    public static int pp = -1;

    private SQLiteDatabase db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ReallyActivty reallyActivty = (ReallyActivty) getActivity();
        //   reallyActivty.init();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        ReallyActivty reallyActivty = (ReallyActivty) getActivity();
        reallyActivty.unregister();
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
            db.insert("Person", null, values);
            values.clear();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
                if (data != null) {
                    int musicId = data.getIntExtra("MusicId", 0);
                    //Toast.makeText(this, "musicId:" + musicId, Toast.LENGTH_SHORT).show();
                    if (pp != -1) {
                        Person person = personList.get(pp);
                        person.setMusicId(musicId);
                        personList.set(pp, person);
                        personAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

}
