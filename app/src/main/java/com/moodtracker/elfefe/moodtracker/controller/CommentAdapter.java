package com.moodtracker.elfefe.moodtracker.controller;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private ArrayList<HistoryValues> mlist;
    private int screenHeight;
    private Context context;

    public CommentAdapter(Context context, ArrayList<HistoryValues> list, int screenHeight){
        this.context = context;
        mlist = list;
        this.screenHeight = screenHeight;
    }

    @Override
    public int getItemCount() { return 7; }

    @Override
    public int getItemViewType(int position){ return R.layout.list_cell; }

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

        void display(ArrayList<HistoryValues> list, int position){
            this.list = list;

            ConstraintLayout.LayoutParams parameter =(ConstraintLayout.LayoutParams) constraintView.getLayoutParams();

            constraintView.setOnClickListener(v -> Toast.makeText(context,String.valueOf(list.get(position).getQuote()),Toast.LENGTH_LONG).show());

            itemView.getLayoutParams().height = screenHeight/7;

            Log.d("Height", String.valueOf(itemView.getLayoutParams().height));

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
            else{
                parameter.matchConstraintPercentWidth = 0.8f;
                constraintView.setBackgroundResource(R.color.good);
            }

            constraintView.setBackgroundResource(list.get(position).getQuoteColor());

            setDating(position,textView);
        }
    }
    @SuppressLint("SetTextI18n")
    private void setDating(int position, TextView textView){
        switch (position){
            case 0: textView.setText("Il y a une semaine");
                break;
            case 1: textView.setText("Il y a six jours");
                break;
            case 2: textView.setText("Il y a cinq jours");
                break;
            case 3: textView.setText("Il y a quatre jours");
                break;
            case 4: textView.setText("Il y a trois jours");
                break;
            case 5: textView.setText("Avant-hier");
                break;
            case 6: textView.setText("Hier");
                break;
        }
    }
}
