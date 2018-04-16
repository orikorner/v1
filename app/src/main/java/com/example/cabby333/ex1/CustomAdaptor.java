package com.example.cabby333.ex1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter
{
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String[]> msgs;

//    CustomAdaptor(Context context, String[] msg) {
//        super(context, R.layout.custom_list_row, msg);
//    }

    public CustomAdaptor(Context context, ArrayList<String[]> items) {
        mContext = context;
        msgs = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myInflater = LayoutInflater.from(getContext());
        View rowItem = myInflater.inflate(R.layout.custom_list_row, parent, false);

        TextView myMsg = (TextView) rowItem.findViewById(R.id.rowData);
        ImageView myImage = (ImageView) rowItem.findViewById(R.id.imageView);

        String[] msg = getItem(position);

        myMsg.setText(msg1);
        myImage.setImageResource(R.drawable.ori);
        return rowItem;
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public String[] getItem(int position) {
        return msgs.get(position);
    }

    @Override
    public int getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        public ImageView img, vader;
        public TextView name;
    }
}
