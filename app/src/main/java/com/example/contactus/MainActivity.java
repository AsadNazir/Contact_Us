package com.example.contactus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button whatsapp1= findViewById(R.id.button4);
        Button whatsapp2= findViewById(R.id.button6);
        Button dialer= findViewById(R.id.button7);
        Button web= findViewById(R.id.button8);
        Button send= findViewById(R.id.button);


        TextView title= findViewById(R.id.textView);
        TextView msg= findViewById(R.id.textView2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (msg.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please write your Subject", Toast.LENGTH_SHORT).show();
                    return;
                } else if (title.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please write your Message", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tariqsbadar@gmail.com", "bsef20m522@pucit.edu.pk"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, msg.getText().toString());
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = "tel:" + "+92 3153137276";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(phoneNumber));
                startActivity(dialIntent);
            }
        });

        whatsapp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone=+92 3153137276";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        whatsapp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone=+92 3153137276";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/haqnawaz99/20230427/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}