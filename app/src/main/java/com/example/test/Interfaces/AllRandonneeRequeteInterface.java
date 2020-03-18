package com.example.test.Interfaces;

import com.example.test.models.RandonneeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AllRandonneeRequeteInterface {
    String norandonneur="";
    @GET("/backendAndroid/AfficheAllRando.php/")
    Call<List<RandonneeeModel>> getAllRandonnee(@Query("norandonneur") String id);
}
