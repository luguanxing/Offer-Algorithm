package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test0658_找到K个最接近的元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().findClosestElements(
                new int[]{1, 2, 3, 4, 5},
                4, 3
        ));
        System.out.println(new Solution().findClosestElements(
                new int[]{1, 2, 3, 4, 5},
                4, -1
        ));
    }

    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int len = arr.length;
            int[][] tuples = new int[len][2];
            for (int i = 0; i < len; i++) {
                int[] tuple = new int[2];
                tuple[0] = arr[i];
                tuple[1] = Math.abs(arr[i] - x);
                tuples[i] = tuple;
            }
            Arrays.sort(tuples, (tuple1, tuple2) -> {
                int src1 = tuple1[0];
                int abs1 = tuple1[1];
                int src2 = tuple2[0];
                int abs2 = tuple2[1];
                if (abs1 == abs2) {
                    return Integer.compare(src1, src2);
                }
                return Integer.compare(abs1, abs2);
            });
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                list.add(tuples[i][0]);
            }
            Collections.sort(list);
            return list;
        }
    }

}
