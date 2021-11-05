package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test1218_最长定差子序列 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int res = 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                if (map.containsKey(num - difference)) {
                    int lastCnt = map.get(num - difference);
                    map.put(num, lastCnt + 1);
                    res = Math.max(res, lastCnt + 1);
                } else {
                    map.put(num, 1);
                }
            }
            return res;
        }
    }

}
