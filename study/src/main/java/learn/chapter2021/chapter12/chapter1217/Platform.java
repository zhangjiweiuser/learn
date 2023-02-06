package learn.chapter2021.chapter12.chapter1217;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/17 10:09
 */
@Data
public class Platform {
    private String id;
    private String parentId;
    private String name;
    private String platformCode;
    private List<Platform> children;

    public Platform(String id, String platformCode, String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.platformCode = platformCode;
    }

    public void addChild(Platform platform) {
        if (null == children) {
            children = new ArrayList<>();
        }
        children.add(platform);
    }
}
