package com.example.baseandroidframework.base.dagger2.module;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.example.baseandroidframework.base.dagger2.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-13 14:42
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.base.dagger2.module
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
