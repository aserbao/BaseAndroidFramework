package com.example.baseandroidframework.base.mvp;

/*
 * 所有Presenter的基类
 * com.example.baseandroidframework.base
 * Created by aserbao on 2019-11-24
 */
public abstract class BasePresenter<T extends IBaseView>{
    protected T mView;

    public void attachView(T view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }
}
