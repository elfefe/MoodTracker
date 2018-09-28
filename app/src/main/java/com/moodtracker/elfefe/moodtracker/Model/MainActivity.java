package com.moodtracker.elfefe.moodtracker.Model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.moodtracker.elfefe.moodtracker.Controller.GestureListener;
import com.moodtracker.elfefe.moodtracker.R;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity implements OnGestureListener{


    private SharedPreferences preferences;

    private ConstraintLayout main;
    private ImageView mImage;
    private ImageButton mImageComment,mImageHistory;
    private int happy,good,average,sad,angry;
    private String state;
    private static final int HISTORY_ACTIVITY_REQUEST_CODE = 42;
    public static final String STATE_KEY  = "STATE_KEY";
    private static final String PREF_KEY  = "PREF_KEY";
    private GestureDetector gestureDetector;
    private GestureListener gestureListener;
    private String flingYDetector;
    private int[] color,feeling;
    private int x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        out.println("MainActivity::onCreate()");

        setContentView(R.layout.activity_main);

        color = new int[]{
                R.color.happy,
                R.color.good,
                R.color.average,
                R.color.sad,
                R.color.angry
        };
        feeling = new int[]{
                R.drawable.happy,
                R.drawable.good,
                R.drawable.average,
                R.drawable.sad,
                R.drawable.angry
        };

        gestureDetector = new GestureDetector(this);

        preferences = getPreferences(MODE_PRIVATE);

        main = findViewById(R.id.mainView);
        mImage = findViewById(R.id.imageView);
        mImageHistory = findViewById(R.id.imageHistory);
        mImageComment = findViewById(R.id.imageComment);

        setFeeling(color[x],feeling[x]);


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
        
    }

    private void setFeeling(int color, int feeling){
        mImage.setImageResource(feeling);
        main.setBackgroundColor(getResources().getColor(color));
        mImageHistory.setBackgroundColor(getResources().getColor(color));
        mImageComment.setBackgroundColor(getResources().getColor(color));
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

        mImageHistory.setOnClickListener(v ->
                startActivity(new Intent(this, HistoryActivity.class)
                        .putExtra(state, STATE_KEY)));
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

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {

            if (velocityY < 0 && x<4){
                x++;
                Log.d("GESTURE:", String.valueOf(x));
                setFeeling(color[x],feeling[x]);
            }
            if (velocityY > 0 && x>0){
                x--;
                Log.d("GESTURE:", String.valueOf(x));
                setFeeling(color[x],feeling[x]);
            }
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event) ;
    }
}
