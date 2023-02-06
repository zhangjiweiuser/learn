package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe;

import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.ceiling.LevelOneCeiling;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.ceiling.LevelTwoCeiling;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.coat.DuluxCoat;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.coat.LiBangCoat;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.floor.ShengXiangFloor;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.tile.DongPengTile;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.tile.MarcoPoloTile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 17:31
 */
public class DecorationPackageController {
    public String getMatterList(BigDecimal area,Integer level){
        List<Matter> list = new ArrayList<>();
        BigDecimal price = BigDecimal.ZERO;
        // 豪华欧式
        if(1 == level){
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            DuluxCoat duluxCoat = new DuluxCoat();
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor();
            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);
            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengXiangFloor.price()));
        }
        // 轻奢田园
        if (2 == level) {

            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling(); // 吊顶，二级顶
            LiBangCoat liBangCoat = new LiBangCoat();                // 涂料，立邦
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();       // 地砖，马可波罗

            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));

        }

        // 现代简约
        if (3 == level) {

            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();  // 吊顶，二级顶
            LiBangCoat liBangCoat = new LiBangCoat();                 // 涂料，立邦
            DongPengTile dongPengTile = new DongPengTile();           // 地砖，东鹏

            list.add(levelOneCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }
}

