package com.example.baseandroidframework.model.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-13 12:47
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.model.db.bean
 */
@Entity
public class GithubUse {
    private String name ;

    @Generated(hash = 222342126)
    public GithubUse(String name) {
        this.name = name;
    }

    @Generated(hash = 1456089523)
    public GithubUse() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
