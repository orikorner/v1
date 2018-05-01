package com.example.cabby333.ex1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LongClickViewFrag extends Fragment {

    private static final String TAG = "LongClickViewFrag";
    private static final String KEY_MESSAGE = "message";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View v = inflater.inflate(R.layout.activity_chat, container, false);

        return v;


    }

    public static LongClickViewFrag newInstance(ChatBox msg) {

        Log.i(TAG, "newInstance");
        Bundle args = new Bundle();
        args.putString(KEY_MESSAGE, msg.toString());

        LongClickViewFrag fragment = new LongClickViewFrag();
        fragment.setArguments(args);
        return fragment;
    }

}
