package org.wzj;

import java.util.ArrayList;

public class Stream_ArrayList {
    public static void main(String[] args) {

        //单列集合         default Stream<E> stream()                    collection中的默认方法
        //ArrayList（数组列表）是基于数组实现的动态数组，它可以在运行时自动调整大小。ArrayList可以存储任意类型的对象，
        //而不仅限于相同类型的元素。ArrayList提供了丰富的方法和功能，例如添加、删除、查找、排序等操作，更加灵活方便。
        ArrayList<String> list = new ArrayList<>();
        list.add("咋顶顶顶");
        list.add("张顶顶");
        list.add("张是顶");
        list.add("吃顿饭");
        list.add("地方");
        list.add("八十五");
        System.out.println(list);//[咋顶顶顶, 张顶顶, 张是顶, 吃顿饭, 地方, 八十五]

        list.stream().filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(System.out::println);
    }
}