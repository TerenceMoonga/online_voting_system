package com.example.online_voting;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Resultsk extends AppCompatActivity {
    private TextView terence,mupela,kangwa,suwi,milly,jane,joe,isco,garry;
    private TextView terry,mups,kang,paul,frank,james,miam,philip,isaac;
    private FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultsk);
        fStore=FirebaseFirestore.getInstance();
        //lusaka
        terry=findViewById(R.id.k2);
        mups=findViewById(R.id.k1);
        kang=findViewById(R.id.k3);
        paul=findViewById(R.id.k4);
        frank=findViewById(R.id.k5);
        james=findViewById(R.id.k6);
        miam=findViewById(R.id.k7);
        philip=findViewById(R.id.k8);
        isaac=findViewById(R.id.k9);

        //kafue
        terence=findViewById(R.id.R1);
        mupela=findViewById(R.id.R2);
        kangwa=findViewById(R.id.R3);
        suwi=findViewById(R.id.R4);
        milly=findViewById(R.id.R5);
        jane=findViewById(R.id.R6);
        joe=findViewById(R.id.R7);
        isco=findViewById(R.id.R8);
        garry=findViewById(R.id.R9);


                //kafue begins

        fStore.collection("kafueConstituency").document("presidential").collection("parties")
                .document("NIP").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res1 = data.get("voteCount").toString();
                terence.setText(res1);


            }
        });

        fStore.collection("kafueConstituency").document("presidential").collection("parties")
                .document("UIP").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res2 = data.get("voteCount").toString();
                mupela.setText(res2);


            }
        });

        fStore.collection("kafueConstituency").document("presidential").collection("parties")
                .document("TP").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res3 = data.get("voteCount").toString();
                kangwa.setText(res3);


            }
        });

        fStore.collection("kafueConstituency").document("MPs").collection("members")
                .document("Suwi").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res5 = data.get("voteCount").toString();
                suwi.setText(res5);


            }
        });

        fStore.collection("kafueConstituency").document("MPs").collection("members")
                .document("milly").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res6 = data.get("voteCount").toString();
                milly.setText(res6);


            }
        });

        fStore.collection("kafueConstituency").document("MPs").collection("members")
                .document("jane").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res = data.get("voteCount").toString();
                jane.setText(res);


            }
        });

        fStore.collection("kafueConstituency").document("councilor").collection("candidates")
                .document("joe").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String re = data.get("voteCount").toString();
                joe.setText(re);


            }
        });

        fStore.collection("kafueConstituency").document("councilor").collection("candidates")
                .document("isco").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res3 = data.get("voteCount").toString();
                isco.setText(res3);


            }
        });


        fStore.collection("kafueConstituency").document("councilor").collection("candidates")
                .document("gappy").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res3 = data.get("voteCount").toString();
                garry.setText(res3);


            }
        });
            //lusaka follows
        fStore.collection("LusakaConstituency").document("presidential").collection("parties")
                .document("NIP").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res1 = data.get("voteCount").toString();
                terry.setText(res1);


            }
        });

        fStore.collection("LusakaConstituency").document("presidential").collection("parties")
                .document("UIP").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res2 = data.get("voteCount").toString();
                mups.setText(res2);


            }
        });

        fStore.collection("LusakaConstituency").document("presidential").collection("parties")
                .document("TP").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res3 = data.get("voteCount").toString();
                kang.setText(res3);


            }
        });

        fStore.collection("LusakaConstituency").document("MPs").collection("members")
                .document("paul").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res5 = data.get("voteCount").toString();
                paul.setText(res5);


            }
        });

        fStore.collection("LusakaConstituency").document("MPs").collection("members")
                .document("Frank").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res6 = data.get("voteCount").toString();
                frank.setText(res6);


            }
        });

        fStore.collection("LusakaConstituency").document("MPs").collection("members")
                .document("james").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res = data.get("voteCount").toString();
                james.setText(res);


            }
        });

        fStore.collection("LusakaConstituency").document("Councilor").collection("candidates")
                .document("miam").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String re = data.get("voteCount").toString();
                miam.setText(re);


            }
        });

        fStore.collection("LusakaConstituency").document("Councilor").collection("candidates")
                .document("philip").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String resd = data.get("voteCount").toString();
                philip.setText(resd);


            }
        });


        fStore.collection("LusakaConstituency").document("Councilor").collection("candidates")
                .document("isaac").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot data = task.getResult();
                String res3 = data.get("voteCount").toString();
                isaac.setText(res3);


            }
        });

    }
}