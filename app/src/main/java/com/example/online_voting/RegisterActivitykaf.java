package com.example.online_voting;


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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivitykaf extends AppCompatActivity {
    private EditText NAME,PASSWORD,PHONE,NRC;
    private Button REGISTER,users;
    private DatabaseReference mref;
    private FirebaseFirestore fStore;
    private static final String TAG="RegisterActivitykaf";

//    private ProgressDialog LoadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_kaf);
        users=findViewById(R.id.takeMeToLoginKaf);
        NAME=(EditText)findViewById(R.id.nameEntryKaf);
        PASSWORD=(EditText)findViewById(R.id.passwordentryKaf);
        PHONE=(EditText)findViewById(R.id.phoneentryKaf);
        NRC=findViewById(R.id.nrcKaf);
        REGISTER=(Button)findViewById(R.id.registerbuttonKaf);
        mref= FirebaseDatabase.getInstance().getReference();
        fStore= FirebaseFirestore.getInstance();

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegisterActivitykaf.this, LoginActivityKaf.class);
                startActivity(i);
            }
        });



        REGISTER.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(NAME.getText().toString()))
                {
                   Toast.makeText(RegisterActivitykaf.this, "Please enter your name first..", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(PHONE.getText().toString()))
                {
                    Toast.makeText(RegisterActivitykaf.this, "Please enter your Phone Number first..", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(NRC.getText().toString()))
                {
                    Toast.makeText(RegisterActivitykaf.this,"please enter your Student ID..",Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(PASSWORD.getText().toString()))
                {
                    Toast.makeText(RegisterActivitykaf.this, "Please enter your password first..", Toast.LENGTH_SHORT).show();
                }
                else if(PHONE.getText().toString().length()<10)
                {
                    Toast.makeText(RegisterActivitykaf.this, "Please enter correct Phone Number..", Toast.LENGTH_SHORT).show();
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

                    //Log.d(TAG,"onSucces"+ documentSnapshot.getData());
                    if(pass.equals(PASSWORD.getText().toString())&& nrc.equals(NRC.getText().toString())){
                        //RegisterUser();
                        //Log.d(TAG,"onSucces"+ documentSnapshot.getString("NRC"));
                        Toast.makeText(RegisterActivitykaf.this,nrc, Toast.LENGTH_SHORT).show();
                        AwayFromHome();
                        break;
                    }
                }

            }
        });

    }

    private void AwayFromHome(){
        fStore.collection("LusakaConstituency").document("RegisteredVoters").collection("reg").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot data = task.getResult();
                        for(DocumentSnapshot documentSnapshot:data.getDocuments()){
                            String nrcID = documentSnapshot.getString("NRC");
                            if(nrcID.equals(NRC.getText().toString())){
                                Toast.makeText(RegisterActivitykaf.this, "Already registered to Lusaka constituency", Toast.LENGTH_SHORT).show();

                                break;
                            }
                            else{
                                Toast.makeText(RegisterActivitykaf.this, "", Toast.LENGTH_SHORT).show();
                                checkingWithin();
                                break;
                            }

                        }
                    }
                });
    }
    private void checkingWithin(){
        fStore.collection("kafueConstituency").document("RegisteredVoters").collection("reg").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot data = task.getResult();
                        for(DocumentSnapshot documentSnapshot:data.getDocuments()){
                            String nrcID = documentSnapshot.getString("NRC");
                            if(nrcID.equals(NRC.getText().toString())){
                                Toast.makeText(RegisterActivitykaf.this, "Already registered", Toast.LENGTH_SHORT).show();
                                //CreateAccount(PHONE,NAME,PASSWORD,NRC);
                                break;
                            }
                            else{
                                Toast.makeText(RegisterActivitykaf.this, "wait", Toast.LENGTH_SHORT).show();
                                CreateAccount(PHONE,NAME,PASSWORD,NRC);
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

        fStore.collection("kafueConstituency").document("RegisteredVoters").collection("reg").add(details).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(RegisterActivitykaf.this, "Registered Successfully..", Toast.LENGTH_LONG).show();

                }
                else
                {

                    Toast.makeText(RegisterActivitykaf.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
}