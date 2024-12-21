package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test2545_根据第K场考试的分数排序 {

    public static void main(String[] args) {
        // score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
        int[][] score1 = new int[][]{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}};
        score1 = new Solution().sortTheStudents(score1, 2);
        for (int[] ints : score1) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        // score = [[3,4],[5,6]], k = 0
        int[][] score2 = new int[][]{{3, 4}, {5, 6}};
        score2 = new Solution().sortTheStudents(score2, 0);
        for (int[] ints : score2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, Comparator.comparingInt(a -> -a[k]));
            return score;
        }
    }

}
