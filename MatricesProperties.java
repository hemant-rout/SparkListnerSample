package com.data.spark;

import java.io.Serializable;

/**
 * Created by Hemant on 3/18/2018.
 */
public class MatricesProperties implements Serializable{
    private String appId;
    private String appStartTime;
    private String appName;
    private String appEndTime;
    public String getAppEndTime() {
        return appEndTime;
    }

    public void setAppEndTime(String appEndTime) {
        this.appEndTime = appEndTime;
    }



    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppStartTime() {
        return appStartTime;
    }

    public void setAppStartTime(String appStartTime) {
        this.appStartTime = appStartTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


}
