package com.ruan.hncc.sms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//@SpringBootTest
class HnccSmsApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2021-2-11");
        cal.setTime(d);
        int date = cal.get(Calendar.DAY_OF_WEEK)-1;

        System.out.println(date);
    }


}
