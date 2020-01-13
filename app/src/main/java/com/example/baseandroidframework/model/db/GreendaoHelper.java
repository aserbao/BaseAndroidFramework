package com.example.baseandroidframework.model.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.baseandroidframework.base.app.MyApplication;
import com.example.baseandroidframework.model.db.bean.GithubUse;
import com.example.baseandroidframework.model.db.daomaster.DaoMaster;
import com.example.baseandroidframework.model.db.daomaster.GithubUseDao;

import javax.inject.Inject;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-13 11:29
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.model.db
 */
public class GreendaoHelper implements IDBHelper {
    private static volatile GreendaoHelper mInstance;
    private GithubUseDao githubUseDao;

    public static GreendaoHelper getmInstance() {
        if (mInstance == null) mInstance = new GreendaoHelper();
        return mInstance;
    }

    @Inject
    public GreendaoHelper() {
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApplication.getInstance(), "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        githubUseDao = daoMaster.newSession().getGithubUseDao();
    }


}
