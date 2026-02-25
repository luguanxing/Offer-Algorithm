package leetcode.problems;

import java.util.*;

public class Test1461_检查一个字符串是否包含所有长度为K的二进制子串 {

    public static void main(String[] args) {
        // s = "00110110", k = 2
        System.out.println(new Solution().hasAllCodes("00110110", 2));
        // s = "0110", k = 1
        System.out.println(new Solution().hasAllCodes("0110", 1));
        // s = "0110", k = 2
        System.out.println(new Solution().hasAllCodes("0110", 2));
    }

    static class Solution {
        public boolean hasAllCodes(String s, int k) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= s.length() - k; i++) {
                set.add(s.substring(i, i + k));
            }
            return set.size() == (1 << k);
        }
    }

}
