package com.example.dome05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class Receiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int position = intent.getIntExtra("position", 0);
        //Person person = personList.get(position);
        //Person person2 = personList.get(position+1);
        //person.setName(person2.getName());
        //person.setNum(person2.getNum());
        //personList.set(position, person);
        //MainActivity.personAdapter.notifyDataSetChanged();
        setResultData((position) + "");
        //abortBroadcast();
    }
}
