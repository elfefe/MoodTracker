package com.moodtracker.elfefe.moodtracker.model;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.controller.GestureListener;
import com.moodtracker.elfefe.moodtracker.controller.LoaderMainView;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {



    private ConstraintLayout main;
    private ImageView mImage;
    private ImageButton mImageComment,mImageHistory;
    private String state;
    public static final String STATE_KEY  = "STATE_KEY";

    private int[] color = new int[]{
                        R.color.happy,
                        R.color.good,
                        R.color.average,
                        R.color.sad,
                        R.color.angry
                },feeling = new int[]{
                        R.drawable.happy,
                        R.drawable.good,
                        R.drawable.average,
                        R.drawable.sad,
                        R.drawable.angry
                };

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        out.println("MainActivity::onCreate()");

        setContentView(R.layout.activity_main);

        main = findViewById(R.id.mainView);
        mImage = findViewById(R.id.imageView);
        mImageHistory = findViewById(R.id.imageHistory);
        mImageComment = findViewById(R.id.imageComment);

        LoaderMainView mainView = new LoaderMainView(this,main,mImage,mImageHistory,mImageComment);

        GestureListener gestureListener = new GestureListener(mainView,color,feeling);

        mainView.setFeeling(color[gestureListener.getValueX()],feeling[gestureListener.getValueX()]);

        mGestureDetector = new GestureDetector(this,gestureListener);




        mImageComment.setOnClickListener(v -> {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);

            final EditText input = new EditText(this);

            builder.setTitle("Commentaire")
                    .setView(input)
                    .setNegativeButton("Annuler", (dialog, which) -> {})
                    .setPositiveButton("Valilder", (dialog, which) ->
                            state = input.getText().toString())
                    .setCancelable(true)
                    .create()
                    .show();

        });

        mImageHistory.setOnClickListener(v ->{

            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);

            intent.putExtra(STATE_KEY, state);

            startActivity(intent);

        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event) ;
    }


    @Override
    protected void onStart() {
        super.onStart();

        out.println("MainActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        out.println("MainActivity::onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();

        out.println("MainActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        out.println("MainActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        out.println("MainActivity::onDestroy()");
    }
}
