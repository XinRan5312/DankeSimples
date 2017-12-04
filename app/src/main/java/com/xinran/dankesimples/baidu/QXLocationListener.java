package com.xinran.dankesimples.baidu;


import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;

import java.util.List;

/**
 * Created by houqixin on 2017/11/21.
 */

public class QXLocationListener extends BDAbstractLocationListener {


    @Override
    public void onReceiveLocation(BDLocation location) {
        //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
        //以下只列举部分获取经纬度相关（常用）的结果信息
        //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

        double latitude = location.getLatitude();    //获取纬度信息
        double longitude = location.getLongitude();    //获取经度信息
        float radius = location.getRadius();    //获取定位精度，默认值为0.0f

        String coorType = location.getCoorType();
        //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准

        int errorCode = location.getLocType();
        //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明

        /**
         * 获取地址信息
         */

        String addr = location.getAddrStr();    //获取详细地址信息
        String country = location.getCountry();    //获取国家
        String province = location.getProvince();    //获取省份
        String city = location.getCity();    //获取城市
        String district = location.getDistrict();    //获取区县
        String street = location.getStreet();    //获取街道信息

        /**
         * 获取位置描述信息
         */
        String locationDescribe = location.getLocationDescribe();    //获取位置描述信息


        /**
         * 获取周边POI
         */
        List<Poi> poiList = location.getPoiList();
        //获取周边POI信息
        //POI信息包括POI ID、名称等，具体信息请参照类参考中POI类的相关说明

        /**
         * 辅助功能
         *
         * 1.位置提醒  添加位置提醒监听 设置位置提醒经纬度
         * 2.国内外位置判断：
         *
             //BDLocation.getLocationWhere()方法可获得当前定位点是否是国内，它的取值及含义如下：
             //BDLocation.LOCATION_WHERE_IN_CN：当前定位点在国内；
             //BDLocation.LOCATION_WHERE_OUT_CN：当前定位点在海外；
             //其他：无法判定。
           3.移动热点的判断
         *
         */


    }

    @Override
    public void onConnectHotSpotMessage(String connectWifiMac, int hotSpotState) {
        super.onConnectHotSpotMessage(connectWifiMac, hotSpotState);
        //在这个回调中，可获取当前设备所链接网络的类型、状态信息
        //connectWifiMac：表示连接WIFI的MAC地址，无连接或者异常时返回NULL
        //hotSpotState有以下三种情况
        //LocationClient.CONNECT_HPT_SPOT_TRUE：连接的是移动热点
        //LocationClient.CONNECT_HPT_SPOT_FALSE：连接的非移动热点
        //LocationClient.CONNECT_HPT_SPOT_UNKNOWN：连接状态未知

    }

    @Override
    public void onLocDiagnosticMessage(int locType, int diagnosticType, String diagnosticMessage) {
        super.onLocDiagnosticMessage(locType, diagnosticType, diagnosticMessage);

        /**
         * Android定位SDK自v7.2版本起，在BDAbstractLocationListener中新增onLocDiagnosticMessage方法，
         * 用于细化定位失败原因，开发者可以根据具体原因从产品角度提示用户进行相关操作，达到定位成功的目的，
         * 也有助于进一步分析定位失败原因。详细说明如下：


         locType diagnosticType diagnosticMessage
         161  1	  NetWork location successful, open gps will be better!
         161  2	  NetWork location successful, open wifi will be better!
         67	  3	  Offline location failed, please check the net (wifi/cell)!
         62	  4	  Location failed beacuse we can not get any loc information without any location permission!
         62	  5	  Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!
         62	  6	  Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!
         62	  7	  Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!
         167  8	  NetWork location failed because baidu location service can not caculate the location!
         62	  9	  Location failed beacuse we can not get any loc information!

         */
    }
    //获取经纬度结束
}
