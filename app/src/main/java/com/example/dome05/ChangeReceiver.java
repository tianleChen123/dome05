package com.example.dome05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Random;

public class ChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "语言换了", Toast.LENGTH_SHORT).show();
        Random random = new Random();
        int i = random.nextInt(30);
        intent = new Intent(context, DetailActivity.class);
        intent.putExtra("pid", i);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
