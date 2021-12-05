package leetcode.contest.week270;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test5942_找出3位偶数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 1, 3, 0})));
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 2, 8, 8, 2})));
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{3, 7, 5})));
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{0, 2, 0, 0})));
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{0, 0, 0})));
    }

    static class Solution {
        public int[] findEvenNumbers(int[] digits) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < digits.length; i++) {
                for (int j = 0; j < digits.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < digits.length; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        int ans = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if (ans >= 100 && ans % 2 == 0) {
                            set.add(ans);
                        }
                    }
                }
            }
            int[] res = new int[set.size()];
            int index = 0;
            for (int ans : set) {
                res[index++] = ans;
            }
            Arrays.sort(res);
            return res;
        }
    }

}
