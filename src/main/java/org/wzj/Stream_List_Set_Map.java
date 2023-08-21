package org.wzj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream_List_Set_Map {
    public static void main(String[] args) {

        /*
        注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
        注意2：修改Stream流中的数据,不会影响原来集合或者数组中的数据
         */

        ArrayList<String> list = new ArrayList<>();

        //Collections.addAll 方法可以一次性将多个元素添加到集合中。
        Collections.addAll(list,"张无忌-男-15","张强-男-23","张翠山-女-24","王二麻子-男-45");

        /*
        收集List集合当中
        需求：把所有男性收集起来
         */
        List<String> collect = list.stream().filter(s -> s.split("-")[1].equals("男")).collect(Collectors.toList());
        collect.forEach(System.out::println);
        /*
        收集Set集合当中
        需求：把所有男性收集起来
        结果：会进行去重
         */
        list.stream().filter(s->s.split("-")[1].equals("男")).collect(Collectors.toSet());
        /*
        收集Map集合当中
        需求：把所有男性收集起来

        toMap:参数一表示键的生成规则
              参数二表示值的生成规则
         */
        list.stream().filter(s->s.split("-")[1].equals("男")).collect(Collectors.toMap(
                /*
                参数一：
                    Function泛型一：表示流中的每一个数据类型
                    方法体：生成键的代码
                    返回值：已经生成的键

                    方法apply形参：依次表示流中的每一个数据
                    方法体生成键的代码
                    返回值：已经生成的键
                 */
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }
        ));

        //key是不能重复的，否正报错
        //Lambda表达式
        Map<String, String> map = list.stream().filter(s -> s.split("-")[1].equals("男")).collect(Collectors.toMap(
                s -> s.split("-")[0],
                s -> s.split("-")[2]
        ));
        System.out.println(map);//{张强=23, 王二麻子=45, 张无忌=15}

    }
}