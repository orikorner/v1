package com.example.cabby333.ex1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MessageFragment extends DialogFragment {


    private static final String ARGS_MESSAGE = "args_message";
    private static final String TAG = "MessageFragment";
    private MessageFragmentListener listener;

    public static MessageFragment newInstance(String message) {
        Log.i(TAG, "newInstance");
        MessageFragment messageFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_MESSAGE, message);
        messageFragment.setArguments(bundle);

        return messageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onNextMessageClicked");
        View view = inflater.inflate(R.layout.fragment_message, container, false);

//        View layout = view.findViewById(R.id.fragment_message_layout);

        TextView textView = view.findViewById(R.id.fragment_message_text);
        textView.setText("I am a Fragment");

        Button button = view.findViewById(R.id.fragment_message_next_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick - Fragment");
                if (listener != null) {
                    listener.onNextMessageClicked();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.i(TAG, "onAttach");

        if (context instanceof MessageFragmentListener) {
            listener = (MessageFragmentListener) context;
        }

    }


}
