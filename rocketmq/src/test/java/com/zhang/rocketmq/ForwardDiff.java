package com.zhang.rocketmq;


/**
 * @author yang.sun
 * @date 2016/7/15
 */
public class ForwardDiff {

    public static String enGpsBearingDiff(String gpsBearing) {
        if (null == gpsBearing || "".equals(gpsBearing)) {
            return "";
        }
        String[] str = gpsBearing.split(",");
        String result = "";
        double[] bearings = new double[str.length];
        for (int i = 0; i < bearings.length; i++) {
            bearings[i] = Double.parseDouble(str[i]);
        }

        for (int i = bearings.length - 1; i > 0; i--) {
            bearings[i] = (int) ((bearings[i] - bearings[i - 1]) * Constants.DIVISOR);
        }

        for (int i = 0; i < bearings.length; i++) {
            result += bearings[i] + ",";
        }

        return result.substring(0, result.length() - 1);

    }

    public static String deGpsBearingDiff(String gpsBearing) {
        if (null == gpsBearing || "".equals(gpsBearing)) {
            return "";
        }

        String[] str = gpsBearing.split(",");
        String result = "";
        double[] bearings = new double[str.length];

        for (int i = 0; i < bearings.length; i++) {
            bearings[i] = Double.parseDouble(str[i]);
        }

        for (int i = 1; i < bearings.length; i++) {
            bearings[i] = bearings[i - 1] + bearings[i] / Constants.DIVISOR;
        }

        for (int i = 0; i < bearings.length; i++) {
            result += bearings[i] + ",";
        }

        return result.substring(0, result.length() - 1);
    }


    public static String enGpstimeDiff(String gpstime) {
        if (null == gpstime || "".equals(gpstime)) {
            return "";
        }

        String[] str = gpstime.split(",");
        String result = "";
        long[] coors = new long[str.length];

        for (int i = 0; i < coors.length; i++) {
            coors[i] = Long.parseLong(str[i]);
        }

        for (int i = coors.length - 1; i > 0; i--) {
            coors[i] = coors[i] - coors[i - 1];
        }

        for (int i = 0; i < coors.length; i++) {
            result += coors[i] + ",";
        }

        return result.substring(0, result.length() - 1);
    }

    public static String deGpstimeDiff(String gpstime) {
        if (null == gpstime || "".equals(gpstime)) {
            return "";
        }

        String[] str = gpstime.split(",");
        String result = "";
        long[] coors = new long[str.length];

        for (int i = 0; i < coors.length; i++) {
            coors[i] = Long.parseLong(str[i]);
        }

        for (int i = 1; i < coors.length; i++) {
            coors[i] = coors[i - 1] + coors[i];
        }

        for (int i = 0; i < coors.length; i++) {
            result += coors[i] + ",";
        }

        return result.substring(0, result.length() - 1);
    }

    public static String enLonLatDiff(String lonLatCluster) {
        if (null == lonLatCluster || "".equals(lonLatCluster)) {
            return "";
        }

        String[] str = lonLatCluster.split(",");
        String result = "";
        double[] coors = new double[str.length];

        for (int i = 0; i < coors.length; i++) {
            coors[i] = Double.parseDouble(str[i]);
        }

        for (int i = coors.length - 1; i > 1; i--) {
            coors[i] = (int) ((coors[i] - coors[i - 2]) * Constants.DIVISOR);
        }

        for (int i = 0; i < coors.length; i++) {
            result += coors[i] + ",";
        }

        return result.substring(0, result.length() - 1);
    }

    public static String deLonLatDiff(String lonLatCluster) {
        if (null == lonLatCluster || "".equals(lonLatCluster)) {
            return "";
        }

        String[] str = lonLatCluster.split(",");
        String result = "";
        double[] coors = new double[str.length];

        for (int i = 0; i < coors.length; i++) {
            coors[i] = Double.parseDouble(str[i]);
        }

        for (int i = 2; i < coors.length; i++) {
            coors[i] = coors[i - 2] + coors[i] / Constants.DIVISOR;
        }

        for (int i = 0; i < coors.length; i++) {
            result += coors[i] + ",";
        }

        return result.substring(0, result.length() - 1);
    }
}
