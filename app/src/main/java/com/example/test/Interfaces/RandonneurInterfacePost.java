package com.example.test.Interfaces;

import com.example.test.models.RandonneurModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RandonneurInterfacePost {
   // @POST("/randonneur");
    Call<List<RandonneurModel>>setRandonneur();
}
