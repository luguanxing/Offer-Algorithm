package leetcode.contest.week418;

import java.util.Arrays;
import java.util.Comparator;

public class Test100432_连接二进制表示可形成的最大数值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxGoodNumber(new int[]{1, 2, 3}));
        System.out.println(new Solution().maxGoodNumber(new int[]{2, 8, 16}));
    }

    static class Solution {
        public int maxGoodNumber(int[] nums) {
            String[] strs = new String[3];
            for (int i = 0; i < 3; i++) {
                strs[i] = Integer.toBinaryString(nums[i]);
            }
            Arrays.sort(strs, (Comparator<String>) (o1, o2) -> {
                return Integer.parseInt(o2 + o1, 2) - Integer.parseInt(o1 + o2, 2);
            });
            return Integer.parseInt(strs[0] + strs[1] + strs[2], 2);
        }
    }

}
