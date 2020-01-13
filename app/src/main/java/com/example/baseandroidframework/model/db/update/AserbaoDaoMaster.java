package com.example.baseandroidframework.model.db.update;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.baseandroidframework.model.db.bean.GithubUse;
import com.example.baseandroidframework.model.db.daomaster.DaoMaster;
import com.example.baseandroidframework.model.db.daomaster.GithubUseDao;

import org.greenrobot.greendao.database.Database;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-13 12:43
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.model.db.update
 */
public class AserbaoDaoMaster extends DaoMaster.OpenHelper  {
    private static final String TAG = "AserbaoDaoMaster";
    public AserbaoDaoMaster(Context context, String name) {
        super(context, name);
    }

    public AserbaoDaoMaster(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        AGreenDaoUpdateHelp.migrate(db, new AGreenDaoUpdateHelp.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }
            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, GithubUseDao.class);
    }
}
