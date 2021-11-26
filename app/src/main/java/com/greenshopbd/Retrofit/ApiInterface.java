package com.greenshopbd.Retrofit;

import com.greenshopbd.Models.Login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResponse> doSignIn(@Field("email") String email, @Field("pass") String password);


}
