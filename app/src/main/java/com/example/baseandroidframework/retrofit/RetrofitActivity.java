package com.example.baseandroidframework.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseandroidframework.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "RetrofitActivity";

    @BindView(R.id.show_tv)
    TextView mShowTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.request_btn)
    public void onViewClicked() {
        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGitHubService service = retrofit.create(IGitHubService.class);

//        Call<List<Repo>> listRepos = service.listRepos("aserbao");
        Call<List<Repo>> listRepos = service.listRepos2("aserbao");
//        Call<List<Repo>> listRepos = service.listAbsRepos();
        listRepos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                updateUi(response.body());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

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
}
