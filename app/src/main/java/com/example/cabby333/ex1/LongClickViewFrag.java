package com.example.cabby333.ex1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LongClickViewFrag extends Fragment {

    private static final String TAG = "LongClickViewFrag";
    private TextView msg;
    private View thisView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        thisView = inflater.inflate(R.layout.activity_chat, container, false);
        msg = thisView.findViewById(R.id.frag_line);
        ((Button) thisView.findViewById(R.id.BackButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisView.setVisibility(View.GONE);
                ((MainActivity)getActivity()).container.setVisibility(View.VISIBLE);
            }
        });
        return thisView;
    }


    public void setMsg(String newMsg)
    {
        Log.i(TAG, "setMsg");
        this.msg.setText(newMsg);
        thisView.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).container.setVisibility(View.GONE);
    }

}
