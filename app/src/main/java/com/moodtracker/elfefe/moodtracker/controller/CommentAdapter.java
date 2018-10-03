package com.moodtracker.elfefe.moodtracker.controller;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private ArrayList<HistoryValues> mlist;
    private int screenHeight;

    public CommentAdapter(ArrayList<HistoryValues> list, int screenHeight){
        mlist = list;
        this.screenHeight = screenHeight;
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public int getItemViewType(int position){
        return R.layout.list_cell;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,int position) {
        viewHolder.display(mlist,position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        ConstraintLayout constraintView;
        Space spaceView;

        ArrayList<HistoryValues> list;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            constraintView = itemView.findViewById(R.id.comment_view);
            spaceView = itemView.findViewById(R.id.spacer);
            imageView = itemView.findViewById(R.id.comment_img);
            textView = itemView.findViewById(R.id.comment_txt);
        }

        @SuppressLint("ResourceAsColor")
        void display(ArrayList<HistoryValues> list, int position){
            this.list = list;


            ConstraintLayout.LayoutParams parameter =(ConstraintLayout.LayoutParams) constraintView.getLayoutParams();


            itemView.getLayoutParams().height = screenHeight/8;

            Log.d("HEIGHT SCREEN", String.valueOf(screenHeight));
            Log.d("HEIGHT",String.valueOf(itemView.getHeight()));

            if(list.get(position).getQuoteColor() == R.color.angry)
                parameter.matchConstraintPercentWidth = 0.2f;
            else if(list.get(position).getQuoteColor() == R.color.sad)
                parameter.matchConstraintPercentWidth = 0.4f;
            else if(list.get(position).getQuoteColor() == R.color.average)
                parameter.matchConstraintPercentWidth = 0.6f;
            else if(list.get(position).getQuoteColor() == R.color.good)
                parameter.matchConstraintPercentWidth = 0.8f;
            else if(list.get(position).getQuoteColor() == R.color.happy)
                parameter.matchConstraintPercentWidth = 1f;

            constraintView.setBackgroundResource(list.get(position).getQuoteColor());

            textView.setText(list.get(position).getQuote());
        }
    }


}
