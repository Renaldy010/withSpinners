package com.example.withspinners;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class SpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> statesList;

    // Constructor accepts Context (from MainActivity) and a list of state abbreviations
    public SpinnerAdapter(Context context, List<String> states) {
        super(context, R.layout.my_selected_item, states);
        this.context = context;
        this.statesList = states;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.my_dropdown_item, parent, false);

        // TextViews
        TextView state = row.findViewById(R.id.text);


        state.setText(statesList.get(position));


        return row;
    }

}