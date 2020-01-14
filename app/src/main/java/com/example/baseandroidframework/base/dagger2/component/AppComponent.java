package com.example.baseandroidframework.base.dagger2.component;

import com.example.baseandroidframework.base.app.MyApplication;
import com.example.baseandroidframework.base.dagger2.module.AppModule;
import com.example.baseandroidframework.base.dagger2.module.HttpModule;
import com.example.baseandroidframework.model.db.GreendaoHelper;
import com.example.baseandroidframework.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-10 16:39
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.dagger2.component
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    MyApplication getContext();
    RetrofitHelper retrofitHelper();
    GreendaoHelper greenDaoHelper();
}
