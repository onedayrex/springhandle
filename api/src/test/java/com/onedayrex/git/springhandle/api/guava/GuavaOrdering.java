package com.onedayrex.git.springhandle.api.guava;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 排序列表 有自己实现的默认比较器 按数字、日期、字符
 * 也可以在构造函数中自定义
 */
public class GuavaOrdering {

    @Test
    public void ordering() {
        List<String> stringList = Arrays.asList("credit", "app", "name");
        Ordering<String> explicit = Ordering.natural();
        Collections.sort(stringList, explicit);
        Assert.assertArrayEquals(stringList.toArray(),new String[]{"app", "credit", "name"});
    }
}
