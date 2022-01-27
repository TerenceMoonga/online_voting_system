package com.example.online_voting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //private TextView welcome,welcome2,welcome3;
    private ImageView voteImageOnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        voteImageOnMain=findViewById(R.id.imageView3);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,Start.class);
                MainActivity.this.startActivity(i);
                MainActivity.this.finish();
            }
        },3000);
    }
}