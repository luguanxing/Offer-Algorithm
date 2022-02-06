package leetcode.contest.week279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test6000_对奇偶下标分别排序 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortEvenOdd(new int[]{4, 1, 2, 3})));
        System.out.println(Arrays.toString(new Solution().sortEvenOdd(new int[]{2, 1})));
    }

    static class Solution {
        public int[] sortEvenOdd(int[] nums) {
            List<Integer> odds = new ArrayList<>();
            List<Integer> evens = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    evens.add(nums[i]);
                } else {
                    odds.add(nums[i]);
                }
            }
            Collections.sort(odds, Collections.reverseOrder());
            Collections.sort(evens);
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 1) {
                    res[i] = odds.get(0);
                    odds.remove(0);
                } else {
                    res[i] = evens.get(0);
                    evens.remove(0);
                }
            }
            return res;
        }
    }

}
