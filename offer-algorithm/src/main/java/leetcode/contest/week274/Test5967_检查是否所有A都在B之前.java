package leetcode.contest.week274;

import java.util.Arrays;

public class Test5967_检查是否所有A都在B之前 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkString("aaabbb"));
        System.out.println(new Solution().checkString("abab"));
        System.out.println(new Solution().checkString("bbb"));
    }

    static class Solution {
        public boolean checkString(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars).equals(s);
        }
    }

}
