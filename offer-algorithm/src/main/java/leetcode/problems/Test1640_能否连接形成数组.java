package leetcode.problems;

import java.util.Arrays;

public class Test1640_能否连接形成数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().canFormArray(
                new int[]{15, 88},
                new int[][]{{88}, {15}}
        ));
        System.out.println(new Solution().canFormArray(
                new int[]{49, 18, 16},
                new int[][]{{16, 18, 49}}
        ));
        System.out.println(new Solution().canFormArray(
                new int[]{91, 4, 64, 78},
                new int[][]{{78}, {4, 64}, {91}}
        ));
        System.out.println(new Solution().canFormArray(
                new int[]{12},
                new int[][]{{1}}
        ));
    }

    static class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            // 内部相对顺序不变即可
            String arrStr = Arrays.toString(arr);
            arrStr = arrStr.substring(1, arrStr.length() - 1) + ",";
            for (int[] piece : pieces) {
                String pieceStr = Arrays.toString(piece);
                if (!arrStr.contains(pieceStr.substring(1, pieceStr.length() - 1) + ",")) {
                    return false;
                }
            }
            return true;
        }
    }

}
