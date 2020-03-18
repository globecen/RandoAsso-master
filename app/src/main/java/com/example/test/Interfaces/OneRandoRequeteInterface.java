package com.example.test.Interfaces;

import com.example.test.models.RandonneeeModel;
import com.example.test.models.RandonnneEtAssoModele;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OneRandoRequeteInterface {
    String norandonnee="";
    @GET("/backendAndroid/AfficherOneRando.php/")
    Call<List<RandonnneEtAssoModele>> getOneRandonnee(@Query("norandonne") String id);
}
