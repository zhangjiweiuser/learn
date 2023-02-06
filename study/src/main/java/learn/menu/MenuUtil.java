package learn.menu;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 16:16
 */
public class MenuUtil {
    public static void main(String[] args) {

        List<Menu> menuList = generateMenu();
        List<Menu> firstMenu = menuList.stream().filter(m -> m.getParentId() == 0).sorted(Comparator.comparing(Menu::getMenuOrder)).collect(Collectors.toList());
        List<Menu> result = Lists.newArrayList();
        for (Menu menu : firstMenu) {
            generateChildMenu(menu, menuList);
            result.add(menu);
        }
        System.out.println(JSONObject.toJSONString(result, JSONWriter.Feature.PrettyFormat));
    }

    private static void generateChildMenu(Menu menu, List<Menu> menuList) {
        List<Menu> childMenu = menuList.stream().filter(m -> m.getParentId() == menu.getId()).sorted(Comparator.comparing(Menu::getMenuOrder)).collect(Collectors.toList());
        if (childMenu.size() > 0) {
            menu.setChild(childMenu);
        }
        for (Menu child : childMenu) {
            generateChildMenu(child, menuList);
        }
    }

    private static List<Menu> generateMenu() {
        List<Menu> menuList = Lists.newArrayList();

        Menu menu = new Menu(1, "用户管理", 1, "", 0, 1, null);
        Menu menu2 = new Menu(2, "用户新增", 2, "http://www.baidu.com", 1, 1, null);
        Menu menu3 = new Menu(3, "用户删除", 2, "http://www.baidu.com", 1, 2, null);
        Menu menu4 = new Menu(4, "用户修改", 2, "http://www.baidu.com", 1, 3, null);
        Menu menu5 = new Menu(5, "用户查询", 2, "http://www.baidu.com", 1, 4, null);

        menuList.add(menu);
        menuList.add(menu2);
//        menuList.add(menu3);
//        menuList.add(menu4);
//        menuList.add(menu5);

        Menu role = new Menu(6, "角色管理", 1, "", 0, 2, null);
        Menu role2 = new Menu(7, "角色新增", 2, "http://www.baidu.com", 6, 1, null);
        Menu role3 = new Menu(8, "角色删除", 2, "http://www.baidu.com", 6, 2, null);
        Menu role4 = new Menu(9, "角色修改", 2, "http://www.baidu.com", 6, 3, null);
        Menu role5 = new Menu(10, "角色查询", 2, "http://www.baidu.com", 6, 4, null);

        menuList.add(role);
        menuList.add(role2);
//        menuList.add(role3);
//        menuList.add(role4);
//        menuList.add(role5);

        Menu ad = new Menu(11, "广告管理", 1, "", 0, 0, null);
        Menu ad2 = new Menu(12, "广告新增", 2, "http://www.baidu.com", 11, 1, null);
        Menu ad3 = new Menu(13, "广告删除", 2, "", 11, 2, null);
        menuList.add(ad);
//        menuList.add(ad2);
        menuList.add(ad3);

        Menu adChild = new Menu(14, "小广告管理", 2, "http://www.baidu.com", 13, 1, null);
        Menu adChild2 = new Menu(15, "小广告新增", 2, "http://www.baidu.com", 13, 2, null);
        Menu adChild3 = new Menu(16, "小广告删除", 2, "http://www.baidu.com", 13, 3, null);

        menuList.add(adChild);
        menuList.add(adChild2);
        menuList.add(adChild3);
        return menuList;
    }
}
