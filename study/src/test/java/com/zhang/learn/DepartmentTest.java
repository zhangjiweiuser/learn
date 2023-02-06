package com.zhang.learn;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/9 14:34
 */
public class DepartmentTest {

    private static List<Department> list = Lists.newArrayList();

    public static void main(String[] args) {
        DepartmentTest test = new DepartmentTest();
        test.init();
        Tree tree = test.generate(list);
        System.out.println(JSON.toJSONString(tree, JSONWriter.Feature.PrettyFormat));
    }

    private void init() {
        list.add(new Department(1, "集团", 0));
        list.add(new Department(2, "行政部", 1));
        list.add(new Department(3, "行政文员1", 2));
        list.add(new Department(4, "行政文员2", 2));
        list.add(new Department(5, "行政文员3", 2));
        list.add(new Department(6, "技术部", 1));
        list.add(new Department(7, "后台技术", 6));
        list.add(new Department(8, "前端技术", 6));
        list.add(new Department(9, "测试", 6));
        list.add(new Department(10, "运维", 6));
        list.add(new Department(11, "运维助理", 10));
    }

    private Tree generate(List<Department> departmentList) {
        Department parent = departmentList.stream().filter(d -> d.getPid() == 0).findFirst().orElse(null);
        if (null == parent) {
            return null;
        }
        Tree tree = buildTree(departmentList, parent);
        return tree;
    }

    private Tree buildTree(List<Department> departmentList, Department parent) {
        Tree tree = new Tree();
        tree.setId(parent.getId());
        tree.setName(parent.getName());
        tree.setPid(parent.getPid());
        List<Department> childDepartmentList = departmentList.stream().filter(d -> d.getPid() == parent.getId()).collect(Collectors.toList());
        List<Tree> childTree = new ArrayList<>();
        for (Department d : childDepartmentList) {
            childTree.add(buildTree(departmentList, d));
        }
        tree.setChild(childTree);
        return tree;
    }

    @Data
    @AllArgsConstructor
    private static class Department {
        private int id;
        private String name;
        private int pid;
    }

    @Data
    private static class Tree {
        private int id;
        private String name;
        private int pid;
        List<Tree> child;
    }
}


