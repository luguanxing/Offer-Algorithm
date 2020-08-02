package leetcode.contest.week200;

public class Test5475_统计好三元组 {

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(new Solution().countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }

    static class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }

}
