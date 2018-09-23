package com.moodtracker.elfefe.moodtracker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Message;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout main;
    private ImageView mImageGood;
    private ImageButton mImageComment,mImageHistory;
    private int happy,good,average,sad,angry;
    public static final int HISTORY_ACTIVITY_REQUEST_CODE = 42;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        happy = R.color.happy;
        good = R.color.good;


        main = findViewById(R.id.mainView);
        mImageGood = findViewById(R.id.imageView);
        mImageHistory = findViewById(R.id.imageHistory);
        mImageComment = findViewById(R.id.imageComment);

        setFeeling(R.color.happy,R.drawable.happy);


        mImageHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent gameActivityIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivityForResult(gameActivityIntent, HISTORY_ACTIVITY_REQUEST_CODE);

            }
        });
        mImageComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                final EditText input = new EditText(MainActivity.this);

                builder.setTitle("Commentaire")
                        .setView(input)
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("Valilder", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                            }
                        })
                        .setCancelable(true)
                        .create()
                        .show();

            }
        });
        
    }

    private int setFeeling(int color, int feeling){
        mImageGood.setImageResource(feeling);
        main.setBackgroundColor(getResources().getColor(color));
        mImageHistory.setBackgroundColor(getResources().getColor(color));
        mImageComment.setBackgroundColor(getResources().getColor(color));
        return color;
    }
}
