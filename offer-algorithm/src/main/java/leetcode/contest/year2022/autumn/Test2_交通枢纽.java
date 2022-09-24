package leetcode.contest.year2022.autumn;

import java.util.HashSet;
import java.util.Set;

public class Test2_交通枢纽 {

    public static void main(String[] args) {
        System.out.println(new Solution().transportationHub(new int[][]{
                {0, 1}, {0, 3}, {1, 3}, {2, 0}, {2, 3}
        }));
        System.out.println(new Solution().transportationHub(new int[][]{
                {0, 3}, {1, 0}, {1, 3}, {2, 0}, {3, 0}, {3, 2}
        }));
    }

    static class Solution {
        public int transportationHub(int[][] path) {
            int MAX = 1005;
            int[] from = new int[MAX];
            int[] to = new int[MAX];
            Set<Integer> set = new HashSet<>();
            for (int[] inOut : path) {
                int f = inOut[0];
                int t = inOut[1];
                from[f]++;
                to[t]++;
                set.add(f);
                set.add(t);
            }
            for (int p = 0; p < MAX; p++) {
                if (from[p] == 0 && to[p] == set.size() - 1) {
                    return p;
                }
            }
            return -1;
        }
    }

}
