package leetcode.problems;

import java.util.*;

public class Test2094_找出3位偶数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 1, 3, 0})));
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 2, 8, 8, 2})));
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{3, 7, 5})));
    }

    static class Solution {
        public int[] findEvenNumbers(int[] digits) {
            int len = digits.length;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    for (int k = 0; k < len; k++) {
                        if (i == j || i == k || j == k) {
                            continue;
                        }
                        if (digits[i] == 0 || digits[k] % 2 == 1) {
                            continue;
                        }
                        set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
            int[] res = new int[set.size()];
            int idx = 0;
            for (int num : set) {
                res[idx++] = num;
            }
            Arrays.sort(res);
            return res;
        }
    }

}
