import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        List<String> betweenHour = getBetweenHour1("2024-07-14 00", "2024-07-16 23");
//        for (String s:betweenHour){
//            System.out.println(s);
//        }

        System.out.println(DateUtil.format(DateUtil.parse("2024-07-16"), "yyyy-MM-dd HH:mm:ss"));


//        List<String> betweenHour = getBetweenHour("2024-07-14 00", "2024-07-16 23");
//        String sqlStr = "";
//        for (String s : betweenHour) {
//            for (String str:list ) {
//                sqlStr += "SELECT '"+str+"' AS out_put_name,  '"+s+"' as tday  " + " UNION ALL ";
//            }
//          //  sqlStr += "SELECT '"+s+"' as tday  " + " UNION ALL ";
//        }
//        int lastIndexOf = sqlStr.lastIndexOf("UNION ALL");
//        System.out.println(sqlStr.substring(0, lastIndexOf));
    }

    private static String getSqlStr(String str){
        String[] split = str.split(" ");
        return "SELECT '"+split[0]+"' as tday, '"+split[1]+"' AS tday_hour";
    }

    //生成两个日期之间的每天的小时 组装成 yyyy-MM-dd HH
    public static List<String> getBetweenHour(String start, String end) {
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        try {
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            while (calendar.getTime().before(endDate)) {
                result.add(sdf.format(calendar.getTime()));
                calendar.add(Calendar.HOUR_OF_DAY, 1);
            }
            result.add(sdf.format(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> getBetweenHour1(String start, String end) {
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        try {
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);
            while (calendar.getTime().after(startDate)) {
                result.add(sdf.format(calendar.getTime()));
                calendar.add(Calendar.HOUR_OF_DAY, -1);
            }
            result.add(sdf.format(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
