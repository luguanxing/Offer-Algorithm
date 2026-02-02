package leetcode.problems;

public class Test3637_三段式数组I {

    public static void main(String[] args) {
        System.out.println(new Solution().isTrionic(new int[]{1, 3, 5, 4, 2, 6}));
        System.out.println(new Solution().isTrionic(new int[]{2, 1, 3}));
        System.out.println(new Solution().isTrionic(new int[]{1, 2, 3}));
        System.out.println(new Solution().isTrionic(new int[]{3, 7, 1}));
        System.out.println(new Solution().isTrionic(new int[]{8, 9, 4, 6, 1}));
    }

    static class Solution {
        public boolean isTrionic(int[] nums) {
            int len = nums.length;
            int a = 1;
            while (a < len && nums[a - 1] < nums[a]) {
                a++;
            }
            int b = a;
            while (b < len && nums[b - 1] > nums[b]) {
                b++;
            }
            int c = b;
            while (c < len && nums[c - 1] < nums[c]) {
                c++;
            }
            return c > b && b > a && a > 1 && c == len;
        }
    }

}
