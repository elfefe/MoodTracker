package com.moodtracker.elfefe.moodtracker.controller;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;

class MessageManager {
    private final Context context;

    MessageManager(Context context) {
        this.context = context;
    }

    void sendMessage(String number, String editTextComment) {

        SmsManager smsManager = SmsManager.getDefault();


        if (!number.equals("")) {
            smsManager.sendTextMessage(number,
                    null,
                    editTextComment,
                    null,
                    setPendingIntent());
        } else
            Toast.makeText(
                    context,
                    R.string.messagemanager_erreur_toast,
                    Toast.LENGTH_SHORT).show();
    }

    private PendingIntent setPendingIntent() {
        return PendingIntent.getBroadcast(
                context,
                0,
                new Intent(Intent.ACTION_VIEW).setDataAndType(RingtoneManager
                        .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), "audio/*"),
                0
        );
    }
}
