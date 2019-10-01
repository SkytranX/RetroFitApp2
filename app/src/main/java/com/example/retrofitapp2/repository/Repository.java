package com.example.retrofitapp2.repository;

import com.example.retrofitapp2.retrofit.DogeService;
import com.example.retrofitapp2.retrofit.RetroFitInstance;



import java.util.List;

import retrofit2.Call;

public class Repository {
    //Private Constructor
    private Repository() {
        //Create an inner class
    }
    static class RepositoryInstanceHolder {
        static Repository INSTANCE = new Repository();
        //ONly the INSTANCE WILL BE IN HERE
    }
    // not sure? Singleton Pattern?
    public static Repository getInstance() {
        return RepositoryInstanceHolder.INSTANCE;
    }
    // callback??? list not sure
    public Call<List<String>> getShibes(int count) {

        return RetroFitInstance
                .getInstance()
                .create(DogeService.class)
                .getShibes(count);
    }

}