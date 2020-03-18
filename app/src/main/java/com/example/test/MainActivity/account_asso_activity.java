package com.example.test.MainActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.MainActivity.account_assomenber_activity;
import com.example.test.R;

public class account_asso_activity extends AppCompatActivity {

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_asso_activity);
    }

    public void Valider (View view) {
        startActivity(new Intent(this, account_assomenber_activity.class));
    }
    public void onResume(){
        super.onResume();

    }
}
