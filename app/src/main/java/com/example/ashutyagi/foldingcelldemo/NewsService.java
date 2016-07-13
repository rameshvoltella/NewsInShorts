package com.example.ashutyagi.foldingcelldemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ashu on 7/7/2016.
 */
public interface NewsService {

    @GET("stories")
    Call<StoryResponse> fetchStories();

    @GET("stories")
    Call<StoryResponse> fetchStoriesByCategory(@Query("category[]") List<Integer> fetchid);

    @GET("categories")
    Call<List<CategoryResponse>> fetchCategory();
}
