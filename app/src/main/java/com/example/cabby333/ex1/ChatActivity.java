package com.example.cabby333.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ChatActivity extends AppCompatActivity {

    private static String myName = "Ori";
    private ArrayList<String> msgsArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        Button msgButton = findViewById(R.id.SendButton);
        msgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView msg = findViewById(R.id.chatBox);
                msgsArray.add(String.valueOf(msg));
            }
        });

    }

}
