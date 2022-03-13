package leetcode.contest.week284;

import java.util.*;
import java.util.stream.Collectors;

public class Test5227_K次操作后最大化顶端元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTop(new int[]{5, 2, 2, 4, 0, 6}, 4));
        System.out.println(new Solution().maximumTop(new int[]{5, 2, 2, 4, 0, 6, 5}, 4));
        System.out.println(new Solution().maximumTop(new int[]{5, 2, 2, 4, 8, 6, 5}, 4));
        System.out.println(new Solution().maximumTop(new int[]{2}, 1));
        System.out.println(new Solution().maximumTop(new int[]{99, 95, 68, 24, 18}, 69));
        System.out.println(new Solution().maximumTop(new int[]{99, 95, 68, 24, 18}, 68));
        System.out.println(new Solution().maximumTop(new int[]{31, 15, 92, 84, 19, 92, 55}, 4));
        System.out.println(new Solution().maximumTop(new int[]{68, 76, 53, 73, 85, 87, 58, 24, 48, 59, 38, 80, 38, 65, 90, 38, 45, 22, 3, 28, 11}, 1));
        System.out.println(new Solution().maximumTop(new int[]{18}, 3));
        System.out.println(new Solution().maximumTop(new int[]{17, 61, 5, 1, 44}, 100));
        System.out.println(new Solution().maximumTop(new int[]{17, 61}, 1));
        System.out.println(new Solution().maximumTop(new int[]{17, 61}, 2));
        System.out.println(new Solution().maximumTop(new int[]{17, 61}, 3));
        System.out.println(new Solution().maximumTop(new int[]{17, 61}, 4));
        System.out.println(new Solution().maximumTop(new int[]{4, 6, 1, 0, 6, 2, 4}, 0));
    }

    static class Solution {
        public int maximumTop(int[] nums, int k) {
            if (k == 0) {
                return nums[0];
            }
            int len = nums.length;
            // 只有一个数，且操作奇数次时，最后必空
            if (len == 1 && k % 2 == 1) {
                return -1;
            }
            // 若k==len时，先取出k-1个数，然后放回一个最大的
            if (k == len) {
                return Arrays.stream(nums, 0, k - 1).max().orElse(0);
            }
            // 若k<len时，先取出k-1个数，看是放回更大还是继续取出一个更大
            if (k < len) {
                int before = Arrays.stream(nums, 0, k - 1).max().orElse(0);
                int next = nums[k];
                return Math.max(before, next);
            }
            // 若k>len时，先把数全部取出，通过放入一个大数或一个小数大数或一个大数撤回消耗1~2个k
            return Arrays.stream(nums).max().orElse(0);
        }
    }

}
