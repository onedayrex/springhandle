package com.onedayrex.git.springhandle.api.guava;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTest {

    /**
     * 使用外部迭代方式，需要用到中间变量temp，然后使用forEach来打印
     */
    @Test
    public void traditionIterator() {
        List<String> lists = Lists.newArrayList("are", "where", "advance", "anvato", "java", "abc");
        List<String> temp = new ArrayList<>();
        for (String list : lists) {
            if (list.startsWith("a")) {
                temp.add(list);
            }
        }
        temp.sort(Comparator.naturalOrder());
        temp.forEach(System.out::println);
    }

    @Test
    public void streamIterator() {
        List<String> lists = Lists.newArrayList("are", "where", "advance", "anvato", "java", "abc");
        lists.stream().filter(sa->sa.startsWith("a")).sorted(Comparator.naturalOrder()).collect(Collectors.toList()).forEach(System.out::println);
    }
}
