package leetcode.contest.week224;

import java.util.HashMap;
import java.util.Map;

public class Test5243_同积元组 {

    public static void main(String[] args) {
        System.out.println(new Solution().tupleSameProduct(
                new int[]{2, 3, 4, 6}
        ));
        System.out.println(new Solution().tupleSameProduct(
                new int[]{1, 2, 4, 5, 10}
        ));
        System.out.println(new Solution().tupleSameProduct(
                new int[]{2, 3, 4, 6, 8, 12}
        ));
        System.out.println(new Solution().tupleSameProduct(
                new int[]{2, 3, 5, 7}
        ));
    }

    static class Solution {
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int product = nums[i] * nums[j];
                    map.put(product, map.getOrDefault(product, 0) + 1);
                }
            }
            int res = 0;
            for (int cnt : map.values()) {
                res += cnt * (cnt - 1) * 4;
            }
            return res;
        }
    }

}
