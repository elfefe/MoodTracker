package com.moodtracker.elfefe.moodtracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageGood;
    private ImageButton mImageHistory;
    private ImageButton mImageComment;
    public static final int HISTORY_ACTIVITY_REQUEST_CODE = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        mImageGood = (ImageView) findViewById(R.id.imageView);
        mImageHistory = (ImageButton) findViewById(R.id.imageHistory);
        mImageComment = (ImageButton) findViewById(R.id.imageComment);

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
}
