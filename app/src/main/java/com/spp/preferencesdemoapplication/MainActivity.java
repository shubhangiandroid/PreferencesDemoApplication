package com.spp.preferencesdemoapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv=(TextView)findViewById(R.id.textview);

         pref=getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
         String UName=pref.getString("uname","No name defined");
         String Password=pref.getString("pass","No name defined");

         tv.setText(UName+"  "+Password);
    }


    public void LogOutclick(View view) {

        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
        finish();

        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
