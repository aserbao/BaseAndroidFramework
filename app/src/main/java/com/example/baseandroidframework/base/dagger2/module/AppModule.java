package com.example.baseandroidframework.base.dagger2.module;

import com.example.baseandroidframework.base.app.MyApplication;

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


}
