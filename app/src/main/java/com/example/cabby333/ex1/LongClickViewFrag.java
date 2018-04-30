package com.example.cabby333.ex1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

public class LongClickViewFrag extends Fragment {

    private static final String TAG = "LongClickViewFrag";
    private static final String KEY_MESSAGE = "message";

//    @BindView(R.id.author)
//    TextView title;
//    @BindView(R.id.timestamp)
//    TextView timestamp;
//    @BindView(R.id.content)
//    TextView content;

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof MessageDeleted)
//    }

    public static LongClickViewFrag newInstance(ChatBox msg) {

        Log.i(TAG, "newInstance");
        Bundle args = new Bundle();
        args.putString(KEY_MESSAGE, msg.toString());

        LongClickViewFrag fragment = new LongClickViewFrag();
        fragment.setArguments(args);
        return fragment;
    }

}
