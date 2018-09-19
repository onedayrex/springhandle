package com.onedayrex.git.springhandle.api.guava;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class ProToBuffTest {
    private static final Logger logger = LoggerFactory.getLogger(ProToBuffTest.class);

    @Test
    public void test() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.pro");
        PersonOuterClass.Person.Builder builder = PersonOuterClass.Person.newBuilder();
        builder.setName("onedayrex");
        builder.setEmail("1115757866@qq.com");
        PersonOuterClass.Person person = builder.build();
        byte[] bytes = person.toByteArray();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        logger.info("create buffer file success");
        File file = new File("test.pro");
        InputStream in = new FileInputStream(file);
        PersonOuterClass.Person personResult = PersonOuterClass.Person.parseFrom(in);
        logger.info("result ==>[{}]", personResult);
        in.close();
        file.delete();
    }
}
