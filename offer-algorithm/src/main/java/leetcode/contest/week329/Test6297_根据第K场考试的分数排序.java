package leetcode.contest.week329;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Test6297_根据第K场考试的分数排序 {

    public static void main(String[] args) {
        for (int[] s : new Solution().sortTheStudents(new int[][]{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, 2)) {
            System.out.println(Arrays.toString(s));
        }
        for (int[] s : new Solution().sortTheStudents(new int[][]{{3, 4}, {5, 6}}, 0)) {
            System.out.println(Arrays.toString(s));
        }
    }

    static class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            int height = score.length;
            int width = score[0].length;
            TreeMap<Integer, int[]> map = new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < height; i++) {
                map.put(score[i][k], score[i]);
            }
            int[][] newScore = new int[height][width];
            int idx = 0;
            for (int[] s : map.values()) {
                newScore[idx++] = s;
            }
            return newScore;
        }
    }

}
