package com.example.baseandroidframework.base.dagger2.component;

import com.example.baseandroidframework.base.dagger2.module.HttpModule;
import com.example.baseandroidframework.retrofit.RetrofitActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2019-11-30 19:42
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.dagger2.component
 */
@Singleton
@Component(modules = {HttpModule.class})
public interface ActivityComponent  {
    void inject(RetrofitActivity retrofitActivity);
}
