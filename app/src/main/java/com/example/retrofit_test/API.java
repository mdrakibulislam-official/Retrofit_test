package com.example.retrofit_test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    @FormUrlEncoded
    @POST("connection.php")
    Call<ResponseBody> createUSer(
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("email") String email

    );
}
