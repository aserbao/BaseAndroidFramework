package com.example.baseandroidframework.demo;

import android.os.Handler;
import android.os.Message;

import com.example.baseandroidframework.demo.contracts.IDownLoadContrat;

import java.lang.ref.WeakReference;

/*
 *
 * com.example.baseandroidframework.demo
 * Created by aserbao on 2019-11-24
 */
public class DownloadModel {

    IDownLoadContrat.IModel mIModel;



    public DownloadModel(IDownLoadContrat.IModel IModel) {
        mIModel = IModel;
    }

    private Thread mThread;
    private boolean mIsPause = false;
    private int curProgress = 0;
    /**
     * 从网络获取数据
     * @param start 开始的数据
     */
    public void getDataFromHTTP(int start){
        curProgress = start;
        mIsPause = false;
        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (curProgress < 100 && !mIsPause) {
                    curProgress++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (mIModel != null) {
                        mIModel.updateData(curProgress);
                    }
                }
            }
        },"This is a download Thread");
        mThread.start();
    }

    /**
     * 取消网络请求
     */
    public void cancelRequest(){
        mIsPause = true;
    }

}
