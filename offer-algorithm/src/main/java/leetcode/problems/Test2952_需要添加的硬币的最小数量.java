package leetcode.problems;

import java.util.*;

public class Test2952_需要添加的硬币的最小数量 {

    public static void main(String[] args) {
        // coins = [1,4,10], target = 19
        System.out.println(new Solution().minimumAddedCoins(new int[]{1, 4, 10}, 19));
        // coins = [1,4,10,5,7,19], target = 19
        System.out.println(new Solution().minimumAddedCoins(new int[]{1, 4, 10, 5, 7, 19}, 19));
        // coins = [1,1,1], target = 20
        System.out.println(new Solution().minimumAddedCoins(new int[]{1, 1, 1}, 20));
    }

    static class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            // 枚举需要增加的数量和覆盖的范围
            int count = 0;
            int currentMax = 0;
            for (int coin : coins) {
                // 当前硬币面值大于currentMax+1时，说明存在覆盖不到的下一个连续金额currentMax+1
                while (coin > currentMax + 1) {
                    count++;
                    currentMax += currentMax + 1;
                }
                // 更新当前能覆盖的连续金额
                currentMax += coin;
                if (currentMax >= target) {
                    return count;
                }
            }
            // 若还未能覆盖，一直叠加覆盖不到的下一个连续金额currentMax+1
            while (currentMax < target) {
                count++;
                currentMax += currentMax + 1;
            }
            return count;
        }
    }

}
