package com.example.omgocr;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //private static final String BASE_URL="http://10.0.2.2:8080/ocrMobileApi/";
    //private static final String BASE_URL="HTTP://192.168.8.100:8080/ocrMobileApi/";
    private static final String BASE_URL="http://172.19.22.0:8080/ocrMobileApi/";
    private static Retrofit retrofit;

    public static  Retrofit getApiClient()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
