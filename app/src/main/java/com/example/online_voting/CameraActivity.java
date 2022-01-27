package com.example.online_voting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {

    private Button faceDetectionButton,InstantVote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
InstantVote= (Button)findViewById(R.id.instantvote);
InstantVote.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i =new Intent(CameraActivity.this, Lusaka.class);
        //i.putExtra("phone",Phone);
        startActivity(i);
    }
});
        //mref = FirebaseDatabase.getInstance().getReference();


    }
}