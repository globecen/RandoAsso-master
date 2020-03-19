package com.example.test.Interfaces;

import com.example.test.models.RandonneeeModel;
import com.example.test.models.StatutModele;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyStatutRandonneur {
    String norandonneur="";
    @GET("/backendAndroid/RecupStatutRandonneur.php/")
    Call<List<StatutModele>> getMyStatutRandonneur(@Query("norandonneur") String id);
}
