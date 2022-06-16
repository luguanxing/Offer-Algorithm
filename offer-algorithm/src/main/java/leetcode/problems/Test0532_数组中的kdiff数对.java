package leetcode.problems;


import java.util.HashMap;
import java.util.Map;

public class Test0532_数组中的kdiff数对 {

    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(new Solution().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new Solution().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(new Solution().findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3));
    }

    static class Solution {
        public int findPairs(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int res = 0;
            for (int num : map.keySet()) {
                int cnt = map.getOrDefault(num + k, 0);
                if (cnt > 0) {
                    if (k == 0 && cnt > 1) {
                        res++;
                    } else if (k == 0 && cnt == 1) {

                    } else if (k != 0) {
                        res++;
                    }

                }
            }
            return res;
        }
    }

}
