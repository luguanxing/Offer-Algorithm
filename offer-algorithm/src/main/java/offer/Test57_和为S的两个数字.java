package offer;

import java.util.ArrayList;

public class Test57_和为S的两个数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().FindNumbersWithSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 10));
    }

    static class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            ArrayList<Integer> nums = new ArrayList<>();
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                // 两数差越大积越小
                int current = array[left] + array[right];
                if (current < sum) {
                    left++;
                } else if (current > sum) {
                    right--;
                } else {
                    nums.add(array[left]);
                    nums.add(array[right]);
                    return nums;
                }
            }
            return nums;
        }
    }

}
