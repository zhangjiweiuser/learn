package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe;

public interface IMenu {

    IMenu appendCeiling(Matter matter);

    IMenu appendCoat(Matter matter);

    IMenu appendFloor(Matter matter);

    IMenu appendTile(Matter matter);

    String getDetail();
}
