package com.example.test.randomember;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.Interfaces.AllRandonneeRequeteInterface;
import com.example.test.Interfaces.MyRadonneeRequeteInterface;
import com.example.test.R;
import com.example.test.adapters.RandonneeAdapter;
import com.example.test.models.RandonneeeModel;
import com.example.test.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class randomember_main_activity extends AppCompatActivity {
    ArrayList<RandonneeeModel> randonneeModels=new ArrayList<>();
    private TextView raondonnee_no,raondonnee_lieu;
    private RandonneeAdapter radonneAdapter;
    private RecyclerView Allrandonneee_recyclerview;
    private RecyclerView Myrandonneee_recyclerview;
    String idrandonneur ="";
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
// On suppose que tu as mis un String dans l'Intent via le putExtra()
        idrandonneur= intent.getStringExtra("norandonneur");
        setContentView(R.layout.randomember_main_activity);
        Myrandonneee_recyclerview=(RecyclerView)findViewById(R.id.myRandonnee_recyclerview);
        Allrandonneee_recyclerview=(RecyclerView)findViewById(R.id.allRandonnee_recyclerview);
        raondonnee_no=(TextView) findViewById(R.id.randonneeno);
        raondonnee_lieu=(TextView)findViewById(R.id.randonneelieu);
        Allrandonneee_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        Myrandonneee_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        System.out.println(idrandonneur);
    getALLRandoneeeResponse();
    getMyRandoneeeResponse();
        this.configureOnClickAllRecyclerRandoView();
        this.configureOnClickMyRandoRecyclerView();

    }
    private void getALLRandoneeeResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://globecen.freeboxos.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AllRandonneeRequeteInterface requestInteface=retrofit.create(AllRandonneeRequeteInterface.class);
        Call<List<RandonneeeModel>> call=requestInteface.getAllRandonnee(idrandonneur);
        call.enqueue(new Callback<List<RandonneeeModel>>() {
            @Override

            public void onResponse(Call<List<RandonneeeModel>> call, Response<List<RandonneeeModel>> response) {
                randonneeModels=new ArrayList<>(response.body());
                radonneAdapter=new RandonneeAdapter(randomember_main_activity.this,randonneeModels);
                Allrandonneee_recyclerview.setAdapter(radonneAdapter);
                Toast.makeText(randomember_main_activity.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<RandonneeeModel>> call, Throwable t) {
                Toast.makeText(randomember_main_activity.this,"Je Suis Null",Toast.LENGTH_SHORT).show();
                Toast.makeText(randomember_main_activity.this,"Failed",Toast.LENGTH_SHORT).show();
                Log.e("erreur",t.getMessage());
            }
        });
    }
    private void getMyRandoneeeResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://globecen.freeboxos.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRadonneeRequeteInterface requestInteface=retrofit.create(MyRadonneeRequeteInterface.class);
        Call<List<RandonneeeModel>> call=requestInteface.getMyAllRandonnee(idrandonneur);
       // System.out.println("Salut bg");
        call.enqueue(new Callback<List<RandonneeeModel>>() {
            @Override

            public void onResponse(Call<List<RandonneeeModel>> call, Response<List<RandonneeeModel>> response) {
                randonneeModels=new ArrayList<>(response.body());
                radonneAdapter=new RandonneeAdapter(randomember_main_activity.this,randonneeModels);
                Myrandonneee_recyclerview.setAdapter(radonneAdapter);
                Toast.makeText(randomember_main_activity.this,"Cc bg",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<RandonneeeModel>> call, Throwable t) {
                Toast.makeText(randomember_main_activity.this,"Je Suis Null",Toast.LENGTH_SHORT).show();
                Toast.makeText(randomember_main_activity.this,"Failed",Toast.LENGTH_SHORT).show();
                Log.e("erreur",t.getMessage());
            }
        });
    }
    private void configureOnClickAllRecyclerRandoView(){
        ItemClickSupport.addTo(Myrandonneee_recyclerview, R.layout.randomember_main_activity)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        RandonneeeModel rando = radonneAdapter.getRando(position);
                        Toast.makeText(getApplicationContext(), "Vous avez cliquez sur la randonne n° : "+rando.getNo_randonnee(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(randomember_main_activity.this,
                        randomember_read_active_event_activity.class);
                         i.putExtra("norandonnee", rando.getNo_randonnee());
                         System.out.println(idrandonneur);
                        i.putExtra("idrandonneur", idrandonneur);
                        startActivity(i);
                    }

                });

    }
    private void configureOnClickMyRandoRecyclerView() {
        ItemClickSupport.addTo(Allrandonneee_recyclerview, R.layout.randomember_main_activity)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        RandonneeeModel rando = radonneAdapter.getRando(position);
                        Toast.makeText(getApplicationContext(), "Vous avez cliquez sur la randonne n° : " + rando.getNo_randonnee(), Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(randomember_read_active_event_activity.class));
                        //  Intent i = new Intent(randomember_main_activity.this,
                        // randomember_read_active_event_activity.class);
                        // i.putExtra("norando", rando.getNo_randonnee());
                        //startActivity(i);
                    }

                });
    }
    public void onResume(){
        super.onResume();
    }

}

