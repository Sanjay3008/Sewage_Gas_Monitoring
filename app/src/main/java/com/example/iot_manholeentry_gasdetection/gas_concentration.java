package com.example.iot_manholeentry_gasdetection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class gas_concentration extends AppCompatActivity {

    private CircularProgressBar g1,g2,g3,g4,g5;
    private TextView gt1,gt2,gt3,gt4,gt5;
    private FirebaseDatabase db;
    private DatabaseReference ref1,ref2,ref3,ref4,ref5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_concentration);

        g1=findViewById(R.id.ch4_progress);
        g2=findViewById(R.id.co2_progress);
        g3=findViewById(R.id.co_progress);
        g4=findViewById(R.id.h2s_progress);
        g5=findViewById(R.id.ch3_progress);
        gt1=findViewById(R.id.ch4_per);
        gt2=findViewById(R.id.co2_per);
        gt3=findViewById(R.id.co_per);
        gt4=findViewById(R.id.h2s_per);
        gt5=findViewById(R.id.ch3_per);
        g1.setProgressMax(5000);
        g2.setProgressMax(10000);
        g3.setProgressMax(3000);
        g4.setProgressMax(5000);
        g5.setProgressMax(10000);

         db = FirebaseDatabase.getInstance();
         ref1 = db.getReference().child("Concentration").child("Gas").child("CH4");
         ref2 = db.getReference().child("Concentration").child("Gas").child("CO2");
         ref3 = db.getReference().child("Concentration").child("Gas").child("CO");
         ref4 = db.getReference().child("Concentration").child("Gas").child("H2S");
         ref5 = db.getReference().child("Concentration").child("Gas").child("CH3");

         ref1.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 String ch4_con = dataSnapshot.getValue().toString();
                 Integer gas1=Integer.parseInt(ch4_con);
                 g1.setProgress(gas1);
                 gt1.setText(ch4_con+"ppm");
                 if(gas1<=500)
                 {
                     g1.setProgressBarColor(Color.BLUE);
                 }
                 else if(gas1>501 && gas1<=1500)
                 {
                     g1.setProgressBarColor(Color.GREEN);
                 }
                 else
                 {
                     g1.setProgressBarColor(Color.RED);
                 }
                 
             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {
                 Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_SHORT).show();

             }
         });
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String co2_con = dataSnapshot.getValue().toString();
                Integer gas2=Integer.parseInt(co2_con);
                g2.setProgress(gas2);
                gt2.setText(co2_con+"ppm");
                if(gas2<=1000)
                {
                    g2.setProgressBarColor(Color.BLUE);
                }
                else if(gas2>1000 && gas2<=5000)
                {
                    g2.setProgressBarColor(Color.GREEN);
                }
                else
                {
                    g2.setProgressBarColor(Color.RED);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_SHORT).show();

            }
        });
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String co_con = dataSnapshot.getValue().toString();
                Integer gas3=Integer.parseInt(co_con);
                g3.setProgress(gas3);
                gt3.setText(co_con+"ppm");
                if(gas3<=50)
                {
                    g3.setProgressBarColor(Color.BLUE);
                }
                else if(gas3>50 && gas3<=600)
                {
                    g3.setProgressBarColor(Color.GREEN);
                }
                else
                {
                    g3.setProgressBarColor(Color.RED);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_SHORT).show();

            }
        });
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String h2s_con = dataSnapshot.getValue().toString();
                Integer gas4=Integer.parseInt(h2s_con);
                g4.setProgress(gas4);
                gt4.setText(h2s_con+"ppm");
                if(gas4<=100)
                {
                    g4.setProgressBarColor(Color.BLUE);
                }
                else if(gas4>100 && gas4<=500)
                {
                    g4.setProgressBarColor(Color.GREEN);
                }
                else
                {
                    g4.setProgressBarColor(Color.RED);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_SHORT).show();

            }
        });
        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ch3_con = dataSnapshot.getValue().toString();
                Integer gas5=Integer.parseInt(ch3_con);
                g5.setProgress(gas5);
                gt5.setText(ch3_con+"ppm");
                if(gas5<=400)
                {
                    g5.setProgressBarColor(Color.BLUE);
                }
                else if(gas5>400 && gas5<=1500)
                {
                    g5.setProgressBarColor(Color.GREEN);
                }
                else
                {
                    g5.setProgressBarColor(Color.RED);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
