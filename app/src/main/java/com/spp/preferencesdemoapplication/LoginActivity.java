package com.spp.preferencesdemoapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    String username, password;
    EditText edtUname, edtPass;
    Button btnLogin;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUname = (EditText) findViewById(R.id.editText);
        edtPass = (EditText) findViewById(R.id.editText2);
        btnLogin = (Button) findViewById(R.id.button);
        pref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);

        if (pref.contains("uname")) {

            String UName = pref.getString("uname","No name defined");//"No name defined" is the default value.
            String Password = pref.getString("Pass","No name defined");


            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();


        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username=edtUname.getText().toString();
                password=edtPass.getText().toString();

                SharedPreferences.Editor editor = pref.edit();
                editor.putString("uname", username);
                editor.putString("pass", password);
                editor.apply();


                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();


            }
        });
    }
}
