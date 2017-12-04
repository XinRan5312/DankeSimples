package com.xinran.dankesimples.baidu;

import android.location.Location;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.LocationClientOption;

/**
 * Created by houqixin on 2017/11/21.
 * start()：启动定位SDK.stop()：关闭定位SDK。调用start()之后只需要等待定位结果自动回调即可。

 开发者定位场景如果是单次定位的场景，在收到定位结果之后直接调用stop()函数即可。

 如果stop()之后仍然想进行定位，可以再次start()等待定位结果回调即可。

 自v7.2版本起，新增LocationClient.reStart()方法，用于在某些特定的异常环境下重启定位。

 如果开发者想按照自己逻辑请求定位，可以在start()之后按照自己的逻辑请求LocationClient.requestLocation()函数，会主动触发定位SDK内部定位逻辑，等待定位回调即可。


 */

public interface LocationInterface {
    void startLocation();

    void restartLocation();

    void stopLocation();

    void requestLocation();

    boolean requestHotSpotState();

     LocationClientOption getLocOption();

    void setLocOption(LocationClientOption var1);

    boolean updateLocation(Location var1);

    public void requestNotifyLocation();

    public int requestOfflineLocation() ;

    public boolean isStarted();

    public BDLocation getLastKnownLocation();

    public String getVersion() ;



    public void registerNotify(BDNotifyListener var1);


    public void removeNotifyEvent(BDNotifyListener var1) ;
    public void registerNotifyLocationListener(BDLocationListener var1);

    /** @deprecated */
    public void registerLocationListener(BDLocationListener var1);
    /** @deprecated */
    public void unRegisterLocationListener(BDLocationListener var1) ;

    public void registerLocationListener(BDAbstractLocationListener var1);


    public void unRegisterLocationListener(BDAbstractLocationListener var1);

    public boolean startIndoorMode() ;

    public boolean stopIndoorMode();


}
