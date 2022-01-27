package com.example.online_voting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
//import com.onlie.voting.onlinevotingsystem.Model.Users;
//import com.onlie.voting.onlinevotingsystem.Prevalent.Prevalent;


public class LoginActivityLus extends AppCompatActivity {
    private EditText nrc,Passwords;
    private Button Login;
    private DatabaseReference mref;
    private FirebaseFirestore fStore;
    private ProgressDialog LoadingBar;

    TextView Newuser;
    SharedPreferences spStateButton;
    SharedPreferences.Editor spEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_lus);
        nrc=(EditText)findViewById(R.id.loginNrclus);
        Passwords=(EditText)findViewById(R.id.loginpasswordlus);
        Login=(Button)findViewById(R.id.loginbuttonlus);
        Newuser=(TextView)findViewById(R.id.Newuserlus);
        LoadingBar=new ProgressDialog(this);
        fStore=FirebaseFirestore.getInstance();

        spStateButton= getApplicationContext().getSharedPreferences("Button_State", 0);
        spEditor = spStateButton.edit();

        Newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivityLus.this, RegisterActivityLus.class);
                startActivity(i);
            }
        });
        Login.setEnabled(getButtonState());

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(nrc.getText().toString()))
                {
                    Toast.makeText(LoginActivityLus.this, "Please enter your NRC number..", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(Passwords.getText().toString()))
                {
                    Toast.makeText(LoginActivityLus.this, "Please enter your password...", Toast.LENGTH_SHORT).show();
                }
                else if(nrc.getText().toString().length() <1)
                {
                    Toast.makeText(LoginActivityLus.this, "Please enter correct NRC number..", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    LoginUser();
                }
            }
        });
    }
    private void LoginUser() {



        LoadingBar.setTitle("Login Account");
        LoadingBar.setMessage("Please wait while we are checking our credentials..");
        LoadingBar.setCanceledOnTouchOutside(false);
        LoadingBar.show();

        AllowAccessToUser();
    }

    private void AllowAccessToUser() {

        fStore.collection("LusakaConstituency").document("RegisteredVoters").collection("reg").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        QuerySnapshot data = task.getResult();
        for(DocumentSnapshot documentSnapshot: data.getDocuments()){
            String password =documentSnapshot.getString("Password");
            String studentID = documentSnapshot.getString("NRC");
            if(password.equals(Passwords.getText().toString()) && studentID.equals(nrc.getText().toString())){

                Intent i=new Intent(LoginActivityLus.this,Home1.class);
                            startActivity(i);
                setButtonState(false);
                LoadingBar.dismiss();
                            break;
            }else {
                LoadingBar.dismiss();

            }
        }
    }
});


    }
    public void setButtonState(boolean enabled) {
        spEditor.putBoolean("btn_state", enabled);
        spEditor.commit();
    }
    public boolean getButtonState(){
        return spStateButton.getBoolean("btn_state", true);
    }


}