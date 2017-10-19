package in.microlan.www.perfectmatrimony.utility;


import android.content.Context;
import android.content.SharedPreferences;

import in.microlan.www.perfectmatrimony.common.constant.StringConstant;

public class PreferenceUtility {

    public static final String TAG = PreferenceUtility.class.getSimpleName();
    private static SharedPreferences sharedPreferences;
    private static PreferenceUtility preferenceUtility = null;

    private PreferenceUtility(Context context) {
        sharedPreferences = context.getSharedPreferences(StringConstant.IPreference.ETW_PREF, 0);
    }

    public static PreferenceUtility getPreferenceInstance(Context context) {

        if (preferenceUtility == null) {
            preferenceUtility = new PreferenceUtility(context);
        }
        return preferenceUtility;

    }

    public static void clearPreferences() {

        sharedPreferences.edit().clear().apply();

    }


    public static void setIsUserLoggedIn(boolean isUserLoggedIn) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(StringConstant.IPreference.IS_USER_LOGGED_PREF, isUserLoggedIn);
        editor.apply();
    }

    public static boolean getUserLogin() {
        return sharedPreferences.getBoolean(StringConstant.IPreference.IS_USER_LOGGED_PREF, false);
    }

    public static void setIsUserAddReplyNote(boolean userAddReplyNote) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(StringConstant.IPreference.IS_USER_ADD_REPLY_NOTE, userAddReplyNote);
        editor.apply();
    }

    public static boolean getUserAddReplyNote() {
        return sharedPreferences.getBoolean(StringConstant.IPreference.IS_USER_ADD_REPLY_NOTE, false);
    }

    public static void setDeviceToken(String deviceToken) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(StringConstant.IPreference.DEVICE_TOKEN, deviceToken);
            editor.apply();
        }
    }


    public static String getDeviceToken() {
        return sharedPreferences.getString(StringConstant.IPreference.DEVICE_TOKEN, null);
    }


}
