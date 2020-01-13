package com.example.baseandroidframework.model.http;

import com.example.baseandroidframework.model.http.api.GithubApis;

import javax.inject.Inject;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-13 11:26
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.model.http
 */
public class RetrofitHelper implements IHttpHelper {

    private GithubApis mGithubApis;

    @Inject
    public RetrofitHelper(GithubApis mGithubApis) {
        this.mGithubApis = mGithubApis;
    }
}
