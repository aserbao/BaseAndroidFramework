package com.example.baseandroidframework.dagger2.component;

import android.app.Activity;

import com.example.baseandroidframework.dagger2.module.NetModule;
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
@Component(modules = {NetModule.class})
public interface ActivityComponent  {
    void inject(RetrofitActivity retrofitActivity);
}
