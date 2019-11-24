package com.example.baseandroidframework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseandroidframework.demo.DownloadPresenter;
import com.example.baseandroidframework.demo.contracts.IDownLoadContrat;
import com.example.baseandroidframework.retrofit.RetrofitActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IDownLoadContrat.View {

    @BindView(R.id.show_progress_tv)
    TextView mShowProgressTv;
    @BindView(R.id.show_pb)
    ProgressBar mShowPb;
    private DownloadPresenter mDownloadPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDownloadPresenter = new DownloadPresenter();
        mDownloadPresenter.attachView(this);
    }

    @OnClick({R.id.progress_start_btn, R.id.progress_pause_btn, R.id.progress_reset_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.progress_start_btn:
                if (mDownloadPresenter != null) {
                    mDownloadPresenter.startDownload();
                }
                break;
            case R.id.progress_pause_btn:
                if (mDownloadPresenter != null) {
                    mDownloadPresenter.pauseDownload();
                }
                break;
            case R.id.progress_reset_btn:
                /*if (mDownloadPresenter != null) {
                    mDownloadPresenter.resetDownload();
                }*/
                Intent intent = new Intent(this, RetrofitActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void updateProgress(int progress) {
        mShowPb.setProgress(progress);
    }

    @Override
    public void showMsg(String msg) {
        mShowProgressTv.setText(msg);
    }

    @Override
    public Activity getCuurActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDownloadPresenter != null) {
            mDownloadPresenter.detachView();
        }
    }
}
