package com.example.dome05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import static com.example.dome05.ReallyActivty.personList;


public class DetailActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper1;
    private SQLiteDatabase db1;
    private EditText detailName;
    private EditText detailNum;
    private ProgressBar progressBar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final int position = getIntent().getIntExtra("position", 0);
        Person person = personList.get(position);
        final int pid = person.getPid();
        TextView detailId = findViewById(R.id.detail_id);
        detailName = findViewById(R.id.detail_name);
        detailNum = findViewById(R.id.detail_num);
        ImageView detailImage = findViewById(R.id.detail_image);
        progressBar = findViewById(R.id.progress_bar);
        detailId.setText("id:" + person.getPid());
        detailName.setText("name:" + person.getName());
        detailNum.setText("num:" + person.getNum());
        detailImage.setImageResource(person.getImageId());
        Button update = findViewById(R.id.update);
        Button del = findViewById(R.id.del);
        Button change = findViewById(R.id.change);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText detailName = findViewById(R.id.detail_name);
                EditText detailNum = findViewById(R.id.detail_num);
                String name = detailName.getText().toString().substring(5);
                String phone = detailNum.getText().toString().substring(4);
                Uri uri = Uri.parse("content://com.example.dome05.provider/Person/" + pid);
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("num", phone);
                getContentResolver().update(uri, values, null, null);
                //MyDatabaseHelper dbHelper = new MyDatabaseHelper(DetailActivity.this, "People.db", null, 1);
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                //db.update("Person",values,"pid = ?", new String[]{pid+""});
                Intent intent = new Intent(v.getContext(), ReallyActivty.class);
                startActivity(intent);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.dome05.provider/Person/" + pid);
                getContentResolver().delete(uri, null, null);
                Intent intent = new Intent(v.getContext(), ReallyActivty.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                EditText detailName = findViewById(R.id.detail_name);
                EditText detailNum = findViewById(R.id.detail_num);
                Date time = new Date();
                final int time2 = time.getMinutes();
                Toast.makeText(this, "这里是SET", Toast.LENGTH_SHORT).show();
                String name = detailName.getText().toString().substring(5);
                String phone = detailNum.getText().toString().substring(4);
                dbHelper1 = new MyDatabaseHelper(this, "People.db", null, 1);
                db1 = dbHelper1.getWritableDatabase();
                ContentValues values2 = new ContentValues();
                values2.put("name", name);
                values2.put("phone", phone);
                values2.put("time", time2);
                values2.put("timelong", "11min");
                db1.insert("Recent", null, values2);
                values2.clear();
                break;
            default:
                break;
        }
        return true;
    }
}

