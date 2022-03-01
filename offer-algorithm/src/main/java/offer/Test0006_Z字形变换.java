package offer;

import java.util.Arrays;

public class Test0006_Z字形变换 {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
        System.out.println(new Solution().convert("A", 1));
        System.out.println(new Solution().convert("AB", 1));
    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            char[][] martix = new char[numRows][10005];
            dfs(numRows, martix, s.toCharArray(), 0, true, 0, 0);
            String res = "";
            for (char[] line : martix) {
                for (char c : line) {
                    if (c != '\0') {
                        res += c;
                    }
                }
            }
            return res;
        }

        private void dfs(int numRows, char[][] martix, char[] chars, int index, boolean isDown, int y, int x) {
            if (index == chars.length) {
                return;
            }
            martix[y][x] = chars[index];
            // 继续向下或右上
            if (isDown) {
                if (y == numRows - 1) {
                    // 已经向下到底，转折向右上
                    dfs(numRows, martix, chars, index + 1, false, y - 1, x + 1);
                } else {
                    // 还可以继续向下
                    dfs(numRows, martix, chars, index + 1, true, y + 1, x);
                }
            } else {
                if (y == 0) {
                    // 已经向上到顶，转折向右下
                    dfs(numRows, martix, chars, index + 1, true, y + 1, x);
                } else {
                    // 还可以继续向上
                    dfs(numRows, martix, chars, index + 1, false, y - 1, x + 1);
                }
            }
        }
    }

}
