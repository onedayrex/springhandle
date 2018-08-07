package com.onedayrex.git.springhandle.api.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GuavaStringTest {

    @Test
    public void splitterTest() {
        Iterable<String> split = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .split(",a,b  ,c,,, que");
        List<String> stringList = Lists.newArrayList(split);
        Assert.assertArrayEquals(new String[]{"a", "b", "c", "que"}, stringList.toArray());
    }

    @Test
    public void charMacherTest() {
        String s = CharMatcher.JAVA_DIGIT.removeFrom("sdfllwo2234,556aad1223");
        System.out.println(s);
    }
}
