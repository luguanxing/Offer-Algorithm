package leetcode.problems;

public class Test0299_猜数字游戏 {

    public static void main(String[] args) {
        // secret = "1807", guess = "7810"
        System.out.println(new Solution().getHint("1807", "7810"));
        // secret = "1123", guess = "0111"
        System.out.println(new Solution().getHint("1123", "0111"));
    }

    static class Solution {
        public String getHint(String secret, String guess) {
            int len = secret.length();
            int bulls = 0;
            int cows = 0;
            int[] map1 = new int[10];
            int[] map2 = new int[10];
            for (int i = 0; i < len; i++) {
                char c1 = secret.charAt(i);
                char c2 = guess.charAt(i);
                if (c1 == c2) {
                    bulls++;
                    continue;
                }
                map1[c1 - '0']++;
                map2[c2 - '0']++;
            }
            for (int i = 0; i < 10; i++) {
                cows += Math.min(map1[i], map2[i]);
            }
            return bulls + "A" + cows + "B";
        }
    }

    static class Solution_Old {
        public String getHint(String secret, String guess) {
            int cntA = 0;
            int cntB = 0;
            int[] map = new int[10];
            char[] chars1 = secret.toCharArray();
            char[] chars2 = guess.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] == chars2[i]) {
                    cntA++;
                } else {
                    map[chars1[i] - '0']++;
                }
            }
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                    if (map[chars2[i] - '0'] > 0) {
                        map[chars2[i] - '0']--;
                        cntB++;
                    }
                }
            }
            return cntA + "A" + cntB + "B";
        }
    }

}
