package com.example.retrofitapp2.retrofit;

import com.example.retrofitapp.retrofit.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//change class to interface
public interface DogeService {


    @GET(Constants.SHIBE_PATH)

    Call<List<String>> getShibes(@Query("count") int count);
}
