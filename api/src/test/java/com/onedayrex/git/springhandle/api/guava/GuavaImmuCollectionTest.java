package com.onedayrex.git.springhandle.api.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 不可变集合
 */
public class GuavaImmuCollectionTest {

    @Test
    public void ImmuCollection() {

        ImmutableList<String> immutableList = ImmutableList.copyOf(Arrays.asList("b","d","a"));
        Assert.assertEquals("b", immutableList.get(0));
        Assert.assertEquals("d", immutableList.get(1));
        Assert.assertEquals("a", immutableList.get(2));
        //自动构造时排序
        ImmutableSet<String> immutableSet = ImmutableSet.of("b","f","a","h");
        Assert.assertEquals("a", immutableSet.asList().get(0));
        Assert.assertEquals("b", immutableSet.asList().get(1));
        Assert.assertEquals("f", immutableSet.asList().get(2));
        Assert.assertEquals("h", immutableSet.asList().get(3));
    }
}
