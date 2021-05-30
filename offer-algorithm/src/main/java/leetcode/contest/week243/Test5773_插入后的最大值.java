package leetcode.contest.week243;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5773_插入后的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue("99", 9));
        System.out.println(new Solution().maxValue("13", 2));
        System.out.println(new Solution().maxValue("13", 5));
        System.out.println(new Solution().maxValue("23", 1));
        System.out.println(new Solution().maxValue("98", 1));
        System.out.println(new Solution().maxValue("91", 5));
        System.out.println(new Solution().maxValue("-13", 2));
        System.out.println(new Solution().maxValue("-132", 3));
        System.out.println(new Solution().maxValue("-152", 3));
        System.out.println(new Solution().maxValue("-152", 8));
        System.out.println(new Solution().maxValue("-648468153646", 5));
    }

    static class Solution {
        public String maxValue(String n, int x) {
            boolean isNeg = n.startsWith("-");
            if (!isNeg) {
                // 放到第一个比他小的前面，都没有放最后
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) < '0' + x) {
                        return n.substring(0, i) + x + n.substring(i);
                    }
                }
            } else {
                // 放到第一个比他大的前面，都没有放最后
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) > '0' + x) {
                        return n.substring(0, i) + x + n.substring(i);
                    }
                }
            }
            return n + x;
        }
    }

    static class Solution_TLE {
        public String maxValue(String n, int x) {
            boolean isNeg = n.startsWith("-");
            String res = null;
            if (isNeg) {
                n = n.substring(1);
            }
            for (int i = 0; i <= n.length(); i++) {
                String current = n.substring(0, i) + x + n.substring(i);
                if (res == null) {
                    res = current;
                } else {
                    if (res.compareTo(current) >= 0) {
                        if (isNeg) {
                            res = current;
                        }
                    } else {
                        if (!isNeg) {
                            res = current;
                        }
                    }
                }
            }
            return (isNeg ? "-" : "") + res;
        }
    }

}
