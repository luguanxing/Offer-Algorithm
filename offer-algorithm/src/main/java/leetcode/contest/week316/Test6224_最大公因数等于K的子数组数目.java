package leetcode.contest.week316;

import java.util.ArrayList;
import java.util.List;

public class Test6224_最大公因数等于K的子数组数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3));
        System.out.println(new Solution().subarrayGCD(new int[]{9, 3, 3, 1, 2, 6, 3}, 3));
        System.out.println(new Solution().subarrayGCD(new int[]{4}, 7));
        System.out.println(new Solution().subarrayGCD(new int[]{3, 12, 9, 6}, 3));
        System.out.println(new Solution().subarrayGCD(new int[]{3, 3, 4, 1, 2}, 1));
    }

    static class Solution {
        public int subarrayGCD(int[] nums, int k) {
            int len = nums.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                List<Integer> window = new ArrayList<>();
                for (int j = i; j < len; j++) {
                    if (nums[j] % k != 0) {
                        break;
                    }
                    window.add(nums[j]);
                    if (isOk(window, k)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean isOk(List<Integer> window, int k) {
            int fatcor = window.get(0);
            for (int j = 1; j < window.size(); j++) {
                fatcor = getMaxFactor(fatcor, window.get(j));
            }
            return fatcor == k;
        }

        int getMaxFactor(int m, int n) {
            int temp = m > n ? n : m;
            for (int i = temp; i > 0; i--) {
                if (m % i == 0 && n % i == 0) {
                    return i;
                }
            }
            return 0;
        }
    }

}
