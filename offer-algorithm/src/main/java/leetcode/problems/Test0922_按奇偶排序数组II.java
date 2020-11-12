package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Test0922_按奇偶排序数组II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(
                new int[]{4, 2, 5, 7}
        )));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(
                new int[]{4, 2, 6, 9, 5, 7}
        )));
    }

    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            Queue<Integer> oddNumInEvenIndex = new ArrayDeque<>();
            Queue<Integer> evenNumInOddIndex = new ArrayDeque<>();
            for (int i = 0; i < A.length; i++) {
                if (i % 2 == 0 && A[i] % 2 == 1) {
                    // 当前为偶数位的奇数，需要找奇数位的偶数
                    if (!evenNumInOddIndex.isEmpty()) {
                        int index = evenNumInOddIndex.poll();
                        int tmp = A[i];
                        A[i] = A[index];
                        A[index] = tmp;
                    } else {
                        oddNumInEvenIndex.add(i);
                    }
                } else if (i % 2 == 1 && A[i] % 2 == 0) {
                    // 当前为奇数位的偶数，需要找偶数位的奇数
                    if (!oddNumInEvenIndex.isEmpty()) {
                        int index = oddNumInEvenIndex.poll();
                        int tmp = A[i];
                        A[i] = A[index];
                        A[index] = tmp;
                    } else {
                        evenNumInOddIndex.add(i);
                    }
                }
            }
            return A;
        }
    }

}
