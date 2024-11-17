package leetcode.contest.week424;

public class Test100483_零数组变换II {

    public static void main(String[] args) {
        // nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
        System.out.println(new Solution().minZeroArray(new int[]{2, 0, 2}, new int[][]{{0, 2, 1}, {0, 2, 1}, {1, 1, 3}}));
        // nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
        System.out.println(new Solution().minZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3, 2}, {0, 2, 1}}));
    }

    static class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            int l = 0;
            int r = queries.length;
            if (!okArray(nums, queries, r)) {
                return -1;
            }
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (okArray(nums, queries, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public boolean okArray(int[] nums, int[][] queries, int k) {
            int len = nums.length;
            int[] cnt = new int[len + 1];
            for (int i = 0; i < k; i++) {
                int[] query = queries[i];
                cnt[query[0]] += query[2];
                cnt[query[1] + 1] -= query[2];
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
