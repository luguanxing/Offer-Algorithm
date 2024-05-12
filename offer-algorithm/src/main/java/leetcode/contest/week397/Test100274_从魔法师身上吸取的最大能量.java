package leetcode.contest.week397;

import java.util.Arrays;

public class Test100274_从魔法师身上吸取的最大能量 {

    public static void main(String[] args) {
        // energy = [5,2,-10,-5,1], k = 3
        System.out.println(new Solution().maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
        // energy = [-2,-3,-1], k = 2
        System.out.println(new Solution().maximumEnergy(new int[]{-2, -3, -1}, 2));
    }

    static class Solution {
        public int maximumEnergy(int[] energy, int k) {
            int[] res = new int[k];
            for (int i = 0; i < energy.length; i++) {
                if (res[i % k] < 0) {
                    res[i % k] = 0;
                }
                res[i % k] += energy[i];
            }
            return Arrays.stream(res).max().getAsInt();
        }
    }

}
