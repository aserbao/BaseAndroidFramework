package com.example.baseandroidframework.base;

/*
 *
 * com.example.baseandroidframework.base
 * Created by aserbao on 2019-11-23
 */
public interface IBasePresenter<T extends IBaseView> {
    void attachView(T view);

    void detachView();
}
