package org.wzj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Stream_distinct_concat {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        //Collections.addAll 方法可以一次性将多个元素添加到集合中。
        Collections.addAll(list,"张无忌","张强","张翠山","王二麻子");

        ArrayList<String> list1 = new ArrayList<>();

        //Collections.addAll 方法可以一次性将多个元素添加到集合中。
        Collections.addAll(list1,"张无忌","张翠山","王二麻子");

        /*
        distinct     元素去重，依赖(hashCode和equals)方法
        concat       合并a和b两个流为一个流 a和b共同的父类数据类型（进行了数据类型提升）
         */


        list.stream().distinct().forEach(System.out::println);

        Stream.concat(list.stream(),list1.stream()).forEach(System.out::println);



    }
}