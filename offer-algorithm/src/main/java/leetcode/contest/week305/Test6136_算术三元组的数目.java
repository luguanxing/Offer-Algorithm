package leetcode.contest.week305;

import java.util.Set;
import java.util.TreeSet;

public class Test6136_算术三元组的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
        System.out.println(new Solution().arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
    }

    static class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            Set<Integer> set = new TreeSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int num : nums) {
                if (set.contains(num + diff) && set.contains(num + diff * 2)) {
                    res++;
                }
            }
            return res;
        }
    }

}
