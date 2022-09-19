package leetcode.problems;

import java.util.*;

public class Test1636_按照频率将数组升序排序 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }

    static class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (int num : map.keySet()) {
                list.add(new int[]{num, map.get(num)});
            }
            Collections.sort(list, (nc1, nc2) -> {
                int num1 = nc1[0];
                int cnt1 = nc1[1];
                int num2 = nc2[0];
                int cnt2 = nc2[1];
                if (cnt1 != cnt2) {
                    return Integer.compare(cnt1, cnt2);
                }
                return Integer.compare(num2, num1);
            });
            int[] res = new int[nums.length];
            int idx = 0;
            for (int[] nc : list) {
                int num = nc[0];
                int cnt = nc[1];
                for (int i = 1; i <= cnt; i++) {
                    res[idx++] = num;
                }
            }
            return res;
        }
    }

}
