package org.wzj;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_practice {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);

        //练习1
        List<Integer> collect = list.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        //练习2
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"zhangsan,23","lisi,34","xiaoliu,25");
        Map<String, Integer> collect1 = list1.stream().filter(s -> Integer.parseInt(s.split(",")[1]) > 24).collect(Collectors.toMap(
                s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1])
        ));
        System.out.println(collect1);

        Map<String, Integer> collect2 = list1.stream().filter(s -> Integer.parseInt(s.split(",")[1]) > 24).collect(Collectors.toMap(
                new Function<String, String>() {

                    @Override
                    public String apply(String s) {
                        return s.split(",")[0];
                    }
                },
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split(",")[1]);
                    }
                }
        ));
        System.out.println(collect2);//{lisi=34, xiaoliu=25}

        //练习3
        /*
        现在有两个ArrayList集合，分别存储6名男演员的名字和年龄以及6名女演员的名字和年龄。
        姓名和年龄中间用逗号隔开。
        比如:张三。23
        要求完成如不的操作:
        1.男演员只要名字为3个字的前两人
        2，女演员只要姓杨的，并且不要第一个
        3，把过滤后的男演员姓名和女演员姓名合并到一起
        4，将上一步的演员姓名封装成Actor对象。
        5，将所有的演员对象都保存到List集合中。
        备注:演员类Actor.属性有: name， age

        男演员:"蔡坤坤,24","叶购咸,23", "刘不甜,22","吴签,24","谷嘉,30", "肖梁梁, 27"
        女演员:"赵小颖,35","杨颖,36","高元元,43","张天天,31","刘诗,35","杨小幂,33"

         */
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list2,"蔡坤坤,24","叶购咸,23", "刘不甜,22","吴签,24","谷嘉,30", "肖梁梁, 27");
        Collections.addAll(list3,"赵小颖,35","杨颖,36","高元元,43","张天天,31","刘诗,35","杨小幂,33");


        System.out.println("=================");
        Stream<String> stream1 = list2.stream().filter(s -> s.split(",")[0].length() == 3).limit(2);

        System.out.println("=================");
        Stream<String> stream2 = list3.stream().filter(s -> s.split(",")[0].startsWith("杨")).skip(1);

        //String->Actor对象（类型转换）
        Stream.concat(stream1,stream2).map(new Function<String, Actor>() {

            @Override
            public Actor apply(String s) {
                //"赵丽颖，35"
                String name = s.split(",")[0];
                int age = Integer.parseInt(s.split(",")[1]);
                return new Actor(name,age);
            }
        }).forEach(System.out::println);

        System.out.println("==========");
        //Lambda简化后
        Stream.concat(stream1,stream2).map(s->new Actor(s.split(",")[0],Integer.parseInt(s.split(",")[1]))).forEach(System.out::println);
    }
}
