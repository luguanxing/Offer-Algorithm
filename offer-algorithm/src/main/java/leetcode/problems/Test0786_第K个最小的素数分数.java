package leetcode.problems;

import java.util.*;

public class Test0786_第K个最小的素数分数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(new Solution().kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }

    static class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            List<Div> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    list.add(new Div(arr[i], arr[j]));
                }
            }
            Collections.sort(list, Comparator.comparingDouble(o -> o.d));
            return new int[]{list.get(k - 1).m, list.get(k - 1).n};
        }

        class Div {
            int m;
            int n;
            double d;

            public Div(int m, int n) {
                this.m = m;
                this.n = n;
                this.d = m * 1.0 / n;
            }
        }
    }

}
