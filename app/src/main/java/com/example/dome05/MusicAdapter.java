package com.example.dome05;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private List<Music> mMusicList;

    public MusicAdapter(List<Music> musicList) {
        this.mMusicList = musicList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView musicName;
        View musicView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            musicName = itemView.findViewById(R.id.music_name);
            musicView = itemView;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.musicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Music music = mMusicList.get(position);
                //Toast.makeText(view.getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("MusicId", music.getMusicId());
                MusicActivity context = (MusicActivity) holder.musicView.getContext();
                context.setResult(Activity.RESULT_OK, intent);
                context.finish();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music music = mMusicList.get(position);
        holder.musicName.setText(music.getMusicName());
    }

    @Override
    public int getItemCount() {
        return mMusicList.size();
    }


}
