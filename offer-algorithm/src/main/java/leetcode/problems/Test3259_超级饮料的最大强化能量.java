package leetcode.problems;

public class Test3259_超级饮料的最大强化能量 {

    public static void main(String[] args) {
        // energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
        System.out.println(new Solution().maxEnergyBoost(new int[]{1, 3, 1}, new int[]{3, 1, 1}));
        // energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]
        System.out.println(new Solution().maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
        System.out.println(new Solution().maxEnergyBoost(new int[]{5, 5, 6, 3, 4, 3, 3, 4}, new int[]{5, 3, 3, 4, 4, 6, 6, 3}));
    }

    static class Solution {
        public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
            int len = energyDrinkA.length;
            // 分别以 A 和 B 为最后一个饮料的情况下，最大强化能量
            long[] dpA = new long[len];
            long[] dpB = new long[len];
            dpA[0] = energyDrinkA[0];
            dpA[1] = energyDrinkA[0] + energyDrinkA[1];
            dpB[0] = energyDrinkB[0];
            dpB[1] = energyDrinkB[0] + energyDrinkB[1];
            for (int i = 2; i < len; i++) {
                dpA[i] = Math.max(dpA[i - 1] + energyDrinkA[i], dpB[i - 2] + energyDrinkA[i]);
                dpB[i] = Math.max(dpB[i - 1] + energyDrinkB[i], dpA[i - 2] + energyDrinkB[i]);
            }
            return Math.max(dpA[len - 1], dpB[len - 1]);
        }
    }

}
