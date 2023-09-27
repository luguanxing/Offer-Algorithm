package leetcode.problems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1333_餐厅过滤器 {

    public static void main(String[] args) {
        System.out.println(new Solution().filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 1, 50, 10));
        System.out.println(new Solution().filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 0, 50, 10));
        System.out.println(new Solution().filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 0, 30, 3));
    }

    static class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            return Stream.of(restaurants)
                    .filter(restaurant -> veganFriendly == 0 || (veganFriendly == 1 && restaurant[2] == 1))
                    .filter(restaurant -> restaurant[3] <= maxPrice)
                    .filter(restaurant -> restaurant[4] <= maxDistance)
                    .sorted((r1, r2) -> {
                        if (r1[1] != r2[1]) {
                            return Integer.compare(r2[1], r1[1]);
                        } else {
                            return Integer.compare(r2[0], r1[0]);
                        }
                    })
                    .map(restaurant -> restaurant[0])
                    .collect(Collectors.toList());
        }
    }

}
