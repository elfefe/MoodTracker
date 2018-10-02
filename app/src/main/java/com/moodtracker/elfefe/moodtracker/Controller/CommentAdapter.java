package com.moodtracker.elfefe.moodtracker.Controller;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private ArrayList<String> mlist;

    public CommentAdapter(ArrayList<String> list){
        mlist = list;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        view.setBackgroundColor(150);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            view.setElevation(30);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.display(mlist,i);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        ArrayList<String> list;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.comment_img);
            textView = itemView.findViewById(R.id.comment_txt);
        }

        void display(ArrayList<String> list, int position){
            this.list = list;
            textView.setText(list.get(position));
        }
    }

}
