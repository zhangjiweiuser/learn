package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe;

import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.ceiling.LevelOneCeiling;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.ceiling.LevelTwoCeiling;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.coat.DuluxCoat;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.coat.LiBangCoat;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.floor.ShengXiangFloor;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.tile.DongPengTile;
import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.tile.MarcoPoloTile;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 17:43
 */
public class Builder {
    public IMenu levelOne(Double area){
        return new DecorationPackageMenu(area,"豪华欧式")
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }
    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }
}
