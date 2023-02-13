package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test1138_字母板上的路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().alphabetBoardPath("leet"));
        System.out.println(new Solution().alphabetBoardPath("code"));
        System.out.println(new Solution().alphabetBoardPath("zb"));
    }

    static class Solution {
        private Map<Character, int[]> map = new HashMap<>();
        int y;
        int x;

        public String alphabetBoardPath(String target) {
            y = 0;
            x = 0;
            for (int i = 0; i < 26; i++) {
                map.put((char) ('a' + i), new int[]{i / 5, i % 5});
            }
            String res = "";
            for (char t : target.toCharArray()) {
                res += go(t);
            }
            return res;
        }

        private String go(char t) {
            String path = "";
            if (y == 5 && x == 0 && t != 'z') {
                y--;
                path += 'U';
            }
            int ty = map.get(t)[0];
            int tx = map.get(t)[1];
            for (int i = 0; i < Math.abs(x - tx); i++) {
                path += (x < tx) ? 'R' : 'L';
            }
            for (int i = 0; i < Math.abs(y - ty); i++) {
                path += (y < ty) ? 'D' : 'U';
            }
            x = tx;
            y = ty;
            return path + "!";
        }
    }

}
