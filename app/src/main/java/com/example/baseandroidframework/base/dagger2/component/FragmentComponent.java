package com.example.baseandroidframework.base.dagger2.component;

import android.app.Activity;

import com.example.baseandroidframework.base.dagger2.module.FragmentModule;
import com.example.baseandroidframework.base.dagger2.scope.FragmentScope;

import dagger.Component;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-13 14:27
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.base.dagger2.component
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
}
