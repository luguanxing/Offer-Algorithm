package leetcode.contest.week353;

public class Test6919_使数组中的所有元素都等于零 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkArray(new int[]{2, 2, 3, 1, 1, 0}, 3));
        System.out.println(new Solution().checkArray(new int[]{1, 3, 1, 1}, 2));
        System.out.println(new Solution().checkArray(new int[]{60, 72, 87, 89, 63, 52, 64, 62, 31, 37, 57, 83, 98, 94, 92, 77, 94, 91, 87, 100, 91, 91, 50, 26}, 4));
    }

    static class Solution {
        public boolean checkArray(int[] nums, int k) {
            int len = nums.length;
            for (int i = 0; i <= len - k; i++) {
                int num = nums[i];
                if (num < 0) {
                    return false;
                }
                if (num != 0) {
                    for (int j = i; j < i + k; j++) {
                        nums[j] -= num;
                    }
                }
            }
            for (int n : nums) {
                if (n != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
