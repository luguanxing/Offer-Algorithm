package leetcode.problems;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Test0667_优美的排列II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArray(3, 1)));
        System.out.println(Arrays.toString(new Solution().constructArray(3, 2)));
        System.out.println(Arrays.toString(new Solution().constructArray(4, 3)));
        System.out.println(Arrays.toString(new Solution().constructArray(4, 2)));
        System.out.println(Arrays.toString(new Solution().constructArray(4, 1)));
        System.out.println(Arrays.toString(new Solution().constructArray(10, 4)));
    }

    static class Solution {
        public int[] constructArray(int n, int k) {
            // 编数字n (n-k) (n-1) (n-k+1) (n-2) (n-k+2)... (n-k-1) (n-k-2)...1
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            for (int i = 0; i < k; i++) {
                set.add(n - i);
                set.add(n - k + i);
            }
            for (int i = n - k; i >= 1; i--) {
                set.add(i);
            }
            int[] res = new int[n];
            int idx = 0;
            for (int num : set) {
                res[idx++] = num;
            }
            return res;
        }
    }

}
