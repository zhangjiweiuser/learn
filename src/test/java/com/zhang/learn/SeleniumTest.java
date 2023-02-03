package com.zhang.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/22 18:21
 */
public class SeleniumTest {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        WebDriver driver  = new ChromeDriver();
        driver.get("https://uland.taobao.com/taolijin/edetail?vegasCode=X7F4DKVI&type=qtz&union_lens=lensId%3A21076e08_09a0_1772e8fd43b_49bf%3Btraffic_flag%3Dlm");


        String source = driver.getPageSource();
        System.out.println(source);
//        WebElement searchBox = driver.findElement(By.id("kw"));
//        searchBox.sendKeys("小坦克 博客园");
//        WebElement searchButton = driver.findElement(By.id("su"));
//        searchButton.submit();

        driver.close();
    }
}
