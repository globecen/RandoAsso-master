package com.example.test.MainActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class account_assomenber_activity  extends AppCompatActivity {
    final String url_Register = "https://globecen.freeboxos.fr/androidConnection/register_user.php";
    EditText etEmail, etPassword,etNom, etPrenom,etAdresse;
    Button btnValid;
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_assomenber_activity);
        etNom = (EditText) findViewById(R.id.etNom);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPrenom=(EditText) findViewById(R.id.etPrenom);
        etAdresse=(EditText)findViewById(R.id.etAdresse);
        etPassword = (EditText) findViewById(R.id.etPass);
        btnValid = (Button) findViewById(R.id.btnValid);
        btnValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = etEmail.getText().toString();
                String Password = etPassword.getText().toString();
                String Nom = etNom.getText().toString();
                String Prenom = etPrenom.getText().toString();
                String Adresse = etAdresse.getText().toString();

                new RegisterUser().execute(Email, Password, Nom, Prenom, Adresse);
            }
        });
    }
    public class RegisterUser extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String Email = strings[0];
            String password = strings[1];
            String Nom = strings[2];
            String Prenom = strings[3];
            String Adresse = strings[4];

            String finalURL = url_Register + "?user_email=" + Email +
                    "&?user_password=" + password+
                    "&?user_nom="+Nom+
                    "&?user_prenom="+Prenom+
                    "&?user_adresse="+Adresse;
System.out.println(finalURL);
            Response response = null;
            System.out.println(Email);
            System.out.println(password);
            System.out.println(Nom);
            System.out.println(Prenom);
            System.out.println(Adresse);
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(finalURL)
                        .get()
                        .build();


                try {
                    response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        String result = response.body().string();
                        if (result.equalsIgnoreCase("Utilisateur enregistrer")) {
                            showToast("Utilisateur enregistrer");
                            Intent i = new Intent(account_assomenber_activity.this,
                                    MainActivity.class);
                            startActivity(i);
                        } else if (result.equalsIgnoreCase("User already exists")) {
                            showToast("Compte deja existant");
                        } else {
                            showToast("errer");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }


    public void showToast(final String Text){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(account_assomenber_activity.this,
                        Text, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onResume(){
        super.onResume();

    }
}
