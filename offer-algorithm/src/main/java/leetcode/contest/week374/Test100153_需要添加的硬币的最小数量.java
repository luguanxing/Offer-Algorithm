package leetcode.contest.week374;

import java.util.*;

public class Test100153_需要添加的硬币的最小数量 {

    public static void main(String[] args) {
        // coins = [1,4,10], target = 19
        System.out.println(new Solution().minimumAddedCoins(new int[]{1, 4, 10}, 19));
        // coins = [1,4,10,5,7,19], target = 19
        System.out.println(new Solution().minimumAddedCoins(new int[]{1, 4, 10, 5, 7, 19}, 19));
        // coins = [1,1,1], target = 20
        System.out.println(new Solution().minimumAddedCoins(new int[]{1, 1, 1}, 20));
    }

    /*
        给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
        如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
        返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
        数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
     */
    static class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);

            int count = 0; // 需要添加的硬币数量
            int currentMax = 0; // 当前覆盖的最大金额
            for (int coin : coins) {
                // 当前硬币面值大于currentMax+1时，说明存在覆盖不到的金额
                while (coin > currentMax + 1) {
                    // 添加一个面值为currentMax+1的硬币
                    currentMax += currentMax + 1;
                    count++;
                    if (currentMax >= target) {
                        // 已覆盖到target，结束循环
                        return count;
                    }
                }
                // 更新当前覆盖的最大金额
                currentMax += coin;
                if (currentMax >= target) {
                    // 已覆盖到target，结束循环
                    return count;
                }
            }

            // 处理剩余未覆盖的金额
            while (currentMax < target) {
                currentMax += currentMax + 1;
                count++;
            }

            return count;
        }
    }

}
