package com.example.cabby333.ex1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;


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

//        TextView textView = view.findViewById(R.id.fragment_message_text);
//        textView.setText("I am a Fragment");

        final Button button = view.findViewById(R.id.SendButton);

        EditText msgInput = view.findViewById(R.id.msgInput);
        msgInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                button.setEnabled(!TextUtils.isEmpty(s));
            }
        });

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
