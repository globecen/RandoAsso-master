package com.example.test.randomember;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.test.Interfaces.OneRandoRequeteInterface;
import com.example.test.Interfaces.RandonneeInterface;
import com.example.test.R;
import com.example.test.adapters.RandonneeAdapter;
import com.example.test.models.RandonneeeModel;
import com.example.test.models.RandonnneEtAssoModele;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class randomember_read_active_event_activity extends AppCompatActivity {
    String norandonnee="";
    String idrandonneur="";
    ArrayList<RandonnneEtAssoModele> randonneeModels=new ArrayList<>();
    private RandonneeAdapter radonneAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
// On suppose que tu as mis un String dans l'Intent via le putExtra()
        norandonnee= intent.getStringExtra("norandonnee");
        idrandonneur= intent.getStringExtra("idrandonneur");
        //System.out.println(norandonnee);
        System.out.println(idrandonneur);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomember_read_active_event_activity);
        getRandoneeeResponse();
    }

        private void getRandoneeeResponse() {
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://globecen.freeboxos.fr")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            OneRandoRequeteInterface requestInteface=retrofit.create(OneRandoRequeteInterface.class);
            Call<List<RandonnneEtAssoModele>> call=requestInteface.getOneRandonnee(norandonnee);
            call.enqueue(new Callback<List<RandonnneEtAssoModele>>() {
                @Override

                public void onResponse(Call<List<RandonnneEtAssoModele>> call, Response<List<RandonnneEtAssoModele>> response) {
                  //System.out.println();
                    randonneeModels = new ArrayList<>(response.body());
                  //System.out.println(randonneeModels.get(0).getLieu());

                }

                @Override
                public void onFailure(Call<List<RandonnneEtAssoModele>> call, Throwable t) {
                    Toast.makeText(randomember_read_active_event_activity.this,"Failed",Toast.LENGTH_SHORT).show();
                    Log.e("erreur",t.getMessage());
                }
            });
        }
    public void onResume(){
        super.onResume();

    }
    }

