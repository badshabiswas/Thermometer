 package com.example.thermocu;


 import android.content.Context;
 import android.content.Intent;
 import android.hardware.Sensor;
 import android.hardware.SensorEvent;
 import android.hardware.SensorEventListener;
 import android.hardware.SensorManager;
 import android.os.Bundle;
 import java.util.Random;
// import android.support.v7.app.AppCompatActivity;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.widget.TextView;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import java.util.Timer;
 import java.util.TimerTask;

 public class MainActivity extends AppCompatActivity {





     private Thermometer thermometer;
     private float temperature;
     private Timer timer;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         thermometer = (Thermometer) findViewById(R.id.thermometer);



     }

     @Override
     protected void onResume() {
         super.onResume();
         simulateAmbientTemperature();
     }

     @Override
     protected void onPause() {
         super.onPause();
         unregisterAll();
     }

     private void simulateAmbientTemperature() {
         timer = new Timer();
         Random ran= new Random();

         timer.scheduleAtFixedRate(new TimerTask() {

             @Override
             public void run() {
                 temperature = 28+ran.nextInt( 45-28);
                 TextView textView= findViewById(R.id.textsick);
                 runOnUiThread(new Runnable() {

                     @Override
                     public void run() {
                         thermometer.setCurrentTemp(temperature);
                         getSupportActionBar().setTitle(getString(R.string.app_name) + " : " + temperature+" C");



                         if (temperature<35){

                             textView.append("You are suffering from Hypothermia.\n");



                         }
                         else if (temperature>39){
                             textView.append("You are suffering from Hyperthermia. \n");


                         }
                         else if(temperature>=37 & temperature<=39){
                             textView.append("You are suffering from fever. \n");
                         }
                         else{
                             textView.append("You are perfect.\n");

                         }

                     }


                 });


             }
         }, 0, 25000);





     }

     private void unregisterAll() {
         timer.cancel();
     }


     @Override
     public boolean onCreateOptionsMenu(Menu menu) {

         MenuInflater inflater= getMenuInflater();
         inflater.inflate(R.menu.tmenu,menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         int id=item.getItemId();
         if(id==R.id.sensor)
         {
             Toast.makeText(this,"Please Connect your Sensor",Toast.LENGTH_LONG).show();
         }

         if(id==R.id.profile){
             startActivity(new Intent(MainActivity.this,profile.class));
         }
         else if(id==R.id.smartdoc){
             startActivity(new Intent(MainActivity.this,smartdoctor.class));
         }

         else if(id==R.id.savedprofile){
             startActivity(new Intent(MainActivity.this,savedprofile.class));
         }
         else if(id==R.id.share){
             Intent shareIntent = new Intent(Intent.ACTION_SEND);
             shareIntent.setType("text/plain");
             shareIntent.putExtra(Intent.EXTRA_TEXT, "https://drive.google.com/drive/folders/1ZXaMkASy-UbAGKuzqHRYwQYiW7s9DMHI?usp=sharing");
             startActivity(Intent.createChooser(shareIntent, "Share with..."));
         }
         else if(id==R.id.help){
             startActivity(new Intent(MainActivity.this,help.class));
         }


         return super.onOptionsItemSelected(item);
     }
 }