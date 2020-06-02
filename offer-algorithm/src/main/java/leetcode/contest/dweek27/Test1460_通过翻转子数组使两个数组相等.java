package leetcode.contest.dweek27;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test1460_通过翻转子数组使两个数组相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        System.out.println(new Solution().canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
        System.out.println(new Solution().canBeEqual(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }

    static class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            // 如果都存在只是乱序，必能像冒泡一样两两交换归位
            String targetStr = Arrays.stream(target).sorted().boxed().collect(Collectors.toList()).toString();
            String arrStr = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList()).toString();
            return targetStr.equals(arrStr);
        }
    }

}
