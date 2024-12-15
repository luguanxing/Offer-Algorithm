package leetcode.problems;

import java.util.*;

public class Test1338_数组大小减半 {

    public static void main(String[] args) {
        // arr = [3,3,3,3,5,5,5,2,2,7]
        System.out.println(new Solution().minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        // arr = [7,7,7,7,7,7]
        System.out.println(new Solution().minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
    }

    static class Solution {
        public int minSetSize(int[] arr) {
            // 统计num频率并排序
            int len = arr.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] cnts = new int[map.size()];
            int idx = 0;
            for (int cnt : map.values()) {
                cnts[idx++] = cnt;
            }
            Arrays.sort(cnts);
            // 贪心尝试最小次数
            int sum = 0;
            for (int i = 1; len - i >= 0; i++) {
                sum += cnts[cnts.length - i];
                if (sum >= len / 2) {
                    return i;
                }
            }
            return -1;
        }
    }

}
