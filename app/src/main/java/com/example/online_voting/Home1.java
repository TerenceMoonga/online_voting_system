package com.example.online_voting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Home1 extends AppCompatActivity {
    ImageView Auth1;

    private ProgressDialog LoadingBar;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        Auth1=(ImageView)findViewById(R.id.authenticate1);








        LoadingBar=new ProgressDialog(this);



        final Executor executor = Executors.newSingleThreadExecutor();





        final BiometricPrompt biometricPrompt = new BiometricPrompt.Builder(this)
                .setTitle("Fingerprint Authentication")
                .setSubtitle("")
                .setDescription("place you finger to vote")
                .setNegativeButton("Cancel", executor, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).build();

        final Home1 activity=this;

        Auth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home1.this, Lusaka.class);

                startActivity(i);


            } 
        });
    }
}