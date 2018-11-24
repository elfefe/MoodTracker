package com.moodtracker.elfefe.moodtracker.controller;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;

class MessageManager {
    private final Context context;
    private String comment;
    private final String number;
    private final String editText;

    MessageManager(Context context, String comment, String number, String editText) {
        this.context = context;
        this.comment = comment;
        this.number = number;
        this.editText = editText;
    }

    void sendMessage(){

        SmsManager smsManager =  SmsManager.getDefault();


        if(!number.equals("")){
            smsManager.sendTextMessage(number,
                    null,
                    editText,
                    null,
                    setPendingIntent());
            comment = editText;
        }else
            Toast.makeText(
                    context,
                    R.string.messagemanager_erreur_toast,
                    Toast.LENGTH_SHORT).show();
    }

    public String getComment() {
        return comment;
    }

    private PendingIntent setPendingIntent() {
        return PendingIntent.getBroadcast(
                context,
                0,
               new Intent(Intent.ACTION_VIEW).setDataAndType(RingtoneManager
                    .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION),"audio/*"),
                0
        );
    }
}
