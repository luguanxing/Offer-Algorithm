package leetcode.problems;

import java.util.Arrays;

public class Test3354_使数组元素等于零 {

    public static void main(String[] args) {
        // [1,0,2,0,3]
        System.out.println(new Solution().countValidSelections(new int[]{1, 0, 2, 0, 3}));
        // [2,3,4,0,4,1,0]
        System.out.println(new Solution().countValidSelections(new int[]{2, 3, 4, 0, 4, 1, 0}));
        // [16,13,10,0,0,0,10,6,7,8,7]
        System.out.println(new Solution().countValidSelections(new int[]{16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7}));
        // [16,13,10,0,0,0,10,29]
        System.out.println(new Solution().countValidSelections(new int[]{16, 13, 10, 0, 0, 0, 10, 29}));
    }

    static class Solution {
        public int countValidSelections(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            // 前缀和
            int prefixSum = 0;
            int res = 0;
            for (int num : nums) {
                if (num == 0) {
                    if (prefixSum * 2 == sum) {
                        // 前后和相同可以双向
                        res += 2;
                    } else if (prefixSum * 2 == sum + 1 || prefixSum * 2 == sum - 1) {
                        // 前后和差1只能单向
                        res += 1;
                    }
                }
                prefixSum += num;
            }
            return res;
        }
    }

}
