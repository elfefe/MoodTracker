package com.moodtracker.elfefe.moodtracker.model;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.controller.GestureListener;
import com.moodtracker.elfefe.moodtracker.controller.LoaderMainView;

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

        SmsManager sms = SmsManager.getDefault();

        ConstraintLayout main = findViewById(R.id.mainView);
        ImageView mImage = findViewById(R.id.imageView);
        ImageButton mImageHistory = findViewById(R.id.imageHistory);
        ImageButton mImageComment = findViewById(R.id.imageComment);

        LoaderMainView mainView = new LoaderMainView(this, main, mImage);

        GestureListener gestureListener = new GestureListener(mainView);

        mainView.setFeeling(Mood.GOOD.getColor(),Mood.GOOD.getFeeling());

        mGestureDetector = new GestureDetector(this,gestureListener);

        SoundPool soundPool;
        int sound;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build();
        }else
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);

        sound = soundPool.load(this,R.raw.ring,1);


        Uri notification = RingtoneManager.getDefaultUri(R.raw.ring);

        Intent soundIntent = new Intent().setData(notification);
        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,soundIntent, 0);

        mImageComment.setOnClickListener(v -> {

            final EditText comment = new EditText(this);
            final EditText input = new EditText(this);



            new AlertDialog.Builder(this).setTitle("Commentaire")
                    .setView(comment)
                    .setNeutralButton("Annuler", (dialog, which) -> {})
                    .setNegativeButton("Valilder", (dialog, which) ->
                        state = comment.getText().toString())
                    .setPositiveButton("Partager", (dialog, which) -> new AlertDialog.Builder(this)
                            .setTitle("Numéro")
                            .setView(input)
                            .setPositiveButton("Envoyer", ((dialog1, which1) ->{
                                    if(!input.getText().toString().equals("")){
                                        sms.sendTextMessage(input.getText().toString(),
                                    null,state = comment.getText().toString(),
                                              sentPI,
                                    null);
                                        state = comment.getText().toString();
                                    }else
                                        Toast.makeText(this,"Veuillez entrer un numéro de téléphone.",Toast.LENGTH_SHORT).show();
                                }))
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
