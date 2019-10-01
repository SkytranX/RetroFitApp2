package com.example.retrofitapp2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.retrofitapp2.R;

import com.example.retrofitapp2.repository.Repository;

import java.util.List;

import retrofit2.Call;


public class MainViewModel extends AndroidViewModel {


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public Call<List<String>> getShibes(int count) {
        return Repository.getInstance().getShibes(count);
    }
}

