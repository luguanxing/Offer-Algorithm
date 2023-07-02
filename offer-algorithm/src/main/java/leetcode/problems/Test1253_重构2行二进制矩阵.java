package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1253_重构2行二进制矩阵 {

    public static void main(String[] args) {
        System.out.println(new Solution().reconstructMatrix(2, 1, new int[]{1, 1, 1}));
        System.out.println(new Solution().reconstructMatrix(2, 3, new int[]{2, 2, 1, 1}));
        System.out.println(new Solution().reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
        System.out.println(new Solution().reconstructMatrix(4, 7, new int[]{2, 1, 2, 2, 1, 1, 1}));
    }

    static class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            int len = colsum.length;
            for (int i = 0; i < len; i++) {
                list1.add(0);
                list2.add(0);
            }
            // 先分配2，再优分配1
            for (int i = 0; i < len; i++) {
                int cs = colsum[i];
                if (cs == 2) {
                    if (upper > 0 && lower > 0) {
                        list1.set(i, 1);
                        list2.set(i, 1);
                        upper--;
                        lower--;
                    } else {
                        return list;
                    }
                }
            }
            for (int i = 0; i < len; i++) {
                int cs = colsum[i];
                if (cs == 1) {
                    if (upper > 0) {
                        list1.set(i, 1);
                        list2.set(i, 0);
                        upper--;
                    } else if (lower > 0) {
                        list1.set(i, 0);
                        list2.set(i, 1);
                        lower--;
                    } else {
                        return list;
                    }
                }
            }
            if (lower != 0 || upper != 0) {
                return list;
            }
            list.add(list1);
            list.add(list2);
            return list;
        }
    }

}
