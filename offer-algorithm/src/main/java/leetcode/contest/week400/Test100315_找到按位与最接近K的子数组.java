package leetcode.contest.week400;

public class Test100315_找到按位与最接近K的子数组 {

    public static void main(String[] args) {
        // nums = [1,2,4,5], k = 3
        System.out.println(new Solution().minimumDifference(new int[]{1, 2, 4, 5}, 3));
        // nums = [1,2,1,2], k = 2
        System.out.println(new Solution().minimumDifference(new int[]{1, 2, 1, 2}, 2));
        // nums = [1], k = 10
        System.out.println(new Solution().minimumDifference(new int[]{1}, 10));
        System.out.println(new Solution().minimumDifference(new int[]{5, 13, 90, 92, 49}, 10));
        System.out.println(new Solution().minimumDifference(new int[]{12, 38, 79, 20, 25}, 7));
    }

    static class Solution {
        public int minimumDifference(int[] nums, int k) {
            int n = nums.length;
            int minDiff = Integer.MAX_VALUE;

            // 计算每个位的前缀和
            int[][] prefix = new int[n][32];
            for (int i = 0; i < n; i++) {
                for (int b = 0; b < 32; b++) {
                    if (i == 0) {
                        prefix[i][b] = (nums[i] >> b) & 1;
                    } else {
                        prefix[i][b] = prefix[i - 1][b] + ((nums[i] >> b) & 1);
                    }
                }
            }

            // 二分查找最接近的数
            for (int i = 0; i < n; i++) {
                int currentAND = nums[i];
                minDiff = Math.min(minDiff, Math.abs(k - currentAND));

                int left = i + 1, right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    // 计算从 i 到 mid 的按位与值
                    int newAND = currentAND;
                    for (int b = 0; b < 32; b++) {
                        int count = prefix[mid][b] - (i > 0 ? prefix[i - 1][b] : 0);
                        if (count == (mid - i + 1)) {
                            newAND |= (1 << b);
                        } else {
                            newAND &= ~(1 << b);
                        }
                    }

                    int diff = Math.abs(k - newAND);
                    minDiff = Math.min(minDiff, diff);

                    if (newAND <= k) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return minDiff;
        }
    }
}
