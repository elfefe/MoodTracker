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

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteAdapter  extends ArrayAdapter<Contacts> {

    private Context mContext;
    private List<Contacts> contactsList;
    private ArrayList<Contacts> items;
    private ArrayList<Contacts> contactsAll;
    private View listItem;

    AutoCompleteAdapter(@NonNull Context context, ArrayList<Contacts> list) {
        super(context, 0 , list);
        mContext = context;
        contactsList = list;
        contactsAll =  list;
        items = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return contactsList.size();
    }

    public View getView(){
        return listItem;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    private Filter nameFilter = new Filter() {
        @Override
        public String convertResultToString(Object resultValue) {
            return ((Contacts)(resultValue)).getmName();
        }
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if(constraint != null) {
                items.clear();
                for (Contacts contacts : contactsAll) {
                    if(contacts.getmName().toLowerCase().contains(constraint.toString().toLowerCase())
                        || contacts.getmNumber().toLowerCase().contains(constraint.toString().toLowerCase())){
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
        listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.auto_complete,parent,false);

        Contacts contacts = contactsList.get(position);

        TextView name = listItem.findViewById(R.id.name);
        name.setText(contacts.getmName());

        TextView number = listItem.findViewById(R.id.number);
        number.setText(contacts.getmNumber());

        return listItem;
    }
}
