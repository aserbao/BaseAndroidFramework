package com.example.baseandroidframework.retrofit;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/*
 *
 * com.example.baseandroidframework.retrofit
 * Created by aserbao on 2019-11-24
 */
public interface IGitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("{user}/repos")
    Call<List<Repo>> listRepos2(@Path("user") String user);

    @HTTP(method = "GET",path = "{user}/repos", hasBody = true)
    Call<List<Repo>> listRepos3(@Path("user") String user);

    @GET("https://api.github.com/users/aserbao/repos")
    Call<List<Repo>> listAbsRepos();


}
