package com.example.baseandroidframework.base.dagger2.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 功能:
 *
 * @author aserbao
 * @date : On 2020-01-13 14:43
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.base.dagger2.scope
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}