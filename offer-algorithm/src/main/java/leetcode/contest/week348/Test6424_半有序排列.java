package leetcode.contest.week348;

import java.util.Arrays;

public class Test6424_半有序排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().semiOrderedPermutation(
                new int[]{2, 1, 4, 3}
        ));
        System.out.println(new Solution().semiOrderedPermutation(
                new int[]{2, 4, 1, 3}
        ));
        System.out.println(new Solution().semiOrderedPermutation(
                new int[]{1, 3, 4, 2, 5}
        ));
    }

    static class Solution {
        public int semiOrderedPermutation(int[] nums) {
            int cnt1 = move1(nums.clone());
            int cntn = moven(nums.clone());
            return Math.min(cnt1, cntn);
        }

        private int move1(int[] nums) {
            int cnt = 0;
            int len = nums.length;
            int idx1 = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 1) {
                    idx1 = i;
                }
            }
            for (int i = idx1; i >= 1; i--) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
                cnt++;
            }
            int idxn = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] == len) {
                    idxn = i;
                }
            }
            return cnt + (len - idxn - 1);
        }

        private int moven(int[] nums) {
            int cnt = 0;
            int len = nums.length;
            int idxn = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] == len) {
                    idxn = i;
                }
            }
            for (int i = idxn; i < len - 1; i++) {
                int tmp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = tmp;
                cnt++;
            }
            int idx1 = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 1) {
                    idx1 = i;
                }
            }
            return cnt + (idx1 + 1);
        }
    }

}
