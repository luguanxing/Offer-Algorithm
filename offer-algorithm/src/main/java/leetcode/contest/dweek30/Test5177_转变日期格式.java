package leetcode.contest.dweek30;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test5177_转变日期格式 {

    public static void main(String[] args) {
        System.out.println(new Solution().reformatDate("20th Oct 2052"));
        System.out.println(new Solution().reformatDate("6th Jun 1933"));
        System.out.println(new Solution().reformatDate("26th May 1960"));
    }

    static class Solution {
        private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        public String reformatDate(String date) {
            String[] infos = date.split(" ");
            String dayStr = infos[0];
            String monthStr = infos[1];
            String yearStr = infos[2];
            // 转换月份字符串
            monthStr = Arrays.stream(months).collect(Collectors.toList()).indexOf(monthStr) + 1 + "";
            monthStr = monthStr.length() == 1 ? "0" + monthStr : monthStr;
            // 转换日期字符串
            dayStr = dayStr
                    .replaceAll("st", "")
                    .replaceAll("nd", "")
                    .replaceAll("rd", "")
                    .replaceAll("th", "");
            dayStr = dayStr.length() == 1 ? "0" + dayStr : dayStr;
            return yearStr + "-" + monthStr + "-" + dayStr;
        }
    }

}
