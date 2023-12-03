package leetcode.contest.week374;

import java.util.ArrayList;
import java.util.List;

public class Test100144_找出峰值 {

    public static void main(String[] args) {
        // mountain = [2,4,4]
        System.out.println(new Solution().findPeaks(new int[]{2, 4, 4}));
        // mountain = [1,4,3,8,5]
        System.out.println(new Solution().findPeaks(new int[]{1, 4, 3, 8, 5}));
    }

    static class Solution {
        public List<Integer> findPeaks(int[] mountain) {
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i < mountain.length - 1; i++) {
                if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                    result.add(i);
                }
            }
            return result;
        }
    }

}
