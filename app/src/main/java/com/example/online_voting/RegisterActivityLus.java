package com.example.online_voting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivityLus extends AppCompatActivity {
    private static final String TAG = "RegisterActivityLus";
    private EditText Name,Password,Phone,Nrc;
    private Button Register,Users;
    private FirebaseFirestore fStore;

    private ProgressDialog LoadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_lus);
        Users=findViewById(R.id.takeMeToLoginLus);
        Name=(EditText)findViewById(R.id.nameEntryLus);
        Password=(EditText)findViewById(R.id.passwordentryLus);
        Phone=(EditText)findViewById(R.id.phoneentryLus);
        Nrc=findViewById(R.id.nrcLus);
        Register=(Button)findViewById(R.id.registerbuttonLus);

        fStore= FirebaseFirestore.getInstance();

        Users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegisterActivityLus.this, LoginActivityLus.class);
                startActivity(i);

            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(Name.getText().toString()))
                {
                    Toast.makeText(RegisterActivityLus.this, "Please enter your name first..", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(Phone.getText().toString()))
                {
                    Toast.makeText(RegisterActivityLus.this, "Please enter your Phone Number first..", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(Nrc.getText().toString()))
                {
                    Toast.makeText(RegisterActivityLus.this,"please enter your Nrc..",Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(Password.getText().toString()))
                {
                    Toast.makeText(RegisterActivityLus.this, "Please enter your password first..", Toast.LENGTH_SHORT).show();
                }
                else if(Phone.getText().toString().length()<10)
                {
                    Toast.makeText(RegisterActivityLus.this, "Please enter correct Phone Number..", Toast.LENGTH_SHORT).show();
                }

                else
                {

                    CheckValidationByNRC();

                }
            }

        });
    }
        private void CheckValidationByNRC(){
            fStore.collection("Government").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    QuerySnapshot data = task.getResult();
                    for(DocumentSnapshot documentSnapshot:data.getDocuments()){
                        String pass= documentSnapshot.getString("PASSWORD");
                        String nrc= documentSnapshot.getString("NRC");

                        if(pass.equals(Password.getText().toString())&& nrc.equals(Nrc.getText().toString())){

                            Toast.makeText(RegisterActivityLus.this,nrc, Toast.LENGTH_SHORT).show();
                            AwayFromHome();
                            break;
                        }
                    }

                }
            });

        }

        private void AwayFromHome(){
            fStore.collection("kafueConstituency").document("RegisteredVoters").collection("reg").get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            QuerySnapshot data = task.getResult();
                            for(DocumentSnapshot documentSnapshot:data.getDocuments()){
                                String nrcID = documentSnapshot.getString("NRC");
                                if(nrcID.equals(Nrc.getText().toString())){
                                    Toast.makeText(RegisterActivityLus.this, "Already Registered to Kafue Constituency", Toast.LENGTH_SHORT).show();
                                    //CreateAccount(PHONE,NAME,PASSWORD,NRC);
                                    break;
                                }
                                else{
                                    Toast.makeText(RegisterActivityLus.this, "", Toast.LENGTH_SHORT).show();
                                    checkingWithin();
                                    break;
                                }

                            }
                        }
                    });
        }
    private void checkingWithin(){
        fStore.collection("LusakaConstituency").document("RegisteredVoters").collection("reg").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot data = task.getResult();
                        for(DocumentSnapshot documentSnapshot:data.getDocuments()){
                            String nrcID = documentSnapshot.getString("NRC");
                            if(nrcID.equals(Nrc.getText().toString())){
                                Toast.makeText(RegisterActivityLus.this, "Already Registered", Toast.LENGTH_SHORT).show();
                                //CreateAccount(PHONE,NAME,PASSWORD,NRC);
                                break;
                            }
                            else{
                                Toast.makeText(RegisterActivityLus.this, "wait", Toast.LENGTH_SHORT).show();
                                CreateAccount(Phone,Name,Password,Nrc);
                                break;
                            }

                        }
                    }
                });
    }
        private void CreateAccount(EditText phone, EditText name, EditText password,EditText nrclus) {
            Map<String,Object> details=new HashMap<String,Object>();
            details.put("Phone",phone.getText().toString());
            details.put("Name",name.getText().toString());
            details.put("Password",password.getText().toString());
            details.put("NRC",nrclus.getText().toString());

            fStore.collection("LusakaConstituency").document("RegisteredVoters").collection("reg").add(details).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(RegisterActivityLus.this, "Registered Successfully..", Toast.LENGTH_LONG).show();

                    }
                    else
                    {

                        Toast.makeText(RegisterActivityLus.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            });

        }
    }



