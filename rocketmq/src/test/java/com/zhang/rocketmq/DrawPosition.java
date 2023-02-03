package com.zhang.rocketmq;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yang.sun
 * @date 2016/7/15
 */
public class DrawPosition {

    /**
     * values 值拼接
     *
     * @param withGpsBearing 是否增加GPSBearing到输出
     */
    public static String draw(Position[] poss, boolean withGpsBearing) {
        if (poss.length == 0) {
            return "|";
        }
        String gpstimeStr = "";
        String lonLatStr = "";
        String gpsBearing = "";

        for (int i = 0; i < poss.length; i++) {
            lonLatStr += poss[i].getLongitude() + "," + poss[i].getLatitude() + ",";
            gpstimeStr += poss[i].getGpstime() + ",";
            if (withGpsBearing) {
                gpsBearing += poss[i].getBearing() + ",";
            }
        }
        // 经纬度前向差分
        String diffOrbit = ForwardDiff.enLonLatDiff(lonLatStr.substring(0, lonLatStr.length() - 1))
                + "|"
                + ForwardDiff.enGpstimeDiff(gpstimeStr.substring(0, gpstimeStr.length() - 1));

        if (withGpsBearing) {
            diffOrbit += "|";
            diffOrbit += ForwardDiff.enGpsBearingDiff(gpsBearing.substring(0, gpsBearing.length() - 1));
        }
        return diffOrbit;
    }

    /**
     * values 反序列化
     *
     * @param withGpsBearing 是否增加GPSBearing到输出
     */
    public static List<Position> deDraw(String value, boolean withGpsBearing) {
        if (StringUtils.isEmpty(value)) {
            return Collections.EMPTY_LIST;
        }
        String[] segments = value.split("\\|");
        if(segments == null){
            return  Collections.EMPTY_LIST;
        }
        if(withGpsBearing && segments.length != 3){
            return Collections.EMPTY_LIST;
        }
        if(!withGpsBearing && segments.length != 2){
            return Collections.EMPTY_LIST;
        }
        String gpstimeStr = ForwardDiff.deGpstimeDiff(segments[1]);
        String lonLatStr = ForwardDiff.deLonLatDiff(segments[0]);
        String gpsBearing = null;
        String[] gpsBearingSeg = null;
        if(withGpsBearing) {
            gpsBearing = ForwardDiff.deGpsBearingDiff(segments[2]);
            gpsBearingSeg = gpsBearing.split(",");
        }
        String[] lonLatSeg = lonLatStr.split(",");
        String[] gpsTimeSeg = gpstimeStr.split(",");
        List<Position> positions = new ArrayList<>();
        if(lonLatSeg != null) {
            for (int i=0; i<lonLatSeg.length; i = i+2) {
                Position position = new Position();
                position.setLongitude(Double.parseDouble(lonLatSeg[i]));
                position.setLatitude(Double.parseDouble(lonLatSeg[i + 1]));
                position.setGpstime(Long.parseLong(gpsTimeSeg[i/2]));
                if(withGpsBearing){
                    position.setBearing(Double.parseDouble(gpsBearingSeg[i/2]));
                }
                positions.add(position);
            }
        }
        return positions;
    }
}
