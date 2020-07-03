package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test378_有序矩阵中第K小的元素 {

    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            List<Integer> list = new ArrayList<>();
            for (int[] nums : matrix) {
                Arrays.stream(nums).forEach(list::add);
            }
            Collections.sort(list);
            return list.get(k - 1);
        }
    }

}
