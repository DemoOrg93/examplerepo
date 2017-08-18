package com.sonika.onlineshoes;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.onlineshoes.Helper.DBHelperOrder;
import com.sonika.onlineshoes.Pojo.Datamodel;
import com.sonika.onlineshoes.Pojo.OrderInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.layout.simple_spinner_dropdown_item;
import static com.sonika.onlineshoes.R.id.password;
import static com.sonika.onlineshoes.R.id.spinner_day;

/**
 * Created by sonika on 5/23/2017.
 */
public class OrderShoe extends AppCompatActivity {
    DBHelperOrder dbo;
    String  oname, oemail, ocolor, osize, odeliveryDate, oaddress, ocontact;
    EditText editText_name, editText_email, edittext_address, edittext_contact;
    Button btnOrder;
    String sDay,sMonth;
    Spinner dayspinner, monthspinner;


    RadioButton rbcolor_radio, rbsize_radio;
    RadioGroup rgcolor, rgsize;

    String month[] = {"Jan", "Feb","Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String day[] = {"1","2", "3","4", "5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};

    String shoeid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_shoe);
        dbo = new DBHelperOrder(OrderShoe.this);


        shoeid  = getIntent().getStringExtra("nepal");


        edittext_address = (EditText) findViewById(R.id.address);
        editText_name = (EditText) findViewById(R.id.name);
        editText_email = (EditText) findViewById(R.id.email);
        edittext_contact = (EditText) findViewById(R.id.contact);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        rgcolor = (RadioGroup) findViewById(R.id.groupcolor);
        rgsize = (RadioGroup) findViewById(R.id.groupsize);


        dayspinner = (Spinner) findViewById(spinner_day);
        monthspinner = (Spinner) findViewById(R.id.spinner_month);


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = rgcolor.getCheckedRadioButtonId();
                int selectedIdOne = rgsize.getCheckedRadioButtonId();




                // find the radiobutton by returned id
                rbcolor_radio = (RadioButton) findViewById(selectedId);
                rbsize_radio = (RadioButton) findViewById(selectedIdOne);


                sDay=(String)dayspinner.getSelectedItem();
                sMonth=(String)monthspinner.getSelectedItem();
                Toast.makeText(OrderShoe.this, sMonth+" "+sDay, Toast.LENGTH_SHORT).show();


                oname = editText_name.getText().toString();
                oaddress = edittext_address.getText().toString();
                oemail = editText_email.getText().toString();
                ocolor = rbcolor_radio.getText().toString();
                osize = rbsize_radio.getText().toString();
                ocontact = edittext_contact.getText().toString();
                odeliveryDate =sMonth + " " + sDay;

                if (!isValidEmail(oemail)) {
                    editText_email.setError("Invalid Email");
                }
                else if (!isValidContact(ocontact)) {
                    edittext_contact.setError("Enter valid phone number");
                }
                else if (!isValidName(oname)) {
                    editText_name.setError("Enter your name");
                    edittext_address.setError("Enter address");
                }
                else {
                    oname = editText_name.getText().toString();
                    ocontact = edittext_contact.getText().toString();
                    oemail = editText_email.getText().toString();
                    oaddress = edittext_address.getText().toString();



                    ContentValues cv = new ContentValues();
                    cv.put("shoe_id", shoeid);
                    cv.put("name", oname);
                    cv.put("address", oaddress);
                    cv.put("email", oemail);
                    cv.put("color", ocolor);
                    cv.put("size", osize);
                    cv.put("delivery_date", odeliveryDate);
                    dbo.insertOrderInfo(cv);

                    Toast.makeText(OrderShoe.this, "order confirmed", Toast.LENGTH_SHORT).show();
                }
            }
        });



        ArrayList info = dbo.getOrderMessage();
        ArrayAdapter cc = new ArrayAdapter(this, android.R.layout.simple_spinner_item, day);
        cc.setDropDownViewResource(simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        dayspinner.setAdapter(cc);


        ArrayAdapter dd = new ArrayAdapter(this, android.R.layout.simple_spinner_item, month);
        dd.setDropDownViewResource(simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        monthspinner.setAdapter(dd);

    }


    private boolean isValidEmail(String oemail) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(oemail);
        return matcher.matches();

    }
    private boolean isValidContact(String ocontact) {
        if (ocontact != null && ocontact.length() == 10){
            return true;
        }
        return false;
    }
    private boolean isValidName(String oname) {
        if (oname != null  && oname.length() <= 50){
            return true;
        }
        return false;
    }

}

