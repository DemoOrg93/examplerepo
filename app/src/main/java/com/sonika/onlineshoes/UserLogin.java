package com.sonika.onlineshoes;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.onlineshoes.Adapter.CustomizedAdapter;
import com.sonika.onlineshoes.Helper.DBHelper;
import com.sonika.onlineshoes.Pojo.Datamodel;
import com.sonika.onlineshoes.Pojo.UserInfo;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sonika.onlineshoes.R.id.email;

public class UserLogin extends AppCompatActivity {
    Button login;
    TextView register;
    EditText  name , password;
    TextInputLayout textInputLayout_name, textInputLayout_password;
    DBHelper db;
    String login_name,login_password, username;
    SharedPreferences sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        db= new DBHelper(this);



        login = (Button) findViewById(R.id.btnLogin);
        register = (TextView) findViewById(R.id.btnRegister);
        name = (EditText) findViewById(R.id.name);

        password = (EditText) findViewById(R.id.password);
        textInputLayout_name = (TextInputLayout) findViewById(R.id.input_layout_name);
        textInputLayout_password = (TextInputLayout) findViewById(R.id.input_layout_password);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_name = name.getText().toString();
                login_password = password.getText().toString();


                if(db.isValidUser(login_name,login_password)){
                 Intent intent=new Intent(UserLogin.this,UserPanel.class);
                 startActivity(intent);



             }else{
                 Toast.makeText(UserLogin.this, "Invalid Credentials"+login_name+login_password, Toast.LENGTH_SHORT).show();
             }

                Intent intent = new Intent(UserLogin.this, UserPanel.class);
                intent.putExtra("user",login_name);
                startActivity(intent);

                sm = getSharedPreferences("USER_LOGIN", 0);
                SharedPreferences.Editor editor = sm.edit();
                editor.putString("name",login_name);
                editor.putString("password", login_password);
                editor.commit();
            }


        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
