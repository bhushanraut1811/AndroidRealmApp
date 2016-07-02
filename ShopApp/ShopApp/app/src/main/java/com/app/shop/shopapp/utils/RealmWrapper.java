package com.app.shop.shopapp.utils;

import android.content.Context;

import io.realm.Realm;

/**
 * Created by bhushan.raut on 7/2/2016.
 */
public class RealmWrapper {

    public static Realm mRealm = null;

    private RealmWrapper(Context context) {
        this.mRealm = Realm.getInstance(context);
    }

    public static Realm createRealmInstance(Context context) {
        if (mRealm == null) {
            new RealmWrapper(context);
        }
        return mRealm;
    }
}
