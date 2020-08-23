package leetcode.contest.week203;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test5496_你可以获得的最大硬币数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(new Solution().maxCoins(new int[]{2, 4, 5}));
        System.out.println(new Solution().maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }

    static class Solution {
        public int maxCoins(int[] piles) {
            List<Integer> list = Arrays.stream(piles).boxed().collect(Collectors.toList());
            Collections.sort(list);
            int sum = 0;
            while (!list.isEmpty()) {
                // 先去掉一个最大，再去掉一个最小，拿剩下最大那个
                list.remove(list.size() - 1);
                list.remove(0);
                sum += list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }
            return sum;
        }
    }

}
