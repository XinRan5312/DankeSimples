package com.xinran.dankesimples.baidu;

import android.location.Location;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.xinran.dankesimples.DKApplication;

/**
 * Created by houqixin on 2017/11/21.
 */

public class LocationManager implements LocationInterface{

    private QXLocationListener mLocationListener;
    private LocationClient mLocationClient;

    private ConfigLocationOption mLocationOption;

    private static Object clock=new Object();

    private static LocationManager sInstance;

    private LocationManager(){
        mLocationListener=new QXLocationListener();
        mLocationClient=new LocationClient(DKApplication.getApplication(),ConfigLocationOption.newInstance().getDefaultLocationOption());
        mLocationClient.registerLocationListener(mLocationListener);

    }

    public static LocationManager newInstance(){
        if(sInstance==null){
            synchronized (clock){
                sInstance=new LocationManager();
            }
        }

        return sInstance;
    }
    public LocationManager setLocationListener(BDAbstractLocationListener listener){
        mLocationClient.registerLocationListener(listener);

        return this;
    }

    @Override
    public void startLocation() {

        if(!mLocationClient.isStarted()){

            mLocationClient.start();
        }

    }

    @Override
    public void restartLocation() {

    }

    @Override
    public void stopLocation() {

        if(mLocationClient.isStarted()){
            mLocationClient.stop();
        }

    }

    @Override
    public void requestLocation() {
        if(mLocationClient.isStarted()) mLocationClient.requestLocation();

    }

    @Override
    public boolean requestHotSpotState() {
        return mLocationClient.requestHotSpotState();
    }

    @Override
    public LocationClientOption getLocOption() {
        return mLocationClient.getLocOption();
    }

    @Override
    public void setLocOption(LocationClientOption var1) {
        mLocationClient.setLocOption(var1);

    }

    @Override
    public boolean updateLocation(Location var1) {
        return mLocationClient.updateLocation(var1);
    }

    @Override
    public void requestNotifyLocation() {

        mLocationClient.requestNotifyLocation();

    }

    @Override
    public int requestOfflineLocation() {
        return mLocationClient.requestOfflineLocation();
    }

    @Override
    public boolean isStarted() {
        return mLocationClient.isStarted();
    }

    @Override
    public BDLocation getLastKnownLocation() {
        return mLocationClient.getLastKnownLocation();
    }

    @Override
    public String getVersion() {
        return mLocationClient.getVersion();
    }

    @Override
    public void registerNotify(BDNotifyListener var1) {

        mLocationClient.registerNotify(var1);

    }

    @Override
    public void removeNotifyEvent(BDNotifyListener var1) {
        mLocationClient.removeNotifyEvent(var1);

    }

    @Override
    public void registerNotifyLocationListener(BDLocationListener var1) {
        mLocationClient.registerNotifyLocationListener(var1);

    }

    @Override
    public void registerLocationListener(BDLocationListener var1) {

        mLocationClient.registerLocationListener(var1);

    }

    @Override
    public void unRegisterLocationListener(BDLocationListener var1) {

        mLocationClient.unRegisterLocationListener(var1);

    }

    @Override
    public void registerLocationListener(BDAbstractLocationListener var1) {
        mLocationClient.registerLocationListener(var1);

    }

    @Override
    public void unRegisterLocationListener(BDAbstractLocationListener var1) {
        mLocationClient.unRegisterLocationListener(var1);

    }

    @Override
    public boolean startIndoorMode() {
        return mLocationClient.startIndoorMode();
    }

    @Override
    public boolean stopIndoorMode() {
        return mLocationClient.stopIndoorMode();
    }
}
