package com.example.cabby333.ex1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity
{

    private CustomAdaptor mAdapter;
    private LongClickViewFrag fragment;
    protected DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public View container;
    private String TAG = "MainActivity";
    EditText msgInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

        container = findViewById(R.id.container);

        ListView mListView = findViewById(R.id.OriListView);

        ArrayList<ChatBox> chatBoxArr = new ArrayList<>();

        fragment = (LongClickViewFrag)getFragmentManager().findFragmentById(R.id.frame);

        mAdapter = new CustomAdaptor(chatBoxArr, fragment);
        mListView.setAdapter(mAdapter);



        final Button sendButton = findViewById(R.id.SendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "onClickChat");
                if (!TextUtils.isEmpty(msgInput.getText()))
                {
                    Date date = new Date();
                    EditText msgInp = findViewById(R.id.msgInput);
                    String currInput = msgInp.getText().toString();
                    String currTime = dateFormat.format(date);

                    final ChatBox newChatBox = new ChatBox("Ori", currInput, currTime);

                    mAdapter.addMessage(newChatBox);
                    msgInput.setText("");
                }
            }
        });

        msgInput = findViewById(R.id.msgInput);
        msgInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                sendButton.setEnabled(!TextUtils.isEmpty(s));
            }
        });
    }
}
