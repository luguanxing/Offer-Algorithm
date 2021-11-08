package leetcode.problems;

public class Test0299_猜数字游戏 {

    public static void main(String[] args) {

    }

    static class Solution {
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
                    map[chars1[i]-'0']++;
                }
            }
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                    if (map[chars2[i]-'0']>0) {
                        map[chars2[i]-'0']--;
                        cntB++;
                    }
                }
            }
            return cntA + "A" + cntB + "B";
        }
    }

}
