package com.moodtracker.elfefe.moodtracker.controller;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.telephony.SmsManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MessageManager {
    private Context context;
    private String state;
    private PendingIntent pendingIntent;
    private AutoCompleteTextView autoCompleteTextView;
    private EditText editText;

    public MessageManager(Context context,String state,AutoCompleteTextView autoCompleteTextView,EditText editText) {
        this.context = context;
        this.state = state;
        this.autoCompleteTextView = autoCompleteTextView;
        this.editText = editText;
    }

    public void commentManager(){

        setPendingIntent();

        if(!autoCompleteTextView.getText().toString().equals("")){
            SmsManager.getDefault().sendTextMessage(autoCompleteTextView.getText().toString(),
                    null,state = editText.getText().toString(),
                    pendingIntent,
                    null);
            state = editText.getText().toString();
        }else
            Toast.makeText(
                    context,
                    "Veuillez entrer un numéro de téléphone.",
                    Toast.LENGTH_SHORT).show();
    }

    public String getState() {
        return state;
    }

    private void setPendingIntent() {
        pendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                new Intent()
                        .setData(RingtoneManager
                                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)),
                0
        );
    }
}
