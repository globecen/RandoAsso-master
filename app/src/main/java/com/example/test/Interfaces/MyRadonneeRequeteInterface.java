package com.example.test.Interfaces;

import com.example.test.models.RandonneeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyRadonneeRequeteInterface {
    String norandonneur="";
    @GET("/backendAndroid/AfficheAllMyRando.php/")
    Call<List<RandonneeeModel>> getMyAllRandonnee(@Query("norandonneur") String id);
}