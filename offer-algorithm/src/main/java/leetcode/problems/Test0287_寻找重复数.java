package leetcode.problems;

public class Test0287_寻找重复数 {

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new Solution().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1) {
                    // 如果nums[i]和i+1不相等，则不断替换nums[i],nums[nums[i]-1]直到该位置序号和数字相等
                    int nextNumIndex = nums[i] - 1;
                    int nextNum = nums[nextNumIndex];
                    // 如果发现nums[i]已再对应位置上，则其为重复的数字
                    if (nextNum - 1 == nextNumIndex) {
                        return nextNum;
                    }
                    nums[nextNumIndex] = nums[i];
                    nums[i] = nextNum;
                }
            }
            return 0;
        }
    }

}
