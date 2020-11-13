package com.example.thermocu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        EditText name = (EditText) findViewById(R.id.name);
        EditText age = (EditText) findViewById(R.id.age);
        EditText temperature = (EditText) findViewById(R.id.temperature);


       Button submit=(Button) findViewById(R.id.submitprofile);
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

              if (name.length()==0){
                  name.setError(" Name shouldn't be empty");
              }
              else if(age.length()==0){
                  age.setError("Age shouldn't be empty");
              }
              else if(temperature.length()==0){
                  age.setError("Temperature shouldn't be empty");
              }
              else{
                  Toast.makeText(profile.this,"Welcome! We stored your information, Thanks", Toast.LENGTH_LONG).show();
              }
           }
       });


    }



    }