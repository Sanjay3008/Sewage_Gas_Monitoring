package com.example.iot_manholeentry_gasdetection;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import java.util.List;
import java.util.Locale;

public class language extends AppCompatActivity {

    private CardView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        l1=findViewById(R.id.language_change);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final  String listitems[] = {"English","தமிழ்"};
                AlertDialog.Builder builder = new AlertDialog.Builder(language.this);
                builder.setTitle("Choose Language..");
                builder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            setLocale("en");
                            recreate();
                        }
                        else if(which==1)
                        {
                            setLocale("ta");
                            recreate();
                        }

                        dialog.dismiss();
                    }
                });
                AlertDialog mdialogue = builder.create();
                mdialogue.show();

            }
        });


    }

    private void setLocale(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My lang",lang);
        editor.apply();
        Intent refresh = new Intent(this, MainActivity.class);
        refresh.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(refresh);

    }

    public void loadLocalae()
    {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My lang","");
        setLocale(language);

    }


}
