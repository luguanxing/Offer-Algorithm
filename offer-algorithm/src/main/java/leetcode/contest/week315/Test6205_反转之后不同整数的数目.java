package leetcode.contest.week315;

import java.util.HashSet;
import java.util.Set;

public class Test6205_反转之后不同整数的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
        System.out.println(new Solution().countDistinctIntegers(new int[]{2, 2, 2}));
    }

    static class Solution {
        public int countDistinctIntegers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                String revereStr = new StringBuilder(Integer.toString(num))
                        .reverse()
                        .toString();
                set.add(Integer.parseInt(revereStr));
                set.add(num);
            }
            return set.size();
        }
    }

}
