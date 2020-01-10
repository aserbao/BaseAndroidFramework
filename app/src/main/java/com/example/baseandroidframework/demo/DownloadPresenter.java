package com.example.baseandroidframework.demo;

import com.example.baseandroidframework.base.mvp.BasePresenter;
import com.example.baseandroidframework.demo.contracts.IDownLoadContrat;

/*
 * 下载管理Presenter
 * com.example.baseandroidframework.demo.contracts
 * Created by aserbao on 2019-11-24
 */
public class DownloadPresenter extends BasePresenter<IDownLoadContrat.View> implements IDownLoadContrat.Presenter,IDownLoadContrat.IModel {
    DownloadModel mDownloadModel;
    int mCuurProgress = 0;
    boolean mIsPause = true;

    public DownloadPresenter() {
        mDownloadModel = new DownloadModel(this);
    }

    @Override
    public void startDownload() {
        if (mView != null && mDownloadModel != null) {
            mView.showMsg("正在下载中……");
            mDownloadModel.getDataFromHTTP(mCuurProgress);
            mIsPause = false;
        }
    }

    @Override
    public void pauseDownload() {
        if (mView != null) {
            if (!mIsPause && mDownloadModel != null) {
                mDownloadModel.cancelRequest();
                mIsPause = true;
                mView.showMsg("下载已暂停……");
            } else {
                mView.showMsg("尚未开始下载，请先开始下载");
            }
        }
    }

    @Override
    public void resetDownload() {
        if (mView != null && mDownloadModel != null) {
            mView.showMsg("重置下载内容……");
            mDownloadModel.cancelRequest();
            mCuurProgress = 0;
            startDownload();
        }
    }


    @Override
    public void updateData(int progress) {
        mCuurProgress = progress;
        if (mView != null) {
            mView.updateProgress(progress);
        }
    }
}
