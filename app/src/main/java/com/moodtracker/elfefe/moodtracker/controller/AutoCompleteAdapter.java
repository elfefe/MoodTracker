package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.model.Contacts;

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
    public Filter getFilter() {
        return nameFilter;
    }

    private Filter nameFilter = new Filter() {
        @Override
        public String convertResultToString(Object resultValue) {
            return ((Contacts)(resultValue)).getName();
        }
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Contacts> items = new ArrayList<>();
            ArrayList<Contacts> contactsAll = (ArrayList<Contacts>) contactsList;
            if(constraint != null) {
                items.clear();
                for (Contacts contacts : contactsAll) {
                    if(contacts.getName().toLowerCase().contains(constraint.toString().toLowerCase())
                        || contacts.getNumber().toLowerCase().contains(constraint.toString().toLowerCase())){
                        items.add(contacts);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = items;
                filterResults.count = items.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<Contacts> filteredList = (ArrayList<Contacts>) results.values;
            if(results.count > 0) {
                clear();
                for (Contacts c : filteredList) {
                    add(c);
                }
                notifyDataSetChanged();
            }
        }
    };

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.auto_complete,parent,false);

        Contacts contacts = contactsList.get(position);

        TextView name = listItem.findViewById(R.id.name);
        name.setText(contacts.getName());

        TextView number = listItem.findViewById(R.id.number);
        number.setText(contacts.getNumber());

        return listItem;
    }
}
