package org.wzj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Stream_ArrayList_plus {
    public static void main(String[] args) {
        /*
        单列集合         default Stream<E> stream()                    collection中的默认方法
        双列集合         无                                            无法直接使用stream流
        数组            public static<T> Stream<T> of(T[] array)      Arrays工具类中的静态方法
        一堆零散数据      public static<T> Stream<T> of(T... values)    Stream接口中的静态方法
         */

        //1.单列集合获取Stream流
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c","d");

        // 双列集合         无                                            无法直接使用stream流

        //创建双列集合
        HashMap<String, Integer> hashMap = new HashMap<>();
        //添加数据
        hashMap.put("aaa",111);
        hashMap.put("bbb",222);
        hashMap.put("ccc",333);

        //获取Stream流
        //keySet获取的是所有的键
        hashMap.keySet().stream().forEach(System.out::println);
        System.out.println(hashMap.keySet());//[aaa, ccc, bbb]

        //第二种获取stream流
        //entrySet获取所有的键值对对象
        hashMap.entrySet().forEach(System.out::println);
        System.out.println(hashMap.entrySet());//[aaa=111, ccc=333, bbb=222]


    }
}
