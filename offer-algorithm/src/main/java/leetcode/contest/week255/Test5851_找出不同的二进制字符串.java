package leetcode.contest.week255;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test5851_找出不同的二进制字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().findDifferentBinaryString(
                new String[]{"01", "10"}
        ));
        System.out.println(new Solution().findDifferentBinaryString(
                new String[]{"00", "01"}
        ));
        System.out.println(new Solution().findDifferentBinaryString(
                new String[]{"111", "011", "001"}
        ));
    }

    static class Solution {
        public String findDifferentBinaryString(String[] nums) {
            Set<String> set = Arrays.stream(nums).collect(Collectors.toSet());
            String res = "";
            for (int i = 0; i <= (1 << nums.length); i++) {
                String current = Integer.toBinaryString(i);
                while (current.length() < nums.length) {
                    current = "0" + current;
                }
                if (!set.contains(current)) {
                    return current;
                }
            }
            return res;
        }
    }

}
