package org.wzj;

import java.util.ArrayList;
import java.util.Collections;

public class Stream_filter_limit_skip {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        //Collections.addAll 方法可以一次性将多个元素添加到集合中。
        Collections.addAll(list,"张无忌","张强","张翠山","王二麻子");
//        list.add("咋顶顶顶");
//        list.add("张顶顶");
//        list.add("张是顶");
//        list.add("吃顿饭");
//        list.add("地方");
//        list.add("八十五");

        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);

        /*
        limit        获取前面几个元素
        skip         跳过前几个元素
        list.stream().limit(3).skip(1).forEach(System.out::println);//张强 张翠山
         */

        /*
        distinct     元素去重，依赖(hashCode和equals)方法
        concat       合并a和b两个流为一个流 a和b共同的父类数据类型（进行了数据类型提升）
         */


        list.stream().distinct().forEach(System.out::println);



    }
}