package com.example.test.randomember;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.Interfaces.AllInfoRandonneur;
import com.example.test.R;
import com.example.test.models.RandonneurModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class randomember_info_randonneur extends AppCompatActivity {
    TextView nomRando;
    TextView textViewResult;
    String norandonneur="";
    //private RandonneeAdapter radonneAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        // System.out.println(norandonnee);
        norandonneur= intent.getStringExtra("idrandonneur");
        System.out.println(norandonneur);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomember_info_randonneur);

        textViewResult=findViewById(R.id.text_view_result);
        nomRando = findViewById(R.id.nomRando);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://globecen.freeboxos.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllInfoRandonneur requestInteface=retrofit.create(AllInfoRandonneur.class);
        Call<List<RandonneurModel>> call=requestInteface.getMyAllInfoRandonneur(norandonneur);
        System.out.println(call);
        call.enqueue(new Callback<List<RandonneurModel>>() {

            @Override
            public void onResponse(Call<List<RandonneurModel>> call, Response<List<RandonneurModel>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;

                }
                List<RandonneurModel> Infos = response.body();
                for (RandonneurModel post : Infos) {
                    String content = "";
                    content += "Votre nom : " + post.getNom_randonneur() + "\n";
                    content += "Votre prenom : " + post.getPrenom_randonneur() + "\n";
                    content += "Votre mot de passe : " + post.getAdresse_randonneur() + "\n";
                    content += "Votre email : " + post.getEmail_randonneur() + "\n";
                    content += "Votre mot de passe : " + post.getMotdepass_randonneur() + "\n\n";

                    textViewResult.setText(content);
                }
            }

            @Override
            public void onFailure(Call<List<RandonneurModel>> call, Throwable t) {
                Toast.makeText(randomember_info_randonneur.this,"Failed",Toast.LENGTH_SHORT).show();
                Log.e("erreur",t.getMessage());
            }
        });
    }
    public void onResume(){
        super.onResume();

    }
}
