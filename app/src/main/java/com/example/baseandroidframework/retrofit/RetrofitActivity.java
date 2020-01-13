package com.example.baseandroidframework.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseandroidframework.R;
import com.example.baseandroidframework.base.dagger2.component.DaggerActivityComponent;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "RetrofitActivity";

    @BindView(R.id.show_tv)
    TextView mShowTv;

    @Inject
    Observable<List<Repo>> mObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        DaggerActivityComponent.builder().build().inject(this);
    }


    @OnClick(R.id.request_btn)
    public void onViewClicked() {
        testDagger2AndRetrofit();
//        testRetrofit();

    }

    private void testDagger2AndRetrofit() {
        if (mObservable != null) {
            mObservable
//                    .observeOn(AndroidScheduler.mainThread())
                    .observeOn(Schedulers.newThread())
                    .subscribe(new Consumer<List<Repo>>() {
                @Override
                public void accept(List<Repo> repos) {
                    updateUi(repos);
                }
            });
        }
    }

    private void testRetrofit() {
        Retrofit retrofit = getRetrofit();

        IGitHubService service = retrofit.create(IGitHubService.class);

        service.listRepos("aserbao")
        .subscribe(new Consumer<List<Repo>>() {
            @Override
            public void accept(List<Repo> repos) {
                updateUi(repos);
            }
        });
    }

    @NotNull
    private Retrofit getRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                //添加OkHttp3的拦截器
                .addInterceptor(new LoggingInterceptor())
                .writeTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
                .baseUrl("https://api.github.com/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public void updateUi(List<Repo> body){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < body.size(); i++) {
            Repo repo = body.get(i);
            stringBuffer.append(repo.getName())
                    .append("\n");
        }
        mShowTv.setText(stringBuffer.toString());
    }


    class LoggingInterceptor implements Interceptor {
        @Override public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            Log.e(TAG, String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));
            okhttp3.Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            Log.e(TAG, String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }
}
