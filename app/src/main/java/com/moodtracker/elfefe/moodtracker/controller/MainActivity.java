package com.moodtracker.elfefe.moodtracker.controller;

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
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.StateStore;
import com.moodtracker.elfefe.moodtracker.model.Mood;

import java.util.Objects;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private String comment = "";
    private int feeling = 0;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        out.println("MainActivity::onCreate()");

        setContentView(R.layout.activity_main);

        ConstraintLayout mConstraintLayout = findViewById(R.id.mainView);
        ImageView mImage = findViewById(R.id.imageView);
        ImageButton mImageHistory = findViewById(R.id.imageHistory);
        ImageButton mImageComment = findViewById(R.id.imageComment);

        LoaderMainView mainView = new LoaderMainView(this, mConstraintLayout, mImage);

        GestureListener gestureListener = new GestureListener(mainView);

        gestureDetector = new GestureDetector(this,gestureListener);

        StateStore stateStore = new StateStore(this);
        LastMood lastMood = new LastMood(stateStore);

        if (stateStore.getQuery().findAll().isEmpty())
            mainView.setFeeling(Mood.GOOD.getColor(),Mood.GOOD.getFeeling());
        else
            mainView.setFeeling(lastMood.getMoodColor(),lastMood.getMoodFeeling());

        // Save your state or share it with the world
        mImageComment.setOnClickListener(v -> {

            final EditText etComment = new EditText(this);
            final AutoCompleteTextView autoCompleteTextView = new AutoCompleteTextView(this);
            final AutoCompleteManager autoCompleteManager = new AutoCompleteManager(this);
            final MessageManager messageManager = new MessageManager(this,
                                                                    this.comment,
                                                                    autoCompleteTextView.getText().toString(),
                                                                    etComment.getText().toString()
            );

            autoCompleteTextView.setAdapter(autoCompleteManager.autoCompleteAdapter());

            autoCompleteTextView.setOnItemClickListener((parent, view, position, id) ->
                    autoCompleteTextView.setText(autoCompleteManager.getContacts(position).getNumber()));

            new AlertDialog.Builder(this).setTitle(R.string.commentaire_title_bld)
                    .setView(etComment)
                    .setNeutralButton(R.string.commentaire_neutral_bld, (dialog, which) -> {})
                    // Save it
                    .setNegativeButton(R.string.commentaire_negative_bld, (dialog, which) ->{
                        this.comment = etComment.getText().toString();

                        feeling = Mood.values()[gestureListener.getValueX()].getColor();
                        stateStore.setCommentRealm(comment,feeling);
                        stateStore.realmTransactionCopyOrUpdate();
                    })
                    // Share it
                    .setPositiveButton(R.string.commentaire_positive_bld, (dialog, which) ->
                        new AlertDialog.Builder(this)
                            .setTitle(R.string.message_title_bld)
                            .setView(autoCompleteTextView)
                            .setPositiveButton(R.string.message_positive_bld, ((dialog1, which1) -> {
                                messageManager.sendMessage();
                                this.comment = messageManager.getComment();

                                feeling = Mood.values()[gestureListener.getValueX()].getColor();
                                stateStore.setCommentRealm(comment,feeling);
                                stateStore.realmTransactionCopyOrUpdate();
                            }))
                            .setCancelable(true)
                            .create()
                            .show())
                    .setCancelable(true)
                    .create()
                    .show();
        });

        // HistoryActivity intent
        mImageHistory.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HistoryActivity.class)));

        // If the last state saved is today show it in a toast
        if(stateStore.getQuery().findAll().size() != 0) {
            if (Objects.requireNonNull(stateStore
                    .getQuery()
                    .findAll()
                    .get(stateStore.getQuery().findAll().size() - 1))
                    .getId() == stateStore.getDate()) {
                Toast.makeText(
                        this,
                        Objects.requireNonNull(stateStore.getQuery()
                                .findAll()
                                .get(stateStore.getQuery().findAll().size() - 1))
                                .getComment(),
                        Toast.LENGTH_LONG)
                        .show();
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetector.onTouchEvent(event);
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
