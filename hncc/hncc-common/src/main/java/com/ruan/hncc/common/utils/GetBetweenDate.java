package com.ruan.hncc.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ruanTeng
 * @version 1.0
 * @date 2021/3/6 9:07
 *
 * 取两个时间段的时间，时间可跨年
 */
public class GetBetweenDate {

    public static void main(String[] args) {
        List<String> list = getBetweenDate("2013-12-1","2014-02-1");
        for(String date:list){
            System.out.println(date);
        }
    }

    public static List<String> getBetweenDate(String begin,String end){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<String> betweenList = new ArrayList<String>();

        try{
            Calendar startDay = Calendar.getInstance();
            startDay.setTime(format.parse(begin));
            startDay.add(Calendar.DATE, -1);

            while(true){
                startDay.add(Calendar.DATE, 1);
                Date newDate = startDay.getTime();
                String newend=format.format(newDate);
                betweenList.add(newend);
                if(end.equals(newend)){
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return betweenList;
    }

}
