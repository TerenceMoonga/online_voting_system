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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivityKaf extends AppCompatActivity {
    private EditText nrc,Passwords;
    private Button Login1;
    private FirebaseFirestore fStore;
    private ProgressDialog LoadingBar;
    TextView Newuser;
    SharedPreferences spStateButton1;
    SharedPreferences.Editor spEditor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_kaf);

            nrc=(EditText)findViewById(R.id.loginNrcKaf);
            Passwords=(EditText)findViewById(R.id.loginpasswordKaf);
            Login1=(Button)findViewById(R.id.loginbuttonKaf);
            Newuser=(TextView)findViewById(R.id.NewuserKaf);
            LoadingBar=new ProgressDialog(this);


            fStore=FirebaseFirestore.getInstance();

        Newuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(LoginActivityKaf.this, RegisterActivityLus.class);
                    startActivity(i);
                }
            });
           Login1.setEnabled(getButtonState());

            Login1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(TextUtils.isEmpty(nrc.getText().toString()))
                    {
                        Toast.makeText(LoginActivityKaf.this, "Please enter your NRC number..", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(Passwords.getText().toString()))
                    {
                        Toast.makeText(LoginActivityKaf.this, "Please enter your password...", Toast.LENGTH_SHORT).show();
                    }
                    else if(nrc.getText().toString().length() <1)
                    {
                        Toast.makeText(LoginActivityKaf.this, "Please enter correct NRC number..", Toast.LENGTH_SHORT).show();
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

        fStore.collection("kafueConstituency").document("RegisteredVoters").collection("reg").get()
    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                QuerySnapshot data = task.getResult();
                for(DocumentSnapshot documentSnapshot: data.getDocuments()){
                    String password =documentSnapshot.getString("Password");
                    String studentID = documentSnapshot.getString("NRC");

                    if(password.equals(Passwords.getText().toString()) && studentID.equals(nrc.getText().toString())){
                        Intent i=new Intent(LoginActivityKaf.this,HomeActivity.class);
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
    spEditor1.putBoolean("btn_state1", enabled);
    spEditor1.commit();
}
    public boolean getButtonState(){
        return spStateButton1.getBoolean("btn_state1", true);
    }
}
