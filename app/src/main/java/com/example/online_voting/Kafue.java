package com.example.online_voting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class Kafue extends AppCompatActivity {

    private ImageView NIP,UIP,TP;
    private Button SUWI,MILY,JANE,JOE,ISCO,GAPPY,RESULTCHECK;
    private long backTime;
    private FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kafue);
        NIP=findViewById(R.id.kafBtnRed);
        UIP=findViewById(R.id.kafgreenBtn);
        TP=findViewById(R.id.kafOraBtn);
        SUWI=findViewById(R.id.suwi);
        MILY=findViewById(R.id.milly);
        JANE=findViewById(R.id.jane);
        JOE=findViewById(R.id.joe);
        ISCO=findViewById(R.id.isco);
        GAPPY=findViewById(R.id.gappy);
        RESULTCHECK=findViewById(R.id.checkCandyKaf);
        fStore = FirebaseFirestore.getInstance();

        //blablabla

        NIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Terence M...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        NIP.setVisibility(View.INVISIBLE);
                        UIP.setVisibility(View.INVISIBLE);
                        TP.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("presidential").collection("parties")
                                .document("NIP").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });

        UIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Mupela N...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        NIP.setVisibility(View.INVISIBLE);
                        UIP.setVisibility(View.INVISIBLE);
                        TP.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("presidential").collection("parties")
                                .document("UIP").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });

        TP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Kangwa M...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        NIP.setVisibility(View.INVISIBLE);
                        UIP.setVisibility(View.INVISIBLE);
                        TP.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("presidential").collection("parties")
                                .document("TP").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });



//Members of parliarment

        SUWI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Suwi N ...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SUWI.setVisibility(View.INVISIBLE);
                        MILY.setVisibility(View.INVISIBLE);
                        JANE.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("MPs").collection("members")
                                .document("Suwi").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });



        MILY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Milly B...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SUWI.setVisibility(View.INVISIBLE);
                        MILY.setVisibility(View.INVISIBLE);
                        JANE.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("MPs").collection("members")
                                .document("milly").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });
        JANE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Jane P...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SUWI.setVisibility(View.INVISIBLE);
                        MILY.setVisibility(View.INVISIBLE);
                        JANE.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("MPs").collection("members")
                                .document("jane").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });


        //councilors

        JOE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Joe k...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        JOE.setVisibility(View.INVISIBLE);
                        ISCO.setVisibility(View.INVISIBLE);
                        GAPPY.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("councilor").collection("candidates")
                                .document("joe").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });

        ISCO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Isco M...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        JOE.setVisibility(View.INVISIBLE);
                        ISCO.setVisibility(View.INVISIBLE);
                        GAPPY.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("councilor").collection("candidates")
                                .document("isco").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });

        GAPPY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Kafue.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Gappy M...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        JOE.setVisibility(View.INVISIBLE);
                        ISCO.setVisibility(View.INVISIBLE);
                        GAPPY.setVisibility(View.INVISIBLE);

                        fStore.collection("kafueConstituency").document("councilor").collection("candidates")
                                .document("gappy").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Kafue.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Kafue.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });


        RESULTCHECK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Kafue.this,Candidate.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public void onBackPressed() {

        if(backTime + 2000 > System.currentTimeMillis()){
            finishAffinity();

            return;
        }else{
            Toast.makeText(getBaseContext(),"press back again to exit",Toast.LENGTH_SHORT).show();
        }
        backTime=System.currentTimeMillis();
    }
}