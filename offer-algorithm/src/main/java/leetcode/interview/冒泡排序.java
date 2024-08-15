package leetcode.interview;

import java.util.Arrays;

public class 冒泡排序 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 6, 4};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < n; i++) {
            // 每次把前面最大的放到第n-i位（后面的都是排序好的）
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

}
