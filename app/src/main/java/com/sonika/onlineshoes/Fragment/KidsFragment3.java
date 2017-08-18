package com.sonika.onlineshoes.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.sonika.onlineshoes.Adapter.FragmentAdapter;
import com.sonika.onlineshoes.Description;
import com.sonika.onlineshoes.Pojo.Datamodel;
import com.sonika.onlineshoes.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class KidsFragment3 extends Fragment {

    ListView mlist;
    Datamodel datamodel;
    int ctr;
    ImageView mImage;
    ArrayList<Datamodel> data = new ArrayList<Datamodel>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.kids_fragment_3, container, false);
        perform(v);
        return v;

    }

    public void perform(View v) {
        mlist = (ListView) v.findViewById(R.id.list_kids);


        InputStream inputStream = getResources().openRawResource(R.raw.kids);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(
                    byteArrayOutputStream.toString());
            JSONObject jObjectResult = jObject.getJSONObject("Datas");
            JSONArray jArray = jObjectResult.getJSONArray("Kids");
            for (int i = 0; i < jArray.length(); i++) {

                JSONObject prodObj = jArray.getJSONObject(i);
                String id = prodObj.getString("id");
                String quality = prodObj.getString("Quality");
                String price = prodObj.getString("Price");
                String image = prodObj.getString("Image");
                String description = prodObj.getString("Description");


                datamodel=new Datamodel(id,price,image, description);
                data.add(datamodel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentAdapter fragmentAdapter= new FragmentAdapter(getActivity(),R.layout.fragment_adapter,data);
        mlist.setAdapter(fragmentAdapter);

        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datamodel three = data.get(position);
                Intent i = new Intent(getActivity(), Description.class);
                i.putExtra("individual", three);
                startActivity(i);
            }
        });

    }

}







