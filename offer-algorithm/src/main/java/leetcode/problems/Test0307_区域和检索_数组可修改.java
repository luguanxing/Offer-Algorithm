package leetcode.problems;

public class Test0307_区域和检索_数组可修改 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8

    }

    static class NumArray {
        private int[] nums;
        private int[] prefixSum;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.prefixSum = new int[nums.length];
            this.prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                this.prefixSum[i] = this.prefixSum[i - 1] + nums[i];
            }
        }

        public void update(int index, int val) {
            int oldVal = nums[index];
            int diff = val - oldVal;
            nums[index] = val;
            for (int i = index; i < prefixSum.length; i++) {
                prefixSum[i] += diff;
            }
        }

        public int sumRange(int left, int right) {
            int leftPrefixSum = left == 0 ? 0 : prefixSum[left - 1];
            int rightPrefixSum = prefixSum[right];
            return rightPrefixSum - leftPrefixSum;
        }
    }

}
