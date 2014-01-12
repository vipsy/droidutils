package com.selesca.droidutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Set;

public class BasePreferences {

    public static synchronized BasePreferences getInstance(Context context) {
        if (mPreference == null) {
            mPreference = new BasePreferences(context);
        }
        return mPreference;
    }

    public SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(getPreferenceName(), Context.MODE_PRIVATE);
    }


    public int getInt(String setting, int defaultVal, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getInt(setting, defaultVal);
    }

    public String getString(String setting, String defaultVal, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getString(setting, defaultVal);
    }

    public boolean getBoolean(String setting, boolean defaultVal, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getBoolean(setting, defaultVal);
    }


    public long getLong(String setting, long defaultValue, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getLong(setting, defaultValue);
    }

    public BasePreferences setInt(String setting, int value, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        Editor edit = settings.edit();
        edit.putInt(setting, value);
        edit.commit();
        return this;
    }

    public BasePreferences setString(String setting, String value, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        Editor edit = settings.edit();
        edit.putString(setting, value);
        edit.commit();
        return this;
    }

    public BasePreferences setBoolean(String setting, boolean value, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        Editor edit = settings.edit();
        edit.putBoolean(setting, value);
        edit.commit();
        return this;
    }

    public BasePreferences setLong(String setting, long value, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        Editor edit = settings.edit();
        edit.putLong(setting, value);
        edit.commit();
        return this;
    }

    public BasePreferences setStringSet(String setting, Set<String> value, Context context) {
        SharedPreferences settings = getSharedPreferences(context);
        Editor edit = settings.edit();
        edit.putStringSet(setting, value);
        edit.commit();
        return this;
    }

    /**
     * Protected constructor to make the class singleton.
     * @param context   Application context.
     */
    protected BasePreferences(Context context) {

    }

    /**
     * Override this method to change the preference name.
     * By default it returns {@link}
     * @return Name of the shared preference.
     *
     */
    protected String getPreferenceName() {
        return DEFAULT_PREFERENCES;
    }

    private static final String DEFAULT_PREFERENCES = "main";

    private static BasePreferences mPreference = null;
}
