package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText n = findViewById(R.id.name);
        final EditText a = findViewById(R.id.age);
        final EditText p = findViewById(R.id.Phone);
        final EditText e = findViewById(R.id.Email);
        final EditText ad = findViewById(R.id.Address);
        final Button re = findViewById(R.id.reset);

        Button b = findViewById(R.id.nextPage);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n.getText().toString().matches("") || a.getText().toString().matches("") || p.getText().toString().matches("") || e.getText().toString().matches("") || e.getText().toString().matches(""))
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
                else if(trueAdd(ad))
                    Toast.makeText(MainActivity.this, "The Address value is invalid", Toast.LENGTH_LONG).show();
                else{ Intent i = new Intent(MainActivity.this,MainActivity2.class);
                String name = n.getText().toString();
                String age = a.getText().toString();
                String phone = p.getText().toString();
                String email = e.getText().toString();
                String add= ad.getText().toString();
                i.putExtra("name", name);
                i.putExtra("age",age);
                i.putExtra("phone", phone);
                i.putExtra("email", email);
                i.putExtra("adds", add);

                startActivity(i);}

            }
        });

                re.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        n.setText("");
                        a.setText("");
                        p.setText("");
                        e.setText("");
                        ad.setText("");

                    }
                });}

                public boolean trueAdd(EditText add){
                     int count ;
                     int ch=0;
                     boolean flag= false;
                     String s = add.getText().toString();

                  for( count = 0; count<add.length(); count++){
                      if (!Character.isDigit(s.charAt(count)) && s.charAt(count) != '-' && s.charAt(count) != '.') {
                          flag = true;
                          break;
                      }}
                  return flag;
                }


}