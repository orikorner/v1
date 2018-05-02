package com.example.cabby333.ex1;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class CustomAdaptor extends BaseAdapter
{

    final private ArrayList<ChatBox> msgs;
    private String TAG = "CustomAdapter";
    private LongClickViewFrag fragment;

    CustomAdaptor(ArrayList<ChatBox> items, LongClickViewFrag fragment) {
        this.msgs = items;
        this.fragment = fragment;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Log.i(TAG, "getView");
        @SuppressLint("ViewHolder") View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_row, parent, false);
        TextView outBox = (TextView) rowItem.findViewById(R.id.line);
        ImageView outImage = (ImageView) rowItem.findViewById(R.id.oriIm);

        ChatBox currChatBox = getItem(position);

        String newLine = "(" + currChatBox.getTimeStamp() + ")\n" + "From: " + currChatBox.getName() + "\n" + currChatBox.getMsg();
        currChatBox.setFullMsg(newLine);
        outBox.setText(newLine);
        outImage.setImageResource(R.drawable.ori);

        rowItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG, "onLongClick");
                TextView chatBoxMsg = (TextView)v.findViewById(R.id.line);
                fragment.setMsg(chatBoxMsg.getText().toString());
                return true;
            }
        });

        return rowItem;
    }

    public void addMessage(ChatBox newMsg)
    {
        Log.i(TAG, "addMessage");
        msgs.add(newMsg);
    }

    public void deleteMessage(String message) {
        int index = -1;
        Log.i(TAG, "deleteMessage");
        for (int i = 0; i < msgs.size(); i++) {
            if (msgs.get(i).getFullMsg().equals(message)) {
                index = i;
                Log.i(TAG, "deleteMessageFound");
                break;
            }
        }

        if (index != -1) {
            Log.i(TAG, "deleteMessageFound2");
            msgs.remove(index);
        }
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

}
