package leetcode.contest.week310;

import java.util.HashSet;
import java.util.Set;

public class Test6177_子字符串的最优划分 {

    public static void main(String[] args) {
        System.out.println(new Solution().partitionString("abacaba"));
        System.out.println(new Solution().partitionString("ssssss"));
        System.out.println(new Solution().partitionString("aba"));
    }

    static class Solution {
        public int partitionString(String s) {
            Set<Character> currentChars = new HashSet<>();
            int res = 1;
            for (char c : s.toCharArray()) {
                if (!currentChars.contains(c)) {
                    currentChars.add(c);
                } else {
                    currentChars.clear();
                    currentChars.add(c);
                    res++;
                }
            }
            return res;
        }
    }

}
