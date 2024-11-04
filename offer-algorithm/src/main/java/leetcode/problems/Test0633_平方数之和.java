package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test0633_平方数之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(5)); // true
        System.out.println(new Solution().judgeSquareSum(3)); // false
        System.out.println(new Solution().judgeSquareSum(4)); // true
        System.out.println(new Solution().judgeSquareSum(2)); // true
        System.out.println(new Solution().judgeSquareSum(1)); // true
        System.out.println(new Solution().judgeSquareSum(0)); // true
    }

    static class Solution {
        public boolean judgeSquareSum(int c) {
            Set<Long> set = new HashSet<>();
            for (long i = 0; i * i <= c; i++) {
                set.add(i * i);
            }
            for (long square : set) {
                if (set.contains(c - square)) {
                    return true;
                }
            }
            return false;
        }
    }

}
