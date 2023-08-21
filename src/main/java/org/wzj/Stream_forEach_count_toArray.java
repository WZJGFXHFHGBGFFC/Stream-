package org.wzj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class Stream_forEach_count_toArray {
    public static void main(String[] args) {

        /*
        注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
        注意2：修改Stream流中的数据,不会影响原来集合或者数组中的数据
         */

        ArrayList<String> list = new ArrayList<>();

        //Collections.addAll 方法可以一次性将多个元素添加到集合中。
        Collections.addAll(list,"张无忌","张强","张翠山","王二麻子");

        /*
        void forEach(Consumer action)  遍历

        Consumer的泛型类：表示流中数据的类型
        accept方法的形参s:依次表示流里面的每一个数据

        返回值：表示转换之后的数据
         */
//        list.stream().forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        list.stream().forEach(System.out::println);


        //long count()   统计
        System.out.println(list.stream().count());

        //toArray   收集流中的数据，放到数组中
        Object[] array = list.stream().toArray();
        System.out.println(Arrays.toString(array));

        /*
        IntFunction的泛型：具体类型的数组
        apply的形参：流中的数据个数，要跟数组的长度保持一致
        apply的返回值：具体类型的数组
         */

        //toArray方法的参数作用：负责创建一个指定类型的数组
        //toArray方法的底层，会依次得到流里面的每一个数据，并把数据放到数组中
        //toArray方法的返回值：是一个装着流里面所有数据的数组
        String[] array1 = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(array1));

        String[] array2 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(array2));

    }
}