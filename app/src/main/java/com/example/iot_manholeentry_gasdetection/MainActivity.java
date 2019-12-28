package com.example.iot_manholeentry_gasdetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {


    private CardView v1,v2,v4,v3,v5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1=findViewById(R.id.gas_monitoring);
        v2=findViewById(R.id.concentration_variation);
        v4=findViewById(R.id.calender1);
        v3=findViewById(R.id.settings);
        v5=findViewById(R.id.info);


            v1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkConnection()==1){
                    Intent intent1 = new Intent(MainActivity.this,gas_concentration.class);
                    startActivity(intent1);}
                    else {
                        Toast.makeText(getApplicationContext(),"Internet Connection Lost.Check Your Internet and Please Try again",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

            v2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkConnection()==1){
                    Intent intent2 = new Intent(MainActivity.this,variation_concentration.class);
                    startActivity(intent2);}
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Internet Connection Lost.Check Your Internet and Please Try again",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
            v4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent4 =new Intent(MainActivity.this,Calendar_layout.class);
                    startActivity(intent4);
                }
            });
            v3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent3 = new Intent(MainActivity.this,language.class);
                    startActivity(intent3);
                }
            });

            v5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent5 = new Intent(MainActivity.this,information_gas.class);
                    startActivity(intent5);
                }
            });


    }
    public int checkConnection(){
        ConnectivityManager manager = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();

        if(null!=activenetwork){
            if(activenetwork.getType()== ConnectivityManager.TYPE_WIFI){
                return 1;
            }
            else if(activenetwork.getType()==ConnectivityManager.TYPE_MOBILE){
                return 1;
            }
            else
            {
                return 0;
            }
        }
        return 0;
    }
}
