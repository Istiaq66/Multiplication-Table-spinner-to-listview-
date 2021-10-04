package com.istiaq66.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    int[] numbers={1,2,3,4,5,6,7,8,9,10};
    ListView lstview;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.spiner);
        lstview = findViewById(R.id.listview);

        list = new ArrayList<>();

        //-----spinner code----//
        ArrayList<Integer> a10 = new ArrayList<Integer>();
        for (int i:numbers)
        {

            a10.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,a10);

        spin.setAdapter(adapter);


        //-----spinner click code-----//
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int no = Integer.parseInt(parent.getItemAtPosition(position).toString());
                list.clear();
                printtable(no);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }


    // function of printing table//
    public void printtable(int number){
        for(int i=1;i<=10;i++) {
            String result = number + "     X      " + i + "     =      " + number * i;
            list.add(result);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
            lstview.setAdapter(arrayAdapter);
        }

    }
}