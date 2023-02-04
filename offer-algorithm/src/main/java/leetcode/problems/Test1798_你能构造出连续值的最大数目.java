package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Test1798_你能构造出连续值的最大数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumConsecutive(new int[]{3}));
        System.out.println(new Solution().getMaximumConsecutive(new int[]{1, 3}));
        System.out.println(new Solution().getMaximumConsecutive(new int[]{1, 1, 1, 4}));
        System.out.println(new Solution().getMaximumConsecutive(new int[]{1, 4, 10, 3, 1}));
    }

    static class Solution {
        public int getMaximumConsecutive(int[] coins) {
            // 从小到大排序
            Arrays.sort(coins);
            // 若x以及之前的都能完成，那么遇上新的硬币v时v+x以及之前都能完成
            int max = 1;
            for (int coin : coins) {
                if (max < coin) {
                    break;
                }
                max = max + coin;
            }
            return max;
        }
    }

    static class Solution_暴力 {
        public int getMaximumConsecutive(int[] coins) {
            Set<Integer> sumSet = new TreeSet<>();
            for (int coin : coins) {
                for (int sum : new ArrayList<>(sumSet)) {
                    sumSet.add(sum + coin);
                }
                sumSet.add(coin);
            }
            int res = 1;
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                if (sumSet.contains(i)) {
                    res++;
                } else {
                    break;
                }
            }
            return res;
        }
    }

}
