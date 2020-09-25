package com.example.dome05;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {

    private List<Recent> mRecentList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView recentname;
        TextView recentphone;
        TextView recenttime;
        TextView recenttimelong;
        View recentView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recentname = itemView.findViewById(R.id.recent_name);
            recentphone = itemView.findViewById(R.id.recent_phone);
            recenttime = itemView.findViewById(R.id.recent_time);
            recenttimelong = itemView.findViewById(R.id.recent_timelong);
            recentView = itemView;
        }
    }

    public RecentAdapter(List<Recent> recentList) {
        this.mRecentList = recentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recent recent = mRecentList.get(position);

        holder.recentname.setText(recent.getName());
        holder.recentphone.setText(recent.getPhone());
        holder.recenttime.setText(recent.getTime());
        holder.recenttimelong.setText(recent.getTimelong());

    }

    @Override
    public int getItemCount() {
        return mRecentList.size();
    }

}
