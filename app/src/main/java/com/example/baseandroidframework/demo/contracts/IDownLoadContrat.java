package com.example.baseandroidframework.demo.contracts;

import com.example.baseandroidframework.base.BasePresenter;
import com.example.baseandroidframework.base.IBasePresenter;
import com.example.baseandroidframework.base.IBaseView;

/*
 * 接口管理类
 * com.example.baseandroidframework.demo.contracts
 * Created by aserbao on 2019-11-24
 */
public interface IDownLoadContrat {
    interface  View extends IBaseView{
        void updateProgress(int progress);  //更新进度
        void showMsg(String msg);  //显示信息
    }

    interface Presenter extends IBasePresenter<View> {
        void startDownload();   //开始下载
        void pauseDownload();   //暂停下载
        void resetDownload();   //下载重置
    }

    interface IModel{
        void updateData(int progress); //更新数据
    }
}
