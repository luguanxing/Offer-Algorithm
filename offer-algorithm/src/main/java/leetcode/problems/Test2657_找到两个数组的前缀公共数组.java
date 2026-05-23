package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2657_找到两个数组的前缀公共数组 {

    public static void main(String[] args) {
        // A = [1,3,2,4], B = [3,1,2,4]
        System.out.println(Arrays.toString(
                new Solution().findThePrefixCommonArray(
                        new int[]{1, 3, 2, 4},
                        new int[]{3, 1, 2, 4}
                ))
        );
        // A = [2,3,1], B = [3,1,2]
        System.out.println(Arrays.toString(
                new Solution().findThePrefixCommonArray(
                        new int[]{2, 3, 1},
                        new int[]{3, 1, 2}
                ))
        );
    }

    static class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            int MAX = 100;
            int len = A.length;
            int[] res = new int[len];
            boolean[] mapA = new boolean[MAX];
            boolean[] mapB = new boolean[MAX];
            int current = 0;
            for (int i = 0; i < len; i++) {
                mapA[A[i]] = true;
                mapB[B[i]] = true;
                if (mapA[B[i]]) {
                    current++;
                }
                if (mapB[A[i]]) {
                    current++;
                }
                if (A[i] == B[i]) {
                    current--;
                }
                res[i] = current;
            }
            return res;
        }
    }

}
