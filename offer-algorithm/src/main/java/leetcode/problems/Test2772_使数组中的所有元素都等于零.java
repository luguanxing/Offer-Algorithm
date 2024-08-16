package leetcode.problems;

public class Test2772_使数组中的所有元素都等于零 {

    public static void main(String[] args) {
        // nums = [2,2,3,1,1,0], k = 3
        System.out.println(new Solution().checkArray(new int[]{2, 2, 3, 1, 1, 0}, 3));
        // nums = [1,3,1,1], k = 2
        System.out.println(new Solution().checkArray(new int[]{1, 3, 1, 1}, 2));
        System.out.println(new Solution().checkArray(new int[]{22}, 1));
        System.out.println(new Solution().checkArray(new int[]{0, 45, 82, 98, 99}, 4));
        System.out.println(new Solution().checkArray(new int[]{60,72,87,89,63,52,64,62,31,37,57,83,98,94,92,77,94,91,87,100,91,91,50,26}, 4));
    }

    static class Solution {
        public boolean checkArray(int[] nums, int k) {
            int len = nums.length;
            // 差分数组维护当前状态
            int currentState = -nums[0];
            int[] diff = new int[len];
            diff[0] = currentState;
            if (k < len) {
                diff[k] = -diff[0];
            }
            for (int i = 1; i < len; i++) {
                currentState += diff[i];
                if (nums[i] + currentState < 0) {
                    return false;
                } else if (nums[i] + currentState == 0) {
                    continue;
                } else {
                    diff[i] = -(currentState + nums[i]);
                    if (i + k < len) {
                        diff[i + k] = -diff[i];
                    }
                    // 必须要改k个（包含自己），如果剩下不够k-1个返回失败
                    if (i + k - 1 >= len) {
                        return false;
                    }
                    currentState += diff[i];
                }
            }
            return true;
        }
    }

}
