package com.zhang.rocketmq;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/4 15:42
 */
@Slf4j
public class LocalTest {

    @Test
    void test() {
        LocalDate d1 = LocalDate.of(2020, 5, 1);
        LocalDate d2 = LocalDate.of(2020, 5, 10);
        System.out.println(d1.toEpochDay() - d2.toEpochDay());
        System.out.println(d1.until(d2, ChronoUnit.DAYS));
        String name = "张三往";
        name = StringUtils.rightPad(StringUtils.left(name, 1), StringUtils.length(name), "*");
        System.out.println(name);
    }

    @Test
    void test2() {
        String slon = "116.313282";
        String slat = "39.979531";
        String dlon = "116.319522";
        String dlat = "39.969685";
        JSONObject result = pathRoute(slon, slat, dlon, dlat);
        System.out.println(JSONObject.toJSONString(result));
    }

    @Test
    void test3() {
        String s1 = "116.312687,39.97928;116.312591,39.979258";
        String s2 = "116.312591,39.979258;116.312595,39.979245;116.312799,39.978746";
        String s3 = "116.312821,39.978672;116.313446,39.978655;116.314002,39.978672;116.315178,39.978711;116.316089,39.978746;116.316571,39.978759";
        String s4 = "116.316675,39.978763;116.316723,39.978511;116.316801,39.978212;116.316931,39.977756;116.317027,39.977422;116.317096,39.977187;116.317431,39.976042;116.317457,39.975964;116.318047,39.974575;116.318338,39.973893;116.31855,39.973372;116.318906,39.972539;116.319566,39.970924;116.31987,39.970156;116.32003,39.969735";
        String s5 = "116.32003,39.969735;116.319523,39.969679";
        String result = s1 + ";" + s2 + ";" + s3 + ";" + s4 + ";" + s5;
        // distance:1467
        //duration:331
        String[] arr = result.split(";");
        System.out.println(arr.length);
        int length = arr.length;
        int duration = 331;
        int num = duration / length;
        int yu = duration % length;
        LocalDateTime localDateTime = LocalDateTime.parse("2021-06-25 15:57:26", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocationData data = new LocationData();
        data.setOid("2106259174338560");
        data.setChannelId(3);
        data.setOrderId("430358302000");
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < length; i++) {

            String[] pos = arr[i].split(",");
            double latitude = Double.valueOf(pos[1]);
            double longitude = Double.valueOf(pos[0]);

            Position position = new Position(longitude, latitude);


            if (i == length - 1) {
                localDateTime = localDateTime.plusSeconds(num + yu);

            } else {

                localDateTime = localDateTime.plusSeconds(num);
            }
            position.setGpstime(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
            positions.add(position);
            System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        // 2021-06-25 15:57:26
        data.setPositionList(positions);
        System.out.println(JSONObject.toJSONString(positions));
        process2(data);
    }

    @Test
    void test4() {
        String s1 = "116.312687,39.97928;116.312591,39.979258";
        String s2 = "116.312591,39.979258;116.312595,39.979245;116.312799,39.978746";
        String s3 = "116.312821,39.978672;116.313446,39.978655;116.314002,39.978672;116.315178,39.978711;116.316089,39.978746;116.316571,39.978759";
        String s4 = "116.316675,39.978763;116.316723,39.978511;116.316801,39.978212;116.316931,39.977756;116.317027,39.977422;116.317096,39.977187;116.317431,39.976042;116.317457,39.975964;116.318047,39.974575;116.318338,39.973893;116.31855,39.973372;116.318906,39.972539;116.319566,39.970924;116.31987,39.970156;116.32003,39.969735";
        String s5 = "116.32003,39.969735;116.319523,39.969679";
        String result = s1 + ";" + s2 + ";" + s3 + ";" + s4 + ";" + s5;
        String[] arr = result.split(";");
        List<String> pois = Arrays.asList(arr);
        String[] res = new String[pois.size()];
        for (int i = pois.size() - 1; i > 0; i--) {
            String[] second = pois.get(i).split(",");
            String[] first = pois.get(i-1).split(",");
            BigDecimal lon = new BigDecimal(second[0]).subtract(new BigDecimal(first[0])).multiply(new BigDecimal("1000000"));
            BigDecimal lat = new BigDecimal(second[1]).subtract(new BigDecimal(first[1])).multiply(new BigDecimal("1000000"));
            res[i] = lon.stripTrailingZeros().toPlainString()+","+lat.stripTrailingZeros().toPlainString();
        }
        res[0] = pois.get(0);
        System.out.println(Arrays.toString(res));

        String chafen = Joiner.on(";").join(res);
        System.out.println(chafen);
        String[] chafenre = chafen.split(";");
        String[] huifu = new String[chafenre.length];
        huifu[0] = chafenre[0];
        BigDecimal baseLon = new BigDecimal(huifu[0].split(",")[0]);
        BigDecimal baseLat = new BigDecimal(huifu[0].split(",")[1]);
        for(int i=1;i<chafenre.length;i++){
            String a = chafenre[i];
            String[] aa = a.split(",");
            BigDecimal cflon = new BigDecimal(aa[0]).divide(new BigDecimal("1000000"));
            BigDecimal cflat = new BigDecimal(aa[1]).divide(new BigDecimal("1000000"));
            baseLon = baseLon.add(cflon);
            baseLat = baseLat.add(cflat);
            huifu[i] = baseLon+","+baseLat;
        }
        System.out.println(Arrays.toString(huifu));
    }

    public void process2(LocationData locationData) {
        StringBuilder sb = new StringBuilder("1###");
        sb.append(locationData.getOid()).append("%");
        for (Position position : locationData.getPositionList()) {
            sb.append(position.getLongitude()).append(",").append(position.getLatitude()).append("|").append(position.getGpstime()).append("|0.0_").append(position.getGpstime()).append(";");
        }
        String result = sb.deleteCharAt(sb.length() - 1).toString();
        System.out.println(result);
    }

    public void process(LocationData locationData) {
        long l1 = System.currentTimeMillis();

        String oid = locationData.getOid();
        if (StringUtils.isEmpty(oid)) {
            log.debug("realTime orbit processor oid is null, return !");
            return;
        }
        log.info("orbit process locationData:{}", locationData);

        List<Position> poss = locationData.getPositionList();
        if (org.apache.commons.collections.CollectionUtils.isEmpty(poss)) {
            log.info("poss=null");
            return;
        }

        //浅拷贝
        List<Position> possT = new ArrayList<>(poss);

//        Position temp;
//        for(Iterator<Position> it = possT.iterator(); it.hasNext();){
//            temp = it.next();
////            if(temp.getSpeed()==null || temp.getAccuracy()==null|| (temp.getAccuracy() != null && temp.getAccuracy() >500) || temp.getBearing() == null){
////                it.remove();
////            }
//        }
        if (CollectionUtils.isEmpty(possT)) {

            return;
        }
        Collections.sort(possT);

        Position first = possT.get(0);
        if (first.getGpstime() == null) {
            first.setGpstime(0L);
        }
        long gpstime = first.getGpstime();
        String newValue;
        /*
         * VALUE1:前向差分轨迹数据、前向差分时间戳数据、前向差分Gps偏向角数据、 数据时间戳
         * VALUE2:前向差分轨迹数据、前向差分时间戳数据、前向差分Gps偏向角数据、 数据时间戳
         * VALUE1;VALUE2;VALUE3
         */

        newValue = DrawPosition.draw(possT.toArray(new Position[possT.size()]), true);
        System.out.println("newValue:" + newValue);
        // 返回串：lon1,lat1,lon2,lat2,lon3,lat3|gpstime1,gpstime2,gpstime3|gpsBearing1,gpsBearing2,gpsBearing3
        // 116.432968,39.920101|1582544854125|16.0

        if (StringUtils.isBlank(newValue)) {
            return;
        }
//        newValue = newValue +  "_" + locationData.getChannelId()+ "_" + locationData.getOrderId() + "_" + gpstime;

        try {
//            String key = RedisKeyConstant.PREFIX_ORBIT + oid;
//            String oldValue = stringRedisTemplate.boundValueOps(key).get();
            String oldValue = "";
            if (StringUtils.isNotBlank(oldValue) && !oldValue.startsWith("1###")) { // 老版本
                newValue = newValue + "_" + locationData.getChannelId() + "_" + locationData.getOrderId() + "_" + gpstime;
            } else { // 新版本
                newValue = newValue + "_" + gpstime;
            }
            log.info("test log: save orbit value oid:{}, add value:{}", oid, newValue);
            if (StringUtils.isBlank(oldValue)) {
                oldValue = "1###" + locationData.getOid() + "%" + newValue;
//                stringRedisTemplate.boundValueOps(key).set(oldValue, 30, TimeUnit.DAYS);
            } else if (StringUtils.isNotBlank(oldValue) && !oldValue.endsWith(newValue)) {
                newValue = oldValue + ";" + newValue;
//                stringRedisTemplate.boundValueOps(key).set(newValue, 30, TimeUnit.DAYS);
            }
            System.out.println("oldValue:" + oldValue);
            System.out.println("newValue:" + newValue);
        } catch (Exception e) {

        }
//        newValue = newValue +  "_"  + gpstime;
//        newValue = "1###" + locationData.getOid() + "%" + newValue;


    }

    public JSONObject pathRoute(String slon, String slat, String dlon, String dlat) {
        String gaodeKey = "bf747ba0a9225442bef9863b19e58b9e";

        String gaodeRouteUrl = "https://restapi.amap.com/v3/direction/driving";
        JSONObject json = new JSONObject(true);
        json.put("returncode", 1);
        json.put("message", "请求失败");
        json.put("distance", 0);
        json.put("duration", 0);

        try {
            slon = truncate(slon);
            slat = truncate(slat);
            dlon = truncate(dlon);
            dlat = truncate(dlat);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("key", gaodeKey);
            paramMap.put("origin", slon + "," + slat);
            paramMap.put("destination", dlon + "," + dlat);
            paramMap.put("output", "JSON");
//            paramMap.put("extensions", "base");
//            paramMap.put("strategy", 5);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            String param = sb.deleteCharAt(sb.length() - 1).toString();
            System.out.println(param);
            RestTemplate template = new RestTemplate();
            String result = template.getForObject(gaodeRouteUrl + "?" + param, String.class);
//            log.info("路径规划返回结果: {}", result);
            if (null == result) {
                return json;
            }

            JSONObject jsonObject = JSONObject.parseObject(result);
            int status = jsonObject.getIntValue("status");
            if (0 == status) {
                json.put("message", jsonObject.getString("info"));
                return json;
            } else {
                JSONObject route = jsonObject.getJSONObject("route");
                JSONArray paths = route.getJSONArray("paths");
                if (paths.size() > 0) {
                    JSONObject jo = paths.getJSONObject(0);
                    System.out.println("distance:" + jo.getString("distance"));
                    System.out.println("duration:" + jo.getString("duration"));
                    JSONArray arrar = jo.getJSONArray("steps");
                    for (int i = 0; i < arrar.size(); i++) {
                        System.out.println(arrar.getJSONObject(i).toJSONString());
                        System.out.println(arrar.getJSONObject(i).getString("polyline"));
                    }
                    return json;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    private String truncate(String str) {
        String[] parts = str.split("\\.");
        if (parts[1].length() > 6) {
            parts[1] = parts[1].substring(0, 6);
        }

        return parts[0] + "." + parts[1];
    }
}
