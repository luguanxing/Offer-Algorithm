package leetcode.problems;

import java.util.Arrays;

public class Test3132_找出与数组相加的整数II {

    public static void main(String[] args) {
        // nums1 = [4,20,16,12,8], nums2 = [14,18,10]
        System.out.println(new Solution().minimumAddedInteger(new int[]{4, 20, 16, 12, 8}, new int[]{14, 18, 10}));
        // nums1 = [3,5,5,3], nums2 = [7,7]
        System.out.println(new Solution().minimumAddedInteger(new int[]{3, 5, 5, 3}, new int[]{7, 7}));
        // nums1 = [4,6,3,1,4,2,10,9,5], nums2 = [5,10,3,2,6,1,9]
        System.out.println(new Solution().minimumAddedInteger(new int[]{4, 6, 3, 1, 4, 2, 10, 9, 5}, new int[]{5, 10, 3, 2, 6, 1, 9}));
    }

    static class Solution {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int res = Integer.MAX_VALUE;
            // 只可能是删除前3个数中的0-2个
            // 所以删除后必然会是nums1[0]，nums1[1]，nums1[2]中的一个，枚举即可
            for (int idx = 0; idx <= 2; idx++) {
                int diff = nums2[0] - nums1[idx];
                int chance = 2 - idx;
                // 判断剩下的数是否能匹配
                if (isSub(nums1, nums2, diff, idx, chance)) {
                    res = Math.min(res, diff);
                }
            }
            return res;
        }

        private boolean isSub(int[] nums1, int[] nums2, int diff, int idx, int chance) {
            int match = 0;
            for (int i = idx; i < nums1.length && match < nums2.length; i++) {
                if (nums1[i] + diff == nums2[match]) {
                    match++;
                } else {
                    if (chance == 0) {
                        return false;
                    }
                    chance--;
                }
            }
            return match == nums2.length;
        }
    }

    static class Solution_暴力 {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums1.length; i++) {
                next:
                for (int j = i + 1; j < nums1.length; j++) {
                    // 移除nums1[i]和nums1[j]
                    int[] newNums1 = new int[nums1.length - 2];
                    for (int k = 0, idx = 0; k < nums1.length; k++) {
                        if (k != i && k != j) {
                            newNums1[idx++] = nums1[k];
                        }
                    }
                    // 看是否能在nums2中匹配
                    int diff = nums2[0] - newNums1[0];
                    for (int idx = 0; idx < newNums1.length; idx++) {
                        if (newNums1[idx] + diff != nums2[idx]) {
                            continue next;
                        }
                    }
                    res = Math.min(res, diff);
                }
            }
            return res;
        }
    }

}
