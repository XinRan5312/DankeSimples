package com.xinran.dankesimples.crash;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.compat.BuildConfig;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by houqixin on 2017/11/17.
 */

public class DKCrashHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler;
    private Context mContext;

    private MobileEnvironment mEnv;
    private static DKCrashHandler sInstance;
    private static Object clock=new Object();
    private DKCrashHandler(Context context){
        Thread currentThread = Thread.currentThread();
        mDefaultExceptionHandler = currentThread.getUncaughtExceptionHandler();
        currentThread.setUncaughtExceptionHandler(this);
        mContext = context;

    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {

    }
//    public static DKCrashHandler init(Context context){
//        if(sInstance==null){
//            synchronized (clock){
//                sInstance=new DKCrashHandler(context);
//            }
//        }
//        return sInstance;
//    }
//
//    @Override
//    public void uncaughtException(Thread thread, final Throwable ex) {
//        Logger.e(ex.getMessage());
//        ex.printStackTrace();
//        if (!handleException(ex) && mDefaultExceptionHandler != null) {
//            mDefaultExceptionHandler.uncaughtException(thread, ex);
//        } else {
//            android.os.Process.killProcess(android.os.Process.myPid());
//            System.exit(10);
//        }
//    }
//
//    public boolean handleException(Throwable ex) {
//        if (ex == null) {
//            Logger.e("handleException with ex = " + ex);
//            return false;
//        }
//        collectCrashMessage(ex);
//        return true;
//    }
//
//    private void collectCrashMessage(Throwable message) {
//        FileOutputStream fos = null;
//        try {
//            File file = new File(Constants.Path.CRASH_PATH);
//            if (file == null) {
//                return;
//            }
//            //追加
//            fos = new FileOutputStream(file, true);
//            collectMobileEnvironment(fos);
//            collectStackTrace(message, fos);
//            message.printStackTrace(new PrintStream(fos, true, "UTF-8"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.flush();
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private void collectMobileEnvironment(OutputStream os) {
//        try {
//            for (int i = 1; i < 100; i++)
//                os.write("*".getBytes("UTF-8"));
//            collectCurrentStatus(mContext, os);
//            if (mEnv == null) {
//                mEnv = new MobileEnvironment(mContext);
//            }
//            EnvironmentBean bean = mEnv.getEnvironmentInfo();
//            String res = bean.toParams().toString();
//            os.write(("\n\n" + res + "\n\n").getBytes("UTF-8"));
//            for (int i = 1; i < 50; i++)
//                os.write("=".getBytes("UTF-8"));
//            os.write(("\n\n").getBytes("UTF-8"));
//            os.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void collectCurrentStatus(Context context, OutputStream os) {
//        if (os == null) {
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('\n').append("APPLICATION INFORMATION").append('\n');
//        long time = System.currentTimeMillis() + 1000 * 60 * 60 * 2;
//        SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.DETAIL_TIME, Locale.CHINA);
//        sb.append("Time : ").append(formatter.format(new Date(time))).append('\n');
//        PackageManager pm = context.getPackageManager();
//        ApplicationInfo ai = context.getApplicationInfo();
//        sb.append("Application : ").append(pm.getApplicationLabel(ai)).append('\n');
//
//        try {
//            PackageInfo pi = pm.getPackageInfo(ai.packageName, 0);
//            sb.append("Version Code: ").append(pi.versionCode).append('\n');
//            sb.append("Version Name: ").append(pi.versionName).append('\n');
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        sb.append('\n').append("DEVICE INFORMATION").append('\n');
//        sb.append("Board: ").append(Build.BOARD).append('\n');
//        sb.append("BOOTLOADER: ").append(Build.BOOTLOADER).append('\n');
//        sb.append("BRAND: ").append(Build.BRAND).append('\n');
//        sb.append("CPU_ABI: ").append(Build.CPU_ABI).append('\n');
//        sb.append("CPU_ABI2: ").append(Build.CPU_ABI2).append('\n');
//        sb.append("DEVICE: ").append(Build.DEVICE).append('\n');
//        sb.append("DISPLAY: ").append(Build.DISPLAY).append('\n');
//        sb.append("FINGERPRINT: ").append(Build.FINGERPRINT).append('\n');
//        sb.append("HARDWARE: ").append(Build.HARDWARE).append('\n');
//        sb.append("HOST: ").append(Build.HOST).append('\n');
//        sb.append("ID: ").append(Build.ID).append('\n');
//        sb.append("MANUFACTURER: ").append(Build.MANUFACTURER).append('\n');
//        sb.append("PRODUCT: ").append(Build.PRODUCT).append('\n');
//        sb.append("TAGS: ").append(Build.TAGS).append('\n');
//        sb.append("TYPE: ").append(Build.TYPE).append('\n');
//        sb.append("USER: ").append(Build.USER).append('\n');
//
//        try {
//            os.write(sb.toString().getBytes("UTF-8"));
//            os.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void collectStackTrace(Throwable message, OutputStream os) throws IOException {
//        if (message == null || os == null) {
//            Logger.e("message = " + message + " , os = " + os);
//            return;
//        }
//        Throwable cause = message.getCause();
//        if (cause == null) {
//            Logger.e("cause = " + cause);
//            return;
//        }
//        StackTraceElement[] element = cause.getStackTrace();
//        if (element == null) {
//            Logger.w("StackTraceElement array is null");
//            return;
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("Crash:");
//        for (StackTraceElement e : element) {
//            if (e != null)
//                sb.append(getFileName(e)).append(":").append(e.getLineNumber()).append('\n');
//        }
//        sb.append('\n').append('\n');
//        os.write(sb.toString().getBytes("UTF-8"));
//        os.flush();
//    }
//
//    /**
//     * @param element
//     * @return 获取文件信息
//     */
//    private String getFileName(StackTraceElement element) {
//        if (BuildConfig.DEBUG) {
//            return element.getFileName();
//        } else {
//            String ste = element.toString();
//            int pos = ste.lastIndexOf(".");
//            String filename = ste.substring(0, pos);
//            return filename;
//        }
//    }
}
