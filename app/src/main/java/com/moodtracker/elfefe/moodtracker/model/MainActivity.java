package com.moodtracker.elfefe.moodtracker.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.controller.GestureListener;
import com.moodtracker.elfefe.moodtracker.controller.MessageManager;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private String state;
    private int feel;

    public static final String STATE_KEY  = "STATE_KEY";
    public static final String FEEL_KEY = "FEEL_KEY";

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        out.println("MainActivity::onCreate()");

        setContentView(R.layout.activity_main);

        ConstraintLayout main = findViewById(R.id.mainView);
        ImageView mImage = findViewById(R.id.imageView);
        ImageButton mImageHistory = findViewById(R.id.imageHistory);
        ImageButton mImageComment = findViewById(R.id.imageComment);

        LoaderMainView mainView = new LoaderMainView(this, main, mImage);

        GestureListener gestureListener = new GestureListener(mainView);

        mainView.setFeeling(Mood.GOOD.getColor(),Mood.GOOD.getFeeling());

        mGestureDetector = new GestureDetector(this,gestureListener);


        mImageComment.setOnClickListener(v -> {

            final EditText comment = new EditText(this);
            final AutoCompleteTextView autoCompleteTextView = new AutoCompleteTextView(this);
            final AutoCompleteManager autoCompleteManager = new AutoCompleteManager(this);
            final MessageManager messageManager = new MessageManager(this, state,autoCompleteTextView,comment);

            autoCompleteTextView.setAdapter(autoCompleteManager.autoCompleteAdapter());

            new AlertDialog.Builder(this).setTitle("Commentaire")
                    .setView(comment)
                    .setNeutralButton("Annuler", (dialog, which) -> {})
                    .setNegativeButton("Valilder", (dialog, which) ->
                        state = comment.getText().toString())
                    .setPositiveButton("Partager", (dialog, which) ->
                        new AlertDialog.Builder(this)
                            .setTitle("Numéro")
                            .setView(autoCompleteTextView)
                            .setPositiveButton("Envoyer", ((dialog1, which1) -> {
                                messageManager.commentManager();
                                state = messageManager.getState();
                            }))
                            .setCancelable(true)
                            .create()
                            .show())
                    .setCancelable(true)
                    .create()
                    .show();
        });

        mImageHistory.setOnClickListener(v ->{

            feel = Mood.values()[gestureListener.getValueX()].getColor();

            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);

            intent.putExtra(STATE_KEY, state);
            intent.putExtra(FEEL_KEY,feel);

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
