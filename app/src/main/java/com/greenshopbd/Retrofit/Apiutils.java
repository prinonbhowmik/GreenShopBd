package com.greenshopbd.Retrofit;

public class Apiutils {
    public static final String BASE_URL = "https://bikroyonline.com/laraecomm/api/";

    public static ApiInterface getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
