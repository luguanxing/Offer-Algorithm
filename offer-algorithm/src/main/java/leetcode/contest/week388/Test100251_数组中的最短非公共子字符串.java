package leetcode.contest.week388;

import java.util.*;

public class Test100251_数组中的最短非公共子字符串 {

    public static void main(String[] args) {
        // arr = ["cab","ad","bad","c"]
        System.out.println(Arrays.toString(new Solution().shortestSubstrings(new String[]{"cab", "ad", "bad", "c"})));
        // arr = ["abc","bcd","abcd"]
        System.out.println(Arrays.toString(new Solution().shortestSubstrings(new String[]{"abc", "bcd", "abcd"})));
    }

    static class Solution {
        public String[] shortestSubstrings(String[] arr) {
            // 存子串对应序列的索引
            Map<String, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length(); j++) {
                    for (int k = j + 1; k <= arr[i].length(); k++) {
                        String substr = arr[i].substring(j, k);
                        map.putIfAbsent(substr, new HashSet<>());
                        map.get(substr).add(i);
                    }
                }
            }
            // 再次枚举计算答案
            String[] res = new String[arr.length];
            for (int i = 0; i < arr.length; i++) {
                String minSubstr = "";
                for (int j = 0; j < arr[i].length(); j++) {
                    for (int k = j + 1; k <= arr[i].length(); k++) {
                        String substr = arr[i].substring(j, k);
                        if (map.get(substr).size() == 1) {
                            if (minSubstr.equals("") || substr.length() < minSubstr.length() || (substr.length() == minSubstr.length() && substr.compareTo(minSubstr) < 0)) {
                                minSubstr = substr;
                            }
                        }
                    }
                }
                res[i] = minSubstr;
            }
            return res;
        }
    }

}
