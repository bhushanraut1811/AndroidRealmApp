package com.app.shop.shopapp.model;

import io.realm.RealmObject;

/**
 * Created by bhushan.raut on 4/14/2016.
 */
public class User extends RealmObject {
    private String mUserName;
    private String mUserPassword;

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserPassword() {
        return mUserPassword;
    }

    public void setmUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword;
    }


}
