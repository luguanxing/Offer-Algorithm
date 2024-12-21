package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test3138_同位字符串连接的最小长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().minAnagramLength("abba"));
        System.out.println(new Solution().minAnagramLength("cdef"));
        System.out.println(new Solution().minAnagramLength("aabb"));
    }

    static class Solution {
        public int minAnagramLength(String s) {
            int len = s.length();
            int minLength = Integer.MAX_VALUE;
            for (int currentLen = len; currentLen > 0; currentLen--) {
                if (len % currentLen != 0) {
                    continue;
                }
                Set<String> set = new HashSet<>();
                for (int idx = 0; idx + currentLen <= len; idx += currentLen) {
                    char[] chars = s.substring(idx, idx + currentLen).toCharArray();
                    Arrays.sort(chars);
                    set.add(new String(chars));
                }
                if (set.size() == 1) {
                    minLength = Math.min(minLength, currentLen);
                }
            }
            return minLength;
        }
    }

}
