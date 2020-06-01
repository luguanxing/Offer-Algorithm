package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1431_拥有最多糖果的孩子 {

    public static void main(String[] args) {
        System.out.println(new Solution().kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(new Solution().kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(new Solution().kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            if (candies == null) {
                return null;
            }
            int max = Arrays
                    .stream(candies)
                    .max()
                    .orElse(0);
            return Arrays
                    .stream(candies)
                    .boxed()
                    .map(num -> num + extraCandies >= max)
                    .collect(Collectors.toList());
        }
    }

}
