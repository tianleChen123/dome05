package com.example.dome05;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetSpanner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private List<Person> mPersonList;
    public static final int MUSIC_RC = 1;
    private MyDatabaseHelper dbHelper1;
    private SQLiteDatabase db1;


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameView;
        TextView numView;
        Button setMusic;
        Button playMusic;
        View personView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_person);
            nameView = itemView.findViewById(R.id.name_person);
            numView = itemView.findViewById(R.id.num_person);
            setMusic = itemView.findViewById(R.id.set_music);
            playMusic = itemView.findViewById(R.id.play_music);
            personView = itemView;
        }
    }

    public PersonAdapter(List<Person> personList) {
        this.mPersonList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        Date time = new Date();
        final int time2 = time.getMinutes();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.personView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                //Toast.makeText(view.getContext(), "Position:   " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("MY_ACTION");
                intent.putExtra("position", position);
                intent.setFlags(0x01000000);
                view.getContext().sendOrderedBroadcast(intent, null);
            }
        });

        holder.setMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReallyActivty.pp = holder.getAdapterPosition();
                Intent intent = new Intent(view.getContext(), MusicActivity.class);
                //intent.putExtra("position",position);
                ((ReallyActivty) view.getContext()).startActivityForResult(intent, 1);
            }
        });

        holder.playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Person person = ReallyActivty.personList.get(position);
                int musicId = person.getMusicId();
                Intent intent = new Intent(view.getContext(), PlayService.class);
                intent.putExtra("MusicId", musicId);
                view.getContext().startService(intent);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = mPersonList.get(position);
        holder.imageView.setImageResource(person.getImageId());
        holder.nameView.setText(person.getName());
        holder.numView.setText(person.getNum());
        if (person.getPid() % 2 == 0) {
            holder.personView.setBackgroundResource(R.drawable.background_1);
        } else {
            holder.personView.setBackgroundResource(R.drawable.background_2);
        }
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

}
