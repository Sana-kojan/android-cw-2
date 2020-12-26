package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bu = getIntent().getExtras();
        final String n = bu.getString("name");
        final String a = bu.getString("age");
        final String p = bu.getString("phone");
        final String e = bu.getString("email");
        final String add = bu.getString("adds");
        TextView nn = findViewById(R.id.namev);
        TextView aa = findViewById(R.id.agev);
        TextView pp = findViewById(R.id.phonev);
        TextView ee = findViewById(R.id.emailv);
        TextView ad = findViewById(R.id.addressv);
        nn.setText("Name: "+n);
        aa.setText("Age: "+a);
        ee.setText("E-mail: "+e);
        pp.setText("Phone: "+p);
        ad.setText("Location: "+add);
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+Long.parseLong(p)));
                startActivity(call);
            }
        });

        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,e);
                mail.setType("text/plain");
                startActivity(Intent.createChooser(mail,"Send email"));
            }
        });

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll="+add);
                Intent map = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                map.setPackage("com.google.android.apps.maps");
                startActivity(map);

            }
        });

        Button b = findViewById(R.id.backPage);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}