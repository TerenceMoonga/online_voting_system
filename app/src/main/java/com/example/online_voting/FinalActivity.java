package com.example.online_voting;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    TextView V1,V2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        V1=(TextView)findViewById(R.id.v1);
        V2=(TextView)findViewById(R.id.v2);


    }


    }
