package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Test0128_最长连续序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new Solution().longestConsecutive(new int[]{100, 101, 102, 200, 1, 2}));
        System.out.println(new Solution().longestConsecutive(new int[]{0, -1}));
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            // 转换成集合
            Set<Integer> numSet = new HashSet<>();
            Arrays.stream(nums).forEach(numSet::add);
            // 找出最长的连续数
            int maxLen = 0;
            while (!numSet.isEmpty()) {
                int len = 1;
                int num = numSet
                        .stream()
                        .findFirst()
                        .orElse(0);
                numSet.remove(num);
                // 往左右探测，同时删除集合里的数
                int right = num + 1;
                int left = num - 1;
                while (numSet.contains(right)) {
                    len++;
                    numSet.remove(right++);
                }
                while (numSet.contains(left)) {
                    len++;
                    numSet.remove(left--);
                }
                maxLen = Math.max(maxLen, len);
            }
            return maxLen;
        }
    }

}
