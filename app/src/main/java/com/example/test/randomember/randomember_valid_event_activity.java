package com.example.test.randomember;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.Interfaces.OneRandoRequeteInterface;
import com.example.test.R;
import com.example.test.models.RandonnneEtAssoModele;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class randomember_valid_event_activity extends AppCompatActivity {
    TextView nomRando;
    TextView textViewResult;
    String norandonnee = "";
    String idrandonneur = "";

    //private RandonneeAdapter radonneAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        norandonnee = intent.getStringExtra("norandonnee");
        // System.out.println(norandonnee);
        idrandonneur = intent.getStringExtra("idrandonneur");
        //System.out.println(idrandonneur);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomember_valid_event_activity);

        textViewResult = findViewById(R.id.text_view_result2);
        nomRando = findViewById(R.id.nomRando);
        nomRando.setText("Radonnee n° : " + norandonnee);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://globecen.freeboxos.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OneRandoRequeteInterface requestInteface = retrofit.create(OneRandoRequeteInterface.class);
        Call<List<RandonnneEtAssoModele>> call = requestInteface.getOneRandonnee(norandonnee);
        System.out.println(call);
        call.enqueue(new Callback<List<RandonnneEtAssoModele>>() {

            @Override
            public void onResponse(Call<List<RandonnneEtAssoModele>> call, Response<List<RandonnneEtAssoModele>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;

                }
                List<RandonnneEtAssoModele> Infos = response.body();
                for (RandonnneEtAssoModele post : Infos) {
                    String content = "";
                    content += "Lieu de la Randonnee : " + post.getLieu() + "\n";
                    content += "Date de la Randonnee : " + post.getDate() + "\n";
                    content += "Date limite de réponse : " + post.getDateMaxRep() + "\n";
                    content += "Association : " + post.getNom_asso() + "\n";
                    content += "Numéro de l'association : " + post.getTelephone_asso() + "\n\n";

                    textViewResult.setText(content);
                }
            }

            @Override
            public void onFailure(Call<List<RandonnneEtAssoModele>> call, Throwable t) {
                Toast.makeText(randomember_valid_event_activity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.e("erreur", t.getMessage());
            }
        });
    }

    public void onResume() {
        super.onResume();

    }
}