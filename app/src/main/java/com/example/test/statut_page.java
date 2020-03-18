package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.MainActivity.MainActivity;
import com.example.test.MainActivity.account_assomenber_activity;
import com.example.test.MainActivity.account_asso_activity;
import com.example.test.MainActivity.account_handicaper_activity;
public class statut_page extends AppCompatActivity {

    private Object account_asso_activity;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statut_page);

        final Button button1 = findViewById(R.id.membreButton);
        final Button button = findViewById(R.id.assosButton);
        final Button button2 = findViewById(R.id.handicaperButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(statut_page.this, account_asso_activity.class));
            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(statut_page.this, account_assomenber_activity.class));
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(statut_page.this, account_handicaper_activity.class));
            }

        });
    }


    public void onResume(){
        super.onResume();

    }
}
