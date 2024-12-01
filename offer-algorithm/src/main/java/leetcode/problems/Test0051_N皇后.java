package leetcode.problems;

import java.util.*;

public class Test0051_N皇后 {

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
        System.out.println(new Solution().solveNQueens(1));
    }

    static class Solution {
        List<List<String>> globalResult = new ArrayList<>();
        List<String> currents = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            for (int i = 1; i <= n; i++) {
                String str = "";
                for (int j = 1; j <= n; j++) {
                    str += ".";
                }
                currents.add(str);
            }
            dfs(0, n);
            return globalResult;
        }

        private void dfs(int index, int n ) {
            if (index == n) {
                globalResult.add(new ArrayList<>(currents));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (isValid(index, i, n)) {
                    currents.set(index, currents.get(index).substring(0, i) + "Q" + currents.get(index).substring(i+1));
                    dfs(index + 1, n);
                    currents.set(index, currents.get(index).substring(0, i) + "." + currents.get(index).substring(i+1));
                }
            }
        }

        private boolean isValid(int y, int x, int n) {
            // 判断列
            for (int i = y-1; i >= 0; i--) {
                if (currents.get(i).charAt(x) == 'Q') {
                    return false;
                }
            }
            for (int i = y+1; i < n; i++) {
                if (currents.get(i).charAt(x) == 'Q') {
                    return false;
                }
            }
            // 判断行
            for (int i = x-1; i >= 0; i--) {
                if (currents.get(y).charAt(i) == 'Q') {
                    return false;
                }
            }
            for (int i = x+1; i < n; i++) {
                if (currents.get(y).charAt(i) == 'Q') {
                    return false;
                }
            }
            // 判断斜对角线
            for (int i = y-1, j = x-1; i >= 0 && j >= 0; i--, j--) {
                if (currents.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            for (int i = y+1, j = x+1; i < n && j < n; i++, j++) {
                if (currents.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            for (int i = y-1, j = x+1; i >= 0 && j < n; i--, j++) {
                if (currents.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            for (int i = y+1, j = x-1; i < n && j >= 0; i++, j--) {
                if (currents.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }

}
