package offer;

import java.util.Arrays;

public class Test0238_除自身以外数组的乘积 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 分别计算从左的累积和从右的累积
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            left[0] = nums[0];
            right[right.length - 1] = nums[nums.length - 1];
            for (int i = 1; i < left.length; i++) {
                left[i] = left[i - 1] * nums[i];
            }
            for (int i = right.length - 2; i >= 0; i--) {
                right[i] = right[i + 1] * nums[i];
            }
            // 计算左右的累积相乘的结果
            int[] result = new int[nums.length];
            result[0] = right[1];
            result[result.length - 1] = left[left.length - 2];
            for (int i = 1; i < result.length - 1; i++) {
                result[i] = left[i - 1] * right[i + 1];
            }
            return result;
        }
    }

}
