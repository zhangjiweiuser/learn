package com.zhang.rocketmq;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePosition implements Serializable {

    private Double longitude;

    private Double latitude;

    public BasePosition() {
    }

    public BasePosition(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double distance(BasePosition other) {
        return getDistance(other.longitude, other.latitude);
    }

    public double getDistance(double longitude, double latitude) {
        double Ec = Constants.RJ + (Constants.RC - Constants.RJ) * (90.0 - this.latitude) / 90.0;
        double thisRLatitude = this.latitude * Constants.PI / 180.0;
        double Ed = Ec * Math.cos(thisRLatitude);
        double dx = ((longitude * Constants.PI / 180.0) - (this.longitude * Constants.PI / 180.0)) * Ed;
        double dy = ((latitude * Constants.PI / 180.0) - thisRLatitude) * Ec;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
