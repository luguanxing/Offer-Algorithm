package offer;

import java.util.Arrays;

public class Test02_数组中重复的数字 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[] dup = new int[1];
        System.out.println(new Solution().duplicate(nums, nums.length, dup));
        System.out.println(dup[0]);
        System.out.println(new Solution_位置迭代法().duplicate(nums, nums.length, dup));
        System.out.println(dup[0]);
    }

    static class Solution {
        public boolean duplicate(int numbers[], int length, int[] duplication) {
            if (length == 0) {
                duplication[0] = -1;
                return false;
            }
            int[] hash = new int[length + 1];
            for (int number : numbers) {
                hash[number]++;
            }
            for (int i = 0; i < length; i++) {
                if (hash[i] > 1) {
                    duplication[0] = i;
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution_位置迭代法 {
        public boolean duplicate(int numbers[], int length, int[] duplication) {
            if (length == 0) {
                duplication[0] = -1;
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (i == numbers[i]) {
                    continue;
                } else {
                    while (numbers[i] != i) {
                        if (numbers[i] == numbers[numbers[i]]) {
                            // 若numbers[i]和numbers[numbers[i]]相等，则该数重复
                            duplication[0] = numbers[i];
                            return true;
                        } else {
                            // 替换numbers[i]和numbers[numbers[i]]的位置
                            int temp = numbers[i];
                            numbers[i] = numbers[numbers[i]];
                            numbers[temp] = temp;
                        }
                    }
                }
            }
            return false;
        }
    }

}
