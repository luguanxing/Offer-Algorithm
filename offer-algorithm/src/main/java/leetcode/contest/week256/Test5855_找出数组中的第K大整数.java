package leetcode.contest.week256;

import java.util.Arrays;

public class Test5855_找出数组中的第K大整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().kthLargestNumber(
                new String[]{"3", "6", "7", "10"},
                4
        ));
        System.out.println(new Solution().kthLargestNumber(
                new String[]{"2", "21", "12", "1"},
                3
        ));
        System.out.println(new Solution().kthLargestNumber(
                new String[]{"0", "0"},
                2
        ));
    }

    static class Solution {
        public String kthLargestNumber(String[] nums, int k) {
            int maxLen = Arrays.stream(nums)
                    .map(String::length)
                    .max(Integer::compareTo)
                    .get();
            for (int i = 0; i < nums.length; i++) {
                String currentNum = nums[i];
                while (currentNum.length() < maxLen) {
                    currentNum = '0' + currentNum;
                }
                nums[i] = currentNum;
            }
            Arrays.sort(nums);
            String res = nums[nums.length - k];
            while (res.startsWith("0") && res.length() > 1) {
                res = res.substring(1);
            }
            return res;
        }
    }

}
