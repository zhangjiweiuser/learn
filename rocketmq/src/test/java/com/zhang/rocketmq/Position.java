package com.zhang.rocketmq;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class Position extends BasePosition implements Comparable<Position> {

    private String phone;

    private Double altitude;

    private Double speed;

    private Double accuracy;

    private Long gpstime = 0L;

    private Double bearing = 0.0;

    private Integer provider;

    private Long buildtime;

    private Double distance;

    public Position() {
        super();
    }

    public Position(Double longitude, Double latitude) {
        super(longitude, latitude);
    }




    public Double speed(Position other) {
        Long timeSpan = other.gpstime - this.gpstime;
        return (distance(other) + 1) / (timeSpan + 1);
    }

    // 通过gpstime进行比较排序
    @Override
    public int compareTo(Position other) {
        if (this.gpstime > other.gpstime) {
            return 1;
        } else if (this.gpstime < other.gpstime) {
            return -1;
        } else {
            return 0;
        }
    }
}
