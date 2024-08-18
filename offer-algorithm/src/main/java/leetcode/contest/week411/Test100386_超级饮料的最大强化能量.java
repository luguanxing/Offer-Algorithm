package leetcode.contest.week411;

public class Test100386_超级饮料的最大强化能量 {

    public static void main(String[] args) {
        // energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
        System.out.println(new Solution().maxEnergyBoost(new int[]{1, 3, 1}, new int[]{3, 1, 1}));
        // energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]
        System.out.println(new Solution().maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
        // [4,3,4,4,3,6,5,5] [4,6,4,4,5,3,4,4]
        System.out.println(new Solution().maxEnergyBoost(new int[]{4, 3, 4, 4, 3, 6, 5, 5}, new int[]{4, 6, 4, 4, 5, 3, 4, 4}));
    }

    static class Solution {
        public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
            int len = energyDrinkA.length;
            long[] dp1 = new long[len];
            long[] dp2 = new long[len];
            dp1[0] = energyDrinkA[0];
            dp1[1] = Math.max(dp1[0] + energyDrinkA[1], energyDrinkB[0]);
            dp2[0] = energyDrinkB[0];
            dp2[1] = Math.max(dp2[0] + energyDrinkB[1], energyDrinkA[0]);
            for (int i = 2; i < len; i++) {
                dp1[i] = Math.max(dp1[i - 1] + energyDrinkA[i], dp2[i - 2] + energyDrinkA[i]);
                dp2[i] = Math.max(dp2[i - 1] + energyDrinkB[i], dp1[i - 2] + energyDrinkB[i]);
            }
            return Math.max(dp1[len - 1], dp2[len - 1]);
        }
    }

}
