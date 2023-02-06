package learn.chapter2022.chapter12.chapter1227;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-12-27 16:42
 */
public class MenuUtil {
    public static void main(String[] args) {
        List<Menu> menus = generate();
        System.out.println(JSON.toJSONString(menus, JSONWriter.Feature.PrettyFormat));
    }

    private static List<Menu> build() {
        List<Menu> menus = Lists.newArrayList(new Menu(1, 0, "用户", null),
                new Menu(2, 0, "角色", null),
                new Menu(3, 0, "公共菜单", null),
                new Menu(4, 2, "用户4", null),
                new Menu(5, 2, "用户5", null),
                new Menu(6, 3, "角色1", null),
                new Menu(7, 3, "角色2", null),
                new Menu(8, 3, "角色2-2", null));
        return menus;
    }

    private static List<Menu> generate() {
        List<Menu> allMenu = build();
        List<Menu> rootMenu = allMenu.stream().filter(m -> m.getPid() == 0).collect(Collectors.toList());
        for (Menu root : rootMenu) {
            root.setChild(getChild(allMenu,root.getId()));

        }
        return rootMenu;
    }

    private static List<Menu> getChild(List<Menu> menuList, int pid) {
        List<Menu> child = menuList.stream().filter(m -> m.getPid() == pid).collect(Collectors.toList());
        for(Menu menu : child){
            menu.setChild(getChild(menuList,menu.getId()));
        }
        return child;
    }
}
