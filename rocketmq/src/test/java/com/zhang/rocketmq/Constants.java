package com.zhang.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 */
public class Constants {

    public static final int SPEED_WARN = 50;//单位 米/秒

    public static final int DIVISOR = 1000000;

    /**
     * 里程计算使用
     */
    public static final double PI = 3.1415926535898;

    public static final double RC = 6378137.0;

    public static final double RJ = 6356725.0;

    public static final int RADIUS_THREAD = 500;// 点过滤半径

    public static final int GPSTIME_FILTER = 0;// gpsTime过滤条件

    public static final int LONGITUDE_FILTER = 0;//longitude过滤条件

    public static final int LATITUDE_FILTER = 0;//latitude过滤条件

    public static final int SPEED_FILTER = 1;//speed过滤条件

    public static final int BEARING_FILTER = 0;// bearing过滤条件

    private static final Logger logger = LoggerFactory.getLogger(Constants.class);




    private Constants() {
    }
}
