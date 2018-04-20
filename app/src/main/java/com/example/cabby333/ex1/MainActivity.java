package com.example.cabby333.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{

    private ListView mListView;
    private ArrayList<ChatBox> chatBoxArr = new ArrayList<>();
    protected DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    protected Date date = new Date();
    private String TAG = "orile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mListView = findViewById(R.id.OriListView);
        Button msgButton = findViewById(R.id.SendButton);
        Log.i(TAG, "onCreate");
        msgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "onClickChat");
                String currName = findViewById(R.id.name).toString();
                System.out.println(currName);
                String currInput = findViewById(R.id.msgInput).toString();
                String currTime = dateFormat.format(date);

                ChatBox newChatBox = new ChatBox(currName, currInput, currTime);
                chatBoxArr.add(newChatBox);

                CustomAdaptor adapter = new CustomAdaptor(getBaseContext(), chatBoxArr);
                mListView.setAdapter(adapter);

            }
        });

    }


//    private static final String TAG = "orile";

//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        Intent intent = new Intent(this, ChatActivity.class);
//        setContentView(R.layout.activity_chat);
//        startActivity(intent);
//        setContentView(R.layout.activity_main);

//        Button chatButton = findViewById(R.id.chatButton);
//        chatButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                myfunc(v);
//            }
//        });
//    }

//    public void myfunc(View view)
//    {
//        Log.i(TAG, "onCreate");
//        Intent intent = new Intent(this, ChatActivity.class);
//        setContentView(R.layout.activity_chat);
//        startActivity(intent);
//    }
}
