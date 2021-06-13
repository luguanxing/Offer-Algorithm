package leetcode.contest.week245;

public class Test5785_合并若干三元组以形成目标三元组 {

    public static void main(String[] args) {
        System.out.println(new Solution().mergeTriplets(
                new int[][]{{2, 5, 3}, {1, 8, 4}, {1, 7, 5}},
                new int[]{2, 7, 5}
        ));
        System.out.println(new Solution().mergeTriplets(
                new int[][]{{1, 3, 4}, {2, 5, 8}},
                new int[]{2, 5, 8}
        ));
        System.out.println(new Solution().mergeTriplets(
                new int[][]{{2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}},
                new int[]{5, 5, 5}
        ));
        System.out.println(new Solution().mergeTriplets(
                new int[][]{{3, 4, 5}, {4, 5, 6}},
                new int[]{3, 2, 5}
        ));
    }

    static class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {
            int a = target[0];
            int b = target[1];
            int c = target[2];
            int maxA = 0;
            int maxB = 0;
            int maxC = 0;
            for (int[] triplet : triplets) {
                if (triplet[0] <= a && triplet[1] <= b && triplet[2] <= c) {
                    maxA = Math.max(maxA, triplet[0]);
                    maxB = Math.max(maxB, triplet[1]);
                    maxC = Math.max(maxC, triplet[2]);
                }
            }
            return maxA == a && maxB == b && maxC == c;
        }
    }

}
