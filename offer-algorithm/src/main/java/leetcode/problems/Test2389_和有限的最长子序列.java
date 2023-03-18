package leetcode.problems;

import java.util.Arrays;

public class Test2389_和有限的最长子序列 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().answerQueries(
                new int[]{4, 5, 2, 1},
                new int[]{3, 10, 21}
        )));
        System.out.println(Arrays.toString(new Solution().answerQueries(
                new int[]{2, 3, 4, 5},
                new int[]{1}
        )));
        System.out.println(Arrays.toString(new Solution().answerQueries(
                new int[]{736411, 184882, 914641, 37925, 214915},
                new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450}
        )));
    }

    static class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            int len = queries.length;
            int[] res = new int[len];
            Arrays.sort(nums);
            for (int i = 0; i < len; i++) {
                int query = queries[i];
                int cnt = 0;
                int sum = 0;
                for (int num : nums) {
                    sum += num;
                    cnt++;
                    if (sum <= query) {
                        res[i] = Math.max(res[i], cnt);
                    } else {
                        break;
                    }
                }
            }
            return res;
        }
    }

}
