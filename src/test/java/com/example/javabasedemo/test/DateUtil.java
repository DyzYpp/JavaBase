package com.example.javabasedemo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DateUtil
 * @Author
 * @Date 2020/6/18
 * @description
 */
public class DateUtil {
    public static void main(String[] args) throws ParseException {
        String sTime = "2019-12-30 01:00:00";
        String eTime = "2020-01-01 02:14:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf.parse(sTime);
        Date d2 = sdf.parse(eTime);
//        List<String> times = getTimes(d1, d2, 3600000);
        List<String> times = getTimes(d1,d2,900000);
//        List<String> times = getTimes(d1, d2, 86400000);
//        List<String> times = getTimes(d1, d2, 1);
        for (String time : times) {
            System.out.println("得到的时间集合=:" + time);
        }
    }

    public static List<String> getTimes(Date startTime, Date endTIme, long ll) {
        List<String> times = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        long startTimeStamp = calendar.getTimeInMillis();
        calendar.setTime(endTIme);
        long endTimeStamp = calendar.getTimeInMillis();
        while (true) {
            long temp = startTimeStamp + ll;
            if (temp <= endTimeStamp) {
                startTimeStamp = temp;
                Calendar _calendar = Calendar.getInstance();
                _calendar.setTimeInMillis(temp);
                int year = _calendar.get(Calendar.YEAR);
                int month = _calendar.get(Calendar.MONTH);
                int day = _calendar.get(Calendar.DAY_OF_MONTH);
                int hour = _calendar.get(Calendar.HOUR_OF_DAY);//24小时制
                int minute = _calendar.get(Calendar.MINUTE);
                String mongthRes = (month + 1) > 9 ? String.valueOf(month + 1) : "0" + (month + 1);
                String dayRes = day > 9 ? String.valueOf(day) : "0" + day;
                String hourRes = hour > 9 ? String.valueOf(hour) : "0" + hour;
                String minuteRes = minute > 9 ? String.valueOf(minute) : "0" + minute;
                if (ll == 900000) {
                    String time = year + "-" + mongthRes + "-" + dayRes + " " + hourRes + ":" + minuteRes + ":" + "00";
                    times.add(time);
                } else if (ll == 3600000) {
                    String time = year + "-" + mongthRes + "-" + dayRes + " " + hourRes + ":" + "00:00";
                    times.add(time);
                } else if (ll == 86400000) {
                    String time = year + "-" + mongthRes + "-" + dayRes;
                    times.add(time);
                } else{
                    if (month + 1 == 1 || month + 1 == 3 || month + 1 == 5 || month + 1 == 7 || month + 1 == 8 || month + 1 == 10 || month + 1 == 12) {
                        ll = 2678400000L;
                        String time = year + "-" + mongthRes;
                        times.add(time);
                    } else if (month + 1 == 4 || month + 1 == 6 || month + 1 == 9 || month + 1 == 11) {
                        ll = 2592000000L;
                        String time = year + "-" + mongthRes;
                        times.add(time);
                    } else {
                        if (year % 4  == 0 && year % 100 != 0 || year % 400 == 0){
                            ll = 2505600000L;
                            String time = year + "-" + mongthRes;
                            times.add(time);
                        }else{
                            ll = 2419200000L;
                            String time = year + "-" + mongthRes;
                            times.add(time);
                        }
                    }
                }
            } else {
                break;
            }
        }
        return times;
    }
}
