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

public class Lusaka extends AppCompatActivity {
private ImageView nip,uip,tp;
private Button paul,frank,james,miam,philip,isaac,ViewResults;
private FirebaseFirestore fStore;
private long backTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lusaka);

        nip=findViewById(R.id.lusBtnRed);
        uip=findViewById(R.id.lusGreenBtn);
        tp=findViewById(R.id.lusOraBtn);
        paul=findViewById(R.id.paul);
        frank=findViewById(R.id.frank);
        james=findViewById(R.id.james);
        miam=findViewById(R.id.maim);
        philip=findViewById(R.id.philip);
        isaac=findViewById(R.id.isaac);
        fStore=FirebaseFirestore.getInstance();
        ViewResults=findViewById(R.id.checkCandyLus);


        nip.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                                       builder.setTitle("Confirm Your Party");
                                       builder.setMessage("Do you want to give your vote to Terence M...?");
                                       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialog, int which) {

                                               nip.setVisibility(View.INVISIBLE);
                                               uip.setVisibility(View.INVISIBLE);
                                               tp.setVisibility(View.INVISIBLE);

                                               fStore.collection("LusakaConstituency").document("presidential").collection("parties")
                                                       .document("NIP").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                   @Override
                                                   public void onComplete(@NonNull Task<Void> task) {
                                                       if (task.isSuccessful()) {
                                                           Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                                       } else {
                                                           Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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

        uip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Mupela N...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        nip.setVisibility(View.INVISIBLE);
                        uip.setVisibility(View.INVISIBLE);
                        tp.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("presidential").collection("parties")
                                .document("UIP").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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

        tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Kangwa M...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        nip.setVisibility(View.INVISIBLE);
                        uip.setVisibility(View.INVISIBLE);
                        tp.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("presidential").collection("parties")
                                .document("TP").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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

//        tp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fStore.collection("LusakaConstituency").document("presidential").collection("parties")
//                        .document("TP").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//                nip.setVisibility(View.INVISIBLE);
//                uip.setVisibility(View.INVISIBLE);
//                tp.setVisibility(View.INVISIBLE);
//            }
//        });



//Members of parliarment

        paul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Paul K...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        paul.setVisibility(View.INVISIBLE);
                        frank.setVisibility(View.INVISIBLE);
                        james.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("MPs").collection("members")
                                .document("paul").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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



        frank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Frank B...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        paul.setVisibility(View.INVISIBLE);
                        frank.setVisibility(View.INVISIBLE);
                        james.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("MPs").collection("members")
                                .document("Frank").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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
        james.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to James P...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        paul.setVisibility(View.INVISIBLE);
                        frank.setVisibility(View.INVISIBLE);
                        james.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("MPs").collection("members")
                                .document("james").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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

//        james.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fStore.collection("LusakaConstituency").document("MPs").collection("members")
//                        .document("james").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(Lusaka.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//                paul.setVisibility(View.INVISIBLE);
//                frank.setVisibility(View.INVISIBLE);
//                james.setVisibility(View.INVISIBLE);
//            }
//        });

        //councilors

        miam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Miam k...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        miam.setVisibility(View.INVISIBLE);
                        philip.setVisibility(View.INVISIBLE);
                        isaac.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("Councilor").collection("candidates")
                                .document("miam").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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

        philip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Philip M...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        miam.setVisibility(View.INVISIBLE);
                        philip.setVisibility(View.INVISIBLE);
                        isaac.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("Councilor").collection("candidates")
                                .document("philip").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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

        isaac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Lusaka.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to Isaac M...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        miam.setVisibility(View.INVISIBLE);
                        philip.setVisibility(View.INVISIBLE);
                        isaac.setVisibility(View.INVISIBLE);

                        fStore.collection("LusakaConstituency").document("Councilor").collection("candidates")
                                .document("isaac").update("voteCount", FieldValue.increment(1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Lusaka.this, "voted successful", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Lusaka.this, "failed", Toast.LENGTH_SHORT).show();
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

        ViewResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Lusaka.this,CandidatesLus.class);
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