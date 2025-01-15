package leetcode.problems;

public class Test3095_或值至少K的最短子数组I {

    public static void main(String[] args) {
        // nums = [1,2,3], k = 2
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        // nums = [2,1,8], k = 10
        System.out.println(new Solution().minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 2}, 0));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 12, 2, 5}, 43));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{2, 1, 2, 32}, 29));
    }

    static class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int len = nums.length;
            int[] kmap = new int[32];
            updateMap(kmap, k, 1);
            int l = 0;
            int r = 0;
            int min = Integer.MAX_VALUE;
            int[] map = new int[32];
            while (l <= r && r < len) {
                updateMap(map, nums[r++], 1);
                while (l <= r && getMapNum(map) >= k) {
                    min = Math.min(min, r - l);
                    updateMap(map, nums[l++], -1);
                }
            }
            if (min == 0) {
                return 1;
            }
            if (min == Integer.MAX_VALUE) {
                return -1;
            }
            return min;
        }

        public void updateMap(int[] map, int current, int incr) {
            for (int i = 0; i < 32; i++) {
                if ((current & (1 << i)) != 0) {
                    map[i] += incr;
                }
            }
        }

        private int getMapNum(int[] map) {
            int current = 0;
            for (int i = 0; i < 32; i++) {
                if (map[i] > 0) {
                    current |= (1 << i);
                }
            }
            return current;
        }
    }

}
