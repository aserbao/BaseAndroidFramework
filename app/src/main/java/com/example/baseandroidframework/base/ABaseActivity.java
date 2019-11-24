package com.example.baseandroidframework.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/*
 * Activity基类
 * Created by aserbao on 2019-11-23
 * com.example.baseandroidframework.base
 * 2019-11-23
 */
public abstract class ABaseActivity extends AppCompatActivity {
    private Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        ButterKnife.bind(this);
        initView();
        initEvent();
    }

    /**
     * 事件处理方法
     */
    private void initEvent() { }

    /**
     * 视图初始化方法
     */
    private void initView() { }

    /**
     * @return layout布局
     */
    protected abstract int getLayout();
}
