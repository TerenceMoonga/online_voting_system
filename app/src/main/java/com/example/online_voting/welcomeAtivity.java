package com.example.online_voting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class welcomeAtivity extends AppCompatActivity {
    private ImageView voteImageOnWelc;
    private Button Login, Register;
    DatabaseReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_ativity);
        voteImageOnWelc=findViewById(R.id.imageView);
        Login = (Button) findViewById(R.id.login);
        Register = (Button) findViewById(R.id.register);


        mref = FirebaseDatabase.getInstance().getReference();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(welcomeAtivity.this, Start.class);
                startActivity(i);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcomeAtivity.this, Start.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}