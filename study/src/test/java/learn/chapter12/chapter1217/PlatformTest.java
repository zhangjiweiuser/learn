package learn.chapter12.chapter1217;

import com.google.common.collect.Lists;
import com.zhang.learn.chapter2021.chapter12.chapter1217.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/17 10:13
 */
public class PlatformTest {
    private final List<Platform> platformList = Lists.newArrayList();

    @BeforeEach
    public void init() {
        Platform platform0 = new Platform("1", "001", "0", "集团");
        Platform platform1 = new Platform("2", "QYPT001", "1", "销委会");
        Platform platform2 = new Platform("3", "QYPT002", "2", "吉龙大区");
        Platform platform3 = new Platform("4", "QYPT003", "2", "江苏大区");
        Platform platform4 = new Platform("5", "QYPT004", "4", "南京分区");

        Platform platform5 = new Platform("6", "QYPT005", "1", "教育BG");
        Platform platform6 = new Platform("7", "QYPT006", "6", "华南大区");
        Platform platform7 = new Platform("8", "QYPT007", "6", "华东大区");
        Platform platform8 = new Platform("9", "QYPT008", "8", "华东大区分区");

        platformList.add(platform0);
        platformList.add(platform1);
        platformList.add(platform2);
        platformList.add(platform3);
        platformList.add(platform4);
        platformList.add(platform5);
        platformList.add(platform6);
        platformList.add(platform7);
        platformList.add(platform8);
    }

    @Test
    void test1() {
        System.out.println(platformList.size());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
        List<Platform> result = Lists.newArrayList();
        for (Platform platform : platformList) {
            if ("0".equals(platform.getParentId())) {
                result.add(platform);
            }
            for (Platform child : platformList) {
                if (child.getParentId().equals(platform.getId())) {
                    platform.addChild(child);
                }
            }
        }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
//        System.out.println(JSONObject.toJSONString(result, SerializerFeature.PrettyFormat));
    }

    @Test
    public void test4() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Map<String, List<Platform>> groupMap = platformList.stream().collect(Collectors.groupingBy(Platform::getParentId));

//        System.out.println(JSONObject.toJSONString(groupMap, SerializerFeature.PrettyFormat));

            platformList.forEach(platform -> platform.setChildren(groupMap.get(platform.getId())));
            Platform collect = platformList.stream()
                    .filter(platform -> platform.getParentId().equals("0")).findFirst().orElse(new Platform("1", "001", "0", "集团"));
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
//        System.out.println(JSONObject.toJSONString(collect, SerializerFeature.PrettyFormat));
    }

    @Test
    public void test5() {
//        Map<String, List<Platform>> groupMap = platformList.stream().collect(Collectors.groupingBy(Platform::getParentId));

//        System.out.println(JSONObject.toJSONString(groupMap, SerializerFeature.PrettyFormat));
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Platform root = platformList.stream().filter(platform -> platform.getParentId().equals("0")).findFirst().orElse(new Platform("1", "001", "0", "集团"));

            setChild(root);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));


//        platformList.forEach(platform -> platform.setChildren(groupMap.get(platform.getId())));
//        Platform collect = platformList.stream()
//                .filter(platform -> platform.getParentId().equals("0")).findFirst().orElse(new Platform("1", "001", "0", "集团"));
//        System.out.println(JSONObject.toJSONString(root, SerializerFeature.PrettyFormat));
    }

    private void setChild(Platform root) {
        List<Platform> child = platformList.stream().filter(platform -> platform.getParentId().equals(root.getId())).collect(Collectors.toList());
        if (child.size() > 0) {
            root.setChildren(child);
        }
        for (Platform platform : child) {
            setChild(platform);
        }

    }
}
