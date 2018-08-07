package com.onedayrex.git.springhandle.api.guava;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class GuavaTest {
    private static final Logger logger = LoggerFactory.getLogger(GuavaTest.class);

    @Test
    public void optional() {
        Optional<Integer> optional = Optional.of(5);
        //返回值不为null 则为true
        boolean present = optional.isPresent();
        Assert.assertTrue(present);
        logger.info(optional.toString());
    }

    @Test
    public void preCondition() {
        int i = 5;
        Preconditions.checkArgument(i > 4, "number %s less 5", i);
        Preconditions.checkNotNull("");
    }

    @Test
    public void objectTest() {
        //equal
        Assert.assertTrue(Objects.equal("a", "a"));
        Assert.assertFalse(Objects.equal(null, "a"));
        Assert.assertTrue(Objects.equal(null, null));

        //hashcode
        int i = Objects.hashCode(1, 5, 8);
        Assert.assertEquals(30915, i);

    }

    @Test
    public void comparisonChain() {
        //比较链，如果有不相等的直接返回
        int result = ComparisonChain.start()
                .compare(1, 1)
                .compare("str", "str")
                .compare(4, 5)
                .result();
        Assert.assertEquals(-1, result);

        int resultTwo = ComparisonChain.start()
                .compare(1, 1)
                .compare("str", "str")
                .compare(5, 5)
                .result();
        Assert.assertEquals(0, resultTwo);
    }


}
