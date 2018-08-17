package com.example.ero.showimage.activitys;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ero.showimage.R;
import com.example.ero.showimage.adapters.ImageShowAdapter;
import com.example.ero.showimage.models.Model;
import com.example.ero.showimage.services.ApiService;
import com.example.ero.showimage.services.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "tag";
    private ImageShowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        adapter = new ImageShowAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
        retrofitLoader();
    }

    private void retrofitLoader() {
        ApiService client = RetrofitClient.getClient().create(ApiService.class);
        Call<List<Model>> call = client.getImagesData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Model>> call, @NonNull Response<List<Model>> response) {
                List<Model> list = response.body();
                adapter.setData(list);
            }

            @Override
            public void onFailure(@NonNull Call<List<Model>> call, @NonNull Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
