package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0212_单词搜索II {

    public static void main(String[] args) {
        System.out.println(new Solution().findWords(
                new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}
        ));
        System.out.println(new Solution().findWords(
                new char[][]{{'a', 'b'}, {'c', 'd'}},
                new String[]{"abcb"}
        ));
    }

    static class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            for (String word : words) {
                // 逐个单词判断能否找到
                if (dfsFind(board, word)) {
                    res.add(word);
                }
            }
            return res;
        }

        boolean isOk;
        boolean[][] isVisited;
        String targetStr;
        String currentStr;

        private boolean dfsFind(char[][] board, String word) {
            // 检查borad是否包含所有需要的子串
            int[] map = new int[26];
            for (char[] chars : board) {
                for (char c : chars) {
                    map[c - 'a']++;
                }
            }
            for (char c : word.toCharArray()) {
                if (--map[c - 'a'] < 0) {
                    return false;
                }
            }
            // 走word.length步看能否组成word
            isOk = false;
            targetStr = word;
            currentStr = "";
            isVisited = new boolean[board.length][board[0].length];
            for (int y = 0; y < board.length; y++) {
                for (int x = 0; x < board[0].length; x++) {
                    if (word.charAt(0) == board[y][x]) {
                        dfs(board, y, x, word.length());
                    }
                }
            }
            return isOk;
        }

        private void dfs(char[][] board, int y, int x, int length) {
            if (length == 0 && targetStr.equals(currentStr)) {
                isOk = true;
                return;
            }
            if (!targetStr.startsWith(currentStr)) {
                return;
            }
            if (y < 0 || board.length <= y || x < 0 || board[0].length <= x || isVisited[y][x]) {
                return;
            }
            char c = board[y][x];
            currentStr += c;
            isVisited[y][x] = true;
            dfs(board, y, x + 1, length - 1);
            dfs(board, y, x - 1, length - 1);
            dfs(board, y + 1, x, length - 1);
            dfs(board, y - 1, x, length - 1);
            currentStr = currentStr.substring(0, currentStr.length() - 1);
            isVisited[y][x] = false;
        }
    }

}
