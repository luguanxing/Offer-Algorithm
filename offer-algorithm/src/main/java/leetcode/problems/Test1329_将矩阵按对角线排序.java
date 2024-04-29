package leetcode.problems;

import java.util.*;

public class Test1329_将矩阵按对角线排序 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int height = mat.length;
            int width = mat[0].length;
            List<List<Integer>> lists = new ArrayList<>();
            for (int y = height; y >= 0; y--) {
                lists.add(addList(mat, y, 0));
            }
            for (int x = 1; x < width; x++) {
                lists.add(addList(mat, 0, x));
            }
            for (List<Integer> list : lists) {
                Collections.sort(list);
            }
            int idx = 0;
            for (int y = height; y >= 0; y--) {
                setList(lists.get(idx++), mat, y, 0);
            }
            for (int x = 1; x < width; x++) {
                setList(lists.get(idx++), mat, 0, x);
            }
            return mat;
        }

        private List<Integer> addList(int[][] mat, int y, int x) {
            int height = mat.length;
            int width = mat[0].length;
            List<Integer> list = new ArrayList<>();
            while (y < height && x < width) {
                list.add(mat[y][x]);
                y++;
                x++;
            }
            return list;
        }

        private void setList(List<Integer> list, int[][] mat, int y, int x) {
            int height = mat.length;
            int width = mat[0].length;
            int i = 0;
            while (y < height && x < width) {
                mat[y][x] = list.get(i);
                y++;
                x++;
                i++;
            }
        }
    }

}
