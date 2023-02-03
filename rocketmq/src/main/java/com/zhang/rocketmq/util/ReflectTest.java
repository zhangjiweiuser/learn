package com.zhang.rocketmq.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-12-21 10:29
 */
public class ReflectTest {
    public static void main(String[] args) throws IntrospectionException {
        getAll();
    }

    private static void getAll() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Role.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            System.out.println(property.getName() + "--" + property.getDisplayName() + "--" + property.getReadMethod() + "--" + property.getWriteMethod());
        }


//        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
//        for (MethodDescriptor method : methodDescriptors) {
//            System.out.println(method.getMethod() + "--" + method.getDisplayName() + "--" + method.getShortDescription());
//        }
    }
}
