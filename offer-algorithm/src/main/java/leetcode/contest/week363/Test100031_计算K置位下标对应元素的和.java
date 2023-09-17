package leetcode.contest.week363;

import java.util.*;

public class Test100031_计算K置位下标对应元素的和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumIndicesWithKSetBits(
                Arrays.asList(5, 10, 1, 5, 2), 1
        ));
        System.out.println(new Solution().sumIndicesWithKSetBits(
                Arrays.asList(4, 3, 2, 1), 2
        ));
    }

    static class Solution {
        public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                int cnt = 0;
                for (char c : Integer.toBinaryString(i).toCharArray()) {
                    if (c == '1') {
                        cnt++;
                    }
                }
                if (cnt == k) {
                    sum += nums.get(i);
                }
            }
            return sum;
        }
    }

}
