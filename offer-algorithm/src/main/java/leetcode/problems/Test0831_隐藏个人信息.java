package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0831_隐藏个人信息 {

    public static void main(String[] args) {
        System.out.println(new Solution().maskPII("LeetCode@LeetCode.com"));
        System.out.println(new Solution().maskPII("AB@qq.com"));
        System.out.println(new Solution().maskPII("1(234)567-890"));
        System.out.println(new Solution().maskPII("86-(10)12345678"));
    }

    static class Solution {
        public String maskPII(String s) {
            String res = "";
            if (s.contains("@")) {
                int idx = s.indexOf("@");
                String name = s.substring(0, idx);
                String domian = s.substring(idx + 1).toLowerCase();
                String newName = Character.toLowerCase(name.charAt(0)) + "*****" + Character.toLowerCase(name.charAt(name.length() - 1));
                res = newName + "@" + domian;
            } else {
                List<Integer> list = new ArrayList<>();
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) {
                        list.add(c - '0');
                    }
                }
                int countryCode = list.size() - 10;
                if (countryCode == 0) {
                    res += "***-***-";
                } else if (countryCode == 1) {
                    res += "+*-***-***-";
                } else if (countryCode == 2) {
                    res += "+**-***-***-";
                } else {
                    res += "+***-***-***-";
                }
                for (int i = list.size() - 4; i < list.size(); i++) {
                    res += list.get(i);
                }
            }
            return res;
        }
    }

}
