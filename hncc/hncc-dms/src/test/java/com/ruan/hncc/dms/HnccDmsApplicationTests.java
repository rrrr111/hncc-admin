package com.ruan.hncc.dms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

//@SpringBootTest
class HnccDmsApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String [] s = {"1","2","3","4"};
        List<String> list = Arrays.asList(s);
        System.out.println(list.toString().replace("[","").replace("]",""));
    }

}
