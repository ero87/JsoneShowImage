package com.example.ero.showimage.services;

import com.example.ero.showimage.models.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("photos")
    Call<List<Model>> getImagesData();
}
