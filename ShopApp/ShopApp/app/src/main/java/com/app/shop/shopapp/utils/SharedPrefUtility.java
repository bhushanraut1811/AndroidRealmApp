package com.app.shop.shopapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * <p>
 * SharedPreferenceUtility alows to get and edit in data from shared preference
 * </p>
 * Created by module.raut on 2/19/2016.
 */
public class SharedPrefUtility {
    private Context mContext;

    private static final String SHARED_PREF_NAME = "session_data";

    private SharedPreferences mPref;

    public SharedPrefUtility(Context context) {
        this.mContext = context;

    }


    /**
     * <p>
     * edits data in shared preference
     * </p>
     *
     * @param key   key to identify
     * @param value key's value
     */
    public void editPrefData(String key, String value) {
        mPref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * <p>
     * retreives value from shared pref
     * </p>
     *
     * @param key key to fetch value
     * @return return values related to given key
     */
    public String getPrefData(String key) {
        mPref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return mPref.getString(key, "false");
    }

    public void editIntData(String key, int value) {
        mPref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getIntPrefData(String key) {
        mPref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return mPref.getInt(key, 0);
    }


}
