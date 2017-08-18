package com.sonika.onlineshoes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sonika.onlineshoes.Pojo.Datamodel;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.attr.order;

/**
 * Created by sonika on 5/23/2017.
 */

public class Description extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button button;
    ArrayList<Datamodel> data = new ArrayList<Datamodel>();
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        final Datamodel datamodel = (Datamodel) getIntent().getSerializableExtra("individual");
        imageView = (ImageView) findViewById(R.id.imgshoes);
        textView = (TextView) findViewById(R.id.txtdesc);
        button = (Button) findViewById(R.id.btnOrder);





        Glide.with(Description.this).load(datamodel.getImage()).into(imageView);
        textView.setText(datamodel.getDescription());
        id=datamodel.getId();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Description.this, OrderShoe.class);
                intent.putExtra("nepal" , id);
                startActivity(intent);
            }
        });


    }
}
