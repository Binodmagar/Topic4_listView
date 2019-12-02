package com.binod.topic4_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView tvCountries;
    TextView tvResult;

    public static final String countries[] = {
            "Nepal", "Kathmandu" ,
            "India" , "New Delhi",
            "UK" , "London",
            "Canada" , "Ottawa"
    };
    //hash map
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding
        tvCountries = findViewById(R.id.tvCountries);

        //storing value of array in key and value
        dictionary = new HashMap<>();
        for(int i = 0; i<countries.length; i+=2){
            dictionary.put(countries[i],countries[i+1]);
        }

        ArrayAdapter countryAdapter = new ArrayAdapter<>(
                this,//activity
                android.R.layout.simple_list_item_1,//layout
                new ArrayList<String>(dictionary.keySet())// arraylist key value and
        );
        tvCountries.setAdapter(countryAdapter);

        tvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = dictionary.get(country);
                //Toast.makeText(getApplicationContext(),capital.toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, capitalActivity.class);
                intent.putExtra("mesage", capital);
                startActivity(intent);

            }
        });
    }
}
