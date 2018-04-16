package com.example.cabby333.ex1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by cabby333 on 4/16/18.
 */

public class CustomAdaptor extends ArrayAdapter<String>
{
    private LayoutInflater myInflater;

    CustomAdaptor(Context context, String[] msg) {
        super(context, R.layout.custom_list_row, msg);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myInflater = LayoutInflater.from(getContext());
        View myView = myInflater.inflate(R.layout.custom_list_row, parent, false);

        String msg = getItem(position);
        TextView myMsg = (TextView) myView.findViewById(R.id.rowData);
        ImageView myImage = (ImageView) myView.findViewById(R.id.imageView);

        myMsg.setText(msg);
        myImage.setImageResource(R.drawable.ori);
        return myView;
    }
}
