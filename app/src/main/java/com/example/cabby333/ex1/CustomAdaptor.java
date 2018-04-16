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

class CustomAdaptor extends BaseAdapter
{
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ChatBox> msgs;

    CustomAdaptor(Context context, ArrayList<ChatBox> items) {
        this.mContext = context;
        this.msgs = items;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowItem = mInflater.inflate(R.layout.custom_list_row, parent, false);
        TextView outBox = (TextView) rowItem.findViewById(R.id.line);
        ImageView outImage = (ImageView) rowItem.findViewById(R.id.oriIm);

        ChatBox currChatBox = getItem(position);

        outBox.setText(currChatBox.name);
        outImage.setImageResource(R.drawable.ori);

        return rowItem;
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public ChatBox getItem(int position) {
        return msgs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //    private static class ViewHolder {
//        public ImageView img;
//        public TextView line;
//    }
}
