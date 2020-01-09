package com.example.omgocr;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    @Multipart
    @POST("mobilePost")
    Call<MyResponse> uploadAttachment(@Part MultipartBody.Part filePart);

    @GET("getText")
    Call <List<OcrText>>resultsText();
}
