package leetcode.problems;

import java.util.Arrays;

public class Test0899_有序队列 {

    public static void main(String[] args) {
        System.out.println(new Solution().orderlyQueue("cba", 1));
        System.out.println(new Solution().orderlyQueue("baaca", 3));
    }

    static class Solution {
        public String orderlyQueue(String s, int k) {
            String min = s;
            if (k == 1) {
                // 长度为1，循环判断即可
                for (int i = 0; i < s.length(); i++) {
                    String current = s.substring(i) + s.substring(0, i);
                    if (current.compareTo(min) < 0) {
                        min = current;
                    }
                }
            } else if (k > 1) {
                // 长度大于1，必能重新排序（每次都可抽出要排的那一位放最后）
                char[] chars = s.toCharArray().clone();
                Arrays.sort(chars);
                min = new String(chars);
            }
            return min;
        }
    }

}
