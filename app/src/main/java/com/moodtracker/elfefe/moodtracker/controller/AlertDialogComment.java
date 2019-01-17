package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.CommentRealmDAO;
import com.moodtracker.elfefe.moodtracker.model.Mood;

class AlertDialogComment extends AlertDialog{

    private final Context context;

    AlertDialogComment(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    AlertDialog getAlertDialogComment(Mood mood, CommentRealmDAO commentRealmDAO, AutoCompleteTextView autoCompleteTextView) {
        EditText etComment = new EditText(context);
        MessageManager messageManager = new MessageManager(context);
        return new Builder(context)
                .setTitle(R.string.commentaire_title_bld)
                .setView(etComment)
                .setNeutralButton(R.string.commentaire_neutral_bld, (dialog, which) -> {
                })
                // Save it
                .setNegativeButton(R.string.commentaire_negative_bld, (dialog, which) -> commentRealmDAO.setCommentRealm(etComment.getText().toString(), mood))
                // Share it
                .setPositiveButton(R.string.commentaire_positive_bld, (dialog, which) ->
                        new Builder(context)
                                .setTitle(R.string.message_title_bld)
                                .setView(autoCompleteTextView)
                                .setPositiveButton(R.string.message_positive_bld, ((dialog1, which1) -> {
                                    messageManager.sendMessage(autoCompleteTextView.getText().toString(), etComment.getText().toString());
                                    commentRealmDAO.setCommentRealm(etComment.getText().toString(), mood);
                                }))
                                .setCancelable(true)
                                .create()
                                .show())
                .setCancelable(true)
                .create();
    }
}
