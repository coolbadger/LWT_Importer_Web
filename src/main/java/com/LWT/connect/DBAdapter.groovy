package com.LWT.connect

import groovy.sql.Sql

/**
 * Created by lekoxnfx on 2017/3/15.
 */
class DBAdapter {
    // 数据库地址，账号，密码，连接驱动
    String dbUrl
    String username
    String password
    String driver
    Sql sql

    // 构造函数
    DBAdapter(String dbUrl, String username, String password, String driver) {
        this.dbUrl = dbUrl
        this.username = username
        this.password = password
        this.driver = driver
        try {
            sql = Sql.newInstance(dbUrl, username, password, driver)
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
