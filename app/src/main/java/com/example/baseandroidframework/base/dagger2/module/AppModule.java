package com.example.baseandroidframework.base.dagger2.module;

import com.example.baseandroidframework.base.app.MyApplication;
import com.example.baseandroidframework.model.db.GreendaoHelper;
import com.example.baseandroidframework.model.db.IDBHelper;
import com.example.baseandroidframework.model.http.IHttpHelper;
import com.example.baseandroidframework.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-11 17:41
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.base.dagger2.module
 */
@Module
public class AppModule {
    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    MyApplication provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    IHttpHelper provideRetrofitHelper(RetrofitHelper retrofitHelper){
        return retrofitHelper;
    }

    @Provides
    @Singleton
    IDBHelper provideGreendaoHelper(GreendaoHelper greendaoHelper){
        return greendaoHelper;
    }

}
