package com.sonika.onlineshoes;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    Button login;
    EditText  name , password;
    TextInputLayout textInputLayout_name, textInputLayout_password;
    String admin_name, admin_password;
    CheckBox cb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        //DBHelper dbHelper=new DBHelper(this);

        login = (Button) findViewById(R.id.btnLogin);

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        textInputLayout_name = (TextInputLayout) findViewById(R.id.input_layout_name);
        textInputLayout_password = (TextInputLayout) findViewById(R.id.input_layout_password);
        cb = (CheckBox) findViewById(R.id.checkboxshowpwd);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (!isChecked) {
                    password
                            .setTransformationMethod(PasswordTransformationMethod
                                    .getInstance());
                } else
                    password.setTransformationMethod(HideReturnsTransformationMethod
                                    .getInstance());

            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                admin_name = name.getText().toString();
                admin_password = password.getText().toString();

                if (admin_name.equals("admin")  && admin_password.equals("admin" ) )
                {
                Intent intent=new Intent(AdminLogin.this, Admin.class);
                startActivity(intent);
                }
                else {
                    Toast.makeText(AdminLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }

        };
        })
    ;}}

