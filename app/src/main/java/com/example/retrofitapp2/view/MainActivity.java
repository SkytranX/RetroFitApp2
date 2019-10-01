package com.example.retrofitapp2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp2.R;
import com.example.retrofitapp2.adapter.DogeAdapter;
import com.example.retrofitapp2.viewmodel.MainViewModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel m_ViewModel;
    RecyclerView shibe_screen;
    Button btn_Switch;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shibe_screen);

        m_ViewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);
        m_ViewModel.getShibes(15)
                .enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                    DogeAdapter adapter = new DogeAdapter(response.body());
                    shibe_screen.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {

                    }
                });

        shibe_screen = findViewById(R.id.doge_Screen);
        shibe_screen.setHasFixedSize(true);
       GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        shibe_screen.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onClick(View view) {

    }
}
