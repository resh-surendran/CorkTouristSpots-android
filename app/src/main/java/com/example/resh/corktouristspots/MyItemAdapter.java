package com.example.resh.corktouristspots;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MyItemAdapter extends ArrayAdapter {

    private Context context;
    private String [] placeNames;
    private String [] placeAddresses;
    private String [] images;
    private int resource;

    public MyItemAdapter(@NonNull Context context, int resource, String [] placeNames, String [] placeAddresses, String [] images) {
        super(context, resource, placeNames);

        this.context = context;
        this.images = images;
        this.placeNames = placeNames;
        this.placeAddresses = placeAddresses;
        this.resource = resource;
    }

    public View getView(int position, View view, ViewGroup group) {
        View row = null;

        //get an inflater and inflate row
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        //wire objects with row's widgets
        row = inflater.inflate(resource, null);

        //populate row's objects with data
        ImageView icon = row.findViewById(R.id.icon);
        TextView name = row.findViewById(R.id.name);
        TextView address = row.findViewById(R.id.address);

        name.setText(this.placeNames[position]);
        address.setText(this.placeAddresses[position]);

        String imageName = this.images[position];
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        icon.setImageResource(imageResId);

        return row;
    }

}

