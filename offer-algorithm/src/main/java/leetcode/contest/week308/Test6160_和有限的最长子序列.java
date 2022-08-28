package leetcode.contest.week308;

import java.util.Arrays;

public class Test6160_和有限的最长子序列 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().answerQueries(
                new int[]{4, 5, 2, 1},
                new int[]{3, 10, 21}
        )));
        System.out.println(Arrays.toString(new Solution().answerQueries(
                new int[]{2, 3, 4, 5},
                new int[]{1}
        )));
    }

    static class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int sum = 0;
                int cnt = 0;
                for (int num : nums) {
                    if (sum + num <= queries[i]) {
                        sum += num;
                        cnt++;
                    }
                }
                res[i] = cnt;
            }
            return res;
        }
    }

}
