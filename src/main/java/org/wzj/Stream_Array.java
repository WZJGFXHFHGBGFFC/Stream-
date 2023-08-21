package org.wzj;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream_Array {
    public static void main(String[] args) {
        //数组 public static <T> Stream<T> stream(T[] array)  Arrays工具类中的静态方法

        //Array（数组）是Java中最基本的数据结构之一，它可以用来存储固定大小的相同类型的元素。
        //数组在创建时需要指定长度，且长度不可改变。数组可以直接访问和操作元素，具有较高的性能。
        int[] arr1={1,2,3,4,5};

        String[] arr2={"a","b","c","d"};

        Arrays.stream(arr1).forEach(System.out::println);

        System.out.println("==========");

        Arrays.stream(arr2).forEach(System.out::println);

        //不管是引用类型还是基本类型的数组都能正常打印出来
    }
}
