package com.example.logincallapi.api;

import com.example.logincallapi.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiservice = new Retrofit.Builder()
            .baseUrl(" https://bmis.vnpt.vn")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);



    @POST("/cudanapi/api/Mobile/DangNhap")
    Call<User> senduser(@Body User user);
}
