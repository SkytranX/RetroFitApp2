package com.example.retrofitapp2.retrofit;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitInstance {
    private RetroFitInstance() {
        //Private Constructor
    }
    private static class RetrofitInstanceHolder {
        static Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(com.example.retrofitapp.retrofit.Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getInstance() {
        return RetrofitInstanceHolder.INSTANCE;
    }

    public static <S> S createService(Class<S> serviceClass) {
        return RetrofitInstanceHolder.INSTANCE.create(serviceClass);
    }
}
