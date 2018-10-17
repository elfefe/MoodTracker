package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteAdapter  extends ArrayAdapter<Contacts> {

    private Context mContext;
    private List<Contacts> contactsList;

    AutoCompleteAdapter(@NonNull Context context, ArrayList<Contacts> list) {
        super(context, 0 , list);
        mContext = context;
        contactsList = list;
    }

    @Override
    public int getCount() {
        return contactsList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.auto_complete,parent,false);

        Contacts contacts = contactsList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.image);
        image.setImageURI(Uri.parse(contacts.getmImage()));

        TextView name = (TextView) listItem.findViewById(R.id.name);
        name.setText(contacts.getmName());

        TextView number = (TextView) listItem.findViewById(R.id.number);
        number.setText(contacts.getmNumber());

        return listItem;
    }
}
