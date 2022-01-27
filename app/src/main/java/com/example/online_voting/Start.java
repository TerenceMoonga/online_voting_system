package com.example.online_voting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {
    private Button Lusakabtn,kafuebtn,admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        Lusakabtn =findViewById(R.id.startLus);
        kafuebtn = findViewById(R.id.startKaf);
        admin=findViewById(R.id.ViewResultsAdmin);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this,Resultsk.class);
                startActivity(intent);
            }
        });

        Lusakabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this,RegisterActivityLus.class);
                startActivity(intent);
            }
        });

        kafuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this,RegisterActivitykaf.class);
                startActivity(intent);
            }
        });
    }
}