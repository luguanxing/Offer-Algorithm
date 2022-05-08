package leetcode.contest.week292;

import java.math.BigInteger;

public class Test6058_统计打字方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countTexts("22233"));
        System.out.println(new Solution().countTexts("222222222222222222222222222222222222"));
        System.out.println(new Solution().countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555"));
    }

    static class Solution {
        public int countTexts(String pressedKeys) {
            int MAX = 100005;
            long[] dp3Keys = new long[MAX];
            dp3Keys[0] = 1;
            dp3Keys[1] = 1;
            dp3Keys[2] = 2;
            for (int i = 3; i < MAX; i++) {
                dp3Keys[i] = (dp3Keys[i - 1] + dp3Keys[i - 2] + dp3Keys[i - 3]) % 1000000007;
            }
            long[] dp4Keys = new long[MAX];
            dp4Keys[0] = 1;
            dp4Keys[1] = 1;
            dp4Keys[2] = 2;
            dp4Keys[3] = 4;
            for (int i = 4; i < MAX; i++) {
                dp4Keys[i] = (dp4Keys[i - 1] + dp4Keys[i - 2] + dp4Keys[i - 3] + dp4Keys[i - 4]) % 1000000007;
            }
            BigInteger res = new BigInteger("1");
            BigInteger MOD = new BigInteger("1000000007");
            char lastKey = pressedKeys.charAt(0);
            int currentCnt = 1;
            for (int i = 1; i < pressedKeys.length(); i++) {
                char key = pressedKeys.charAt(i);
                if (key != lastKey || i == pressedKeys.length() - 1) {
                    if (i == pressedKeys.length() - 1 && key == lastKey) {
                        currentCnt++;
                    }
                    long lastKeyResult;
                    if (lastKey == '7' || lastKey == '9') {
                        lastKeyResult = dp4Keys[currentCnt];
                    } else {
                        lastKeyResult = dp3Keys[currentCnt];
                    }
                    res = res.multiply(new BigInteger(lastKeyResult + "")).mod(MOD);
                    currentCnt = 1;
                    lastKey = key;
                } else {
                    currentCnt++;
                }
            }
            return res.intValue();
        }
    }

}
