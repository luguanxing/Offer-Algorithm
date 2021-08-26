package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test0881_救生艇 {

    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(
                new int[]{1, 2}, 3
        ));
        System.out.println(new Solution().numRescueBoats(
                new int[]{3, 2, 2, 1}, 3
        ));
        System.out.println(new Solution().numRescueBoats(
                new int[]{3, 5, 3, 4}, 5
        ));
        System.out.println(new Solution().numRescueBoats(
                new int[]{5, 1, 4, 2}, 6
        ));
        System.out.println(new Solution().numRescueBoats(
                new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50
        ));
    }

    static class Solution {
        public int numRescueBoats(int[] people, int limit) {
            List<Integer> list = Arrays
                    .stream(people)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
            int res = 0;
            while (!list.isEmpty()) {
                int big = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                res++;
                if (!list.isEmpty() && big + list.get(0) <= limit) {
                    list.remove(0);
                }
            }
            return res;
        }
    }

    static class Solution_不止两人 {
        public int numRescueBoats(int[] people, int limit) {
            List<Integer> list = Arrays
                    .stream(people)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(list);
            int res = 0;
            while (!list.isEmpty()) {
                int big = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                res++;
                System.out.print(big + " -> ");
                while (!list.isEmpty() && big + list.get(0) <= limit) {
                    System.out.print(list.get(0) + ",");
                    big = big + list.get(0);
                    list.remove(0);
                }
                System.out.println();
            }
            return res;
        }
    }

}
