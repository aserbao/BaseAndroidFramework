package com.example.baseandroidframework.base.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-10 16:47
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.base.app
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    private View rootView;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayout(),container,false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();
    }

    /**
     * 事件处理
     */
    protected void initEvent(){};

    protected abstract int getLayout();


}
