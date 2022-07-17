package leetcode.contest.week302;

import java.util.TreeMap;

public class Test6122_使数组可以被整除的最少删除次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(
                new int[]{2, 3, 2, 4, 3},
                new int[]{9, 6, 9, 3, 15}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{4, 3, 6},
                new int[]{8, 2, 6, 10}
        ));
    }

    static class Solution {
        public int minOperations(int[] nums, int[] numsDivide) {
            TreeMap<Integer, Integer> numMap = new TreeMap<>();
            for (int num : nums) {
                numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            }
            int res = 0;
            for (int num : numMap.keySet()) {
                if (canDiv(num, numsDivide)) {
                    return res;
                }
                res += numMap.get(num);
            }
            return -1;
        }

        private boolean canDiv(int num, int[] numsDivide) {
            for (int numDiv : numsDivide) {
                if (numDiv % num != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
