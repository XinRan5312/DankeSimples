package com.xinran.dankesimples.crash;

import android.content.Context;



/**
 * Created by houqixin on 2017/11/22.
 */

public class DKBugly {

    public static void init(Context cts) {

        Context context = cts.getApplicationContext();
        String packageName = context.getPackageName();
//
//        BuglyStrategy buglyStrategy = new BuglyStrategy();
//        buglyStrategy.setAppPackageName(packageName);
//        buglyStrategy.setAppReportDelay(2000);
//        buglyStrategy.setEnableANRCrashMonitor(true);
//        buglyStrategy.setEnableNativeCrashMonitor(true);
//        Beta.canShowUpgradeActs.add(MainActivity.class);
//        Beta.enableNotification = true;
//        Beta.autoDownloadOnWifi = true;
//        Beta.enableHotfix = false;
//
//        Bugly.init(context, Constants.BUGLY_ID, true, buglyStrategy);
    }


}
