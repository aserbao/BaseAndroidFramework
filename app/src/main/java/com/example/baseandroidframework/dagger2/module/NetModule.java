package com.example.baseandroidframework.dagger2.module;

import com.example.baseandroidframework.retrofit.IGitHubService;
import com.example.baseandroidframework.retrofit.Repo;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

@Module
public class NetModule {

  public static final String COUNTRY_SERVICE_BASE_URLL = "https://api.github.com/user/";

  @Provides
  @Singleton
  Retrofit provideRetrofit() {
    return new Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(COUNTRY_SERVICE_BASE_URLL)
        .build();
  }

  @Provides
  Observable<List<Repo>> prodiveCountryList(Retrofit retrofit) {
    return retrofit
        .create(IGitHubService.class)
        .listRepos("aserbao");
  }
}