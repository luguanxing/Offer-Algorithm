package leetcode.contest.week424;

public class Test100481_零数组变换I {

    public static void main(String[] args) {
        // nums = [1,0,1], queries = [[0,2]]
        System.out.println(new Solution().isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}}));
        // nums = [4,3,2,1], queries = [[1,3],[0,2]]
        System.out.println(new Solution().isZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3}, {0, 2}}));
    }

    static class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int len = nums.length;
            int[] cnt = new int[len + 1];
            for (int[] query : queries) {
                cnt[query[0]]++;
                cnt[query[1] + 1]--;
            }
            int current = 0;
            for (int i = 0; i < len; i++) {
                current += cnt[i];
                int num = nums[i];
                if (num > current) {
                    return false;
                }
            }
            return true;
        }
    }

}
