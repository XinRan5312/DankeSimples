package com.xinran.dankesimples.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;


import java.io.File;
import java.util.logging.Logger;

/**
 * Created by houqixin on 2017/11/17.
 */
public class MobileEnvironment {
    private Context mContext;

    public MobileEnvironment(Context context) {
        mContext = context.getApplicationContext();
    }

    /**
     * @return 获取手机型号
     */
    public String getPhoneModel() {
        return Build.MODEL;
    }

    public String getPhoneBrand() {
        return Build.BRAND;
    }

    /**
     * @return 获取android版本号
     */
    public String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取应用版本号
     *
     * @return
     */
    public String getApplicationVersionName() {
        try {
            PackageManager manager = mContext.getPackageManager();
            PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), 0);
            String version = info.versionName + "";
            return version;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("HardwareIds")
    public String getImei() {
        String imei = ((TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        return imei;
    }

    public String getRootState() {
        boolean bool = false;
        try {
            bool = !((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists()));
        } catch (Exception e) {
            return bool + "";
        }
        return bool + "";
    }

    public int getApplicationVersionCode() {
        try {
            PackageManager manager = mContext.getPackageManager();
            PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), 0);
            int versionCode = info.versionCode;
            return versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getAndroidOsVersion() {
        int osVersion;
        try {
            osVersion = Integer.valueOf(Build.VERSION.SDK_INT);
        } catch (NumberFormatException e) {
            osVersion = 0;
        }
        return osVersion;
    }

    public EnvironmentBean getEnvironmentInfo() {
        EnvironmentBean bean = new EnvironmentBean();
        bean.setAppVersion(getApplicationVersionName());
        bean.setDeviceModel(getPhoneModel());
        bean.setImei(getImei());
        bean.setPlatformVersion(getSystemVersion());
        bean.setRoot(getRootState());
        bean.setBrand(getPhoneBrand());
        return bean;
    }
}
