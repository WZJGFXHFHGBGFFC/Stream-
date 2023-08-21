package org.wzj;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream_Array02 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};

        String[] arr2={"a","b","c","d"};
        /*
        注意：
        Stream接口中的静态方法of的细节
        方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组
        但是数组必须是引用类型的，如果传递的是基本数据类型，是会把整个数组当作一个元素，放到Stream当中
         */
        Stream.of(arr1).forEach(System.out::println);//[I@404b9385
        Stream.of(1,2,3,4,5).forEach(System.out::println);
        /*
        1
        2
        3
        4
        5
         */
        Stream.of("a","b","c",4).forEach(System.out::println);
        Stream.of(arr2).forEach(System.out::println);

    }
}
