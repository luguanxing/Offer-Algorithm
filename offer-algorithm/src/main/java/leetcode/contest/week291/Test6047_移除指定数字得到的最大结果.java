package leetcode.contest.week291;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test6047_移除指定数字得到的最大结果 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeDigit("123", '3'));
        System.out.println(new Solution().removeDigit("1231", '1'));
        System.out.println(new Solution().removeDigit("551", '5'));
    }

    static class Solution {
        public String removeDigit(String number, char digit) {
            int len = number.length();
            List<String> list = new ArrayList<>();
            for (int i = len - 1; i >= 0; i--) {
                if (number.charAt(i) == digit) {
                    list.add(number.substring(0, i) + number.substring(i + 1));
                }
            }
            Collections.sort(list);
            return list.get(list.size() - 1);
        }
    }

}
