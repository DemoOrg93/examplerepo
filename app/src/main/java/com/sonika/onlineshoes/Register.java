package com.sonika.onlineshoes;

import android.content.ContentValues;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonika.onlineshoes.Helper.DBHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText name, password , confirm_password, contact, email;
    Button ok;
    String sname, spassword, scontact, semail;
    DBHelper dbHelper;
    TextInputLayout inputLayout_regname, inputLayout_regpassword, inputLayout_confirm, inputLayout_regemail,inputLayout_regcontact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper=new DBHelper(this);


        name = (EditText) findViewById(R.id.rname);
        password = (EditText) findViewById(R.id.rpassword);
        confirm_password = (EditText) findViewById(R.id.confirmpassword);
        contact = (EditText) findViewById(R.id.rcontact);
        email = (EditText) findViewById(R.id.remail);
        ok = (Button) findViewById(R.id.btnok);
        inputLayout_regname = (TextInputLayout) findViewById(R.id.input_layout_regname);
        inputLayout_regpassword = (TextInputLayout) findViewById(R.id.input_layout_regpassword);
        inputLayout_regcontact = (TextInputLayout) findViewById(R.id.input_layout_regcontact);
        inputLayout_regemail = (TextInputLayout) findViewById(R.id.input_layout_regemailid);
        inputLayout_confirm = (TextInputLayout) findViewById(R.id.input_layout_regconfirmpassword);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String femail = email.getText().toString();
                String fcontact = contact.getText().toString();
                String fpassword = password.getText().toString();
                String fconfirm = confirm_password.getText().toString();
                String fname = name.getText().toString();




                    if (!isValidEmail(femail)) {
                        email.setError("Enter valid email address");
                    }

                    else if (!isValidPassword(fpassword)) {
                        password.setError("Password should be at least of 6 charecters");
                    }
                    else if (!passwordMatch(fconfirm, fpassword)) {
                        confirm_password.setError("password dont match");
                    }


                   else if (!isValidContact(fcontact)) {
                        contact.setError("Enter valid phone number");
                    }


                   else if (!isValidName(fname)) {
                        name.setError("Enter your name");
                    }



                else {
                    sname = name.getText().toString();
                    spassword = password.getText().toString();
                    scontact = contact.getText().toString();
                    semail = email.getText().toString();


                    ContentValues cv = new ContentValues();
                    cv.put("name", sname);
                    cv.put("password", spassword);
                    cv.put("contact", scontact);
                    cv.put("email", semail);


                    dbHelper.insertInfo(cv);


                    Toast.makeText(Register.this, "Successfully registered!!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Register.this, UserLogin.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValidName(String fname) {
        if (fname != null  && fname.length() <= 50){
            return true;
        }
        return false;
        }

    private boolean isValidContact(String fcontact) {
        if (fcontact != null && fcontact.length() == 10){
        return true;
        }
        return false;
    }

    private boolean isValidPassword(String fpassword) {
        if (fpassword != null && fpassword.length() > 6) {
            return true;
        }
        return false;
    }

    private boolean passwordMatch(String fconfirm, String fpassword) {
        if (fconfirm.equals(fpassword)){
            return true;
        }
        return false;
    }




    private boolean isValidEmail(String femail) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(femail);
        return matcher.matches();

    }


}
