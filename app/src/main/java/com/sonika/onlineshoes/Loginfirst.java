package com.sonika.onlineshoes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Loginfirst extends AppCompatActivity {

    Button user, admin;
    SharedPreferences sm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginfirst);

        user = (Button)findViewById(R.id.user);
        admin = (Button) findViewById(R.id.admin);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm = getSharedPreferences("USER_LOGIN", 0);
                SharedPreferences.Editor editor = sm.edit();
                if(sm.contains("name")&&sm.contains("password")){
                    Intent i = new Intent(Loginfirst.this, UserPanel.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(Loginfirst.this, UserLogin.class);
                    startActivity(i);
                }
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Loginfirst.this, AdminLogin.class);
                startActivity(i);
            }
        });


    }
}
