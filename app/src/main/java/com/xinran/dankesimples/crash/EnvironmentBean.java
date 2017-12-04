package com.xinran.dankesimples.crash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by houqixin on 2017/11/17.
 */
public class EnvironmentBean {
    private final String platform = "Android";
    private String imei;
    private String platformVersion;
    private String deviceModel;
    private String appVersion;
    private String root;
    private String brand;

    public EnvironmentBean(String imei, String platform_version, String device_model, String app_version, String root, String brand) {
        this.imei = imei;
        this.platformVersion = platform_version;
        this.deviceModel = device_model;
        this.appVersion = app_version;
        this.root = root;
        this.brand = brand;
    }

    public EnvironmentBean() {
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platform_version) {
        this.platformVersion = platform_version;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String device_model) {
        this.deviceModel = device_model;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String app_version) {
        this.appVersion = app_version;
    }

    public String isRoot() {
        return root;
    }

    public Map<String, String> toParams() {
        Map<String, String> map = new HashMap<>();
        map.put("platform", platform);
        map.put("platformVersion", platformVersion);
        map.put("deviceModel", deviceModel);
        map.put("imei", imei);
        map.put("appVersion", appVersion);
        map.put("root", null + "");
        map.put("brand", brand);
        return map;
    }
}
