package org.wzj;

import java.util.ArrayList;
import java.util.Collections;

public class Stream_map {
    public static void main(String[] args) {

        /*
        注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
        注意2：修改Stream流中的数据,不会影响原来集合或者数组中的数据
         */

        ArrayList<String> list = new ArrayList<>();

        //Collections.addAll 方法可以一次性将多个元素添加到集合中。
        Collections.addAll(list,"张无忌-15","张强-23","张翠山-24","王二麻子-45");

        /*
        第一个数据类型：流中原本的数据类型
        第二个数据类型：要转成之后的类型

        apply的形参s：依次表示流里面的每一个数据
        返回值：表示转换之后的数据
         */
//        list.stream().map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                String[] arr = s.split("-");
//                String ageString = arr[1];
//                int age = Integer.parseInt(ageString);
//                return age;
//            }
//        }).forEach(System.out::println);

        list.stream().map(s->Integer.parseInt(s.split("-")[1])).forEach(System.out::println);
    }
}