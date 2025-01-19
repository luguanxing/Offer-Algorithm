package leetcode.problems;

public class Test2266_统计打字方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countTexts("22233"));
        System.out.println(new Solution().countTexts("222222222222222222222222222222222222"));
    }

    static class Solution {
        public int countTexts(String pressedKeys) {
            int len = pressedKeys.length();
            int MOD = (int)1E9 + 7;
            int MAX = (int)1E5 + 5;
            // 分成两类进行与预计算
            long[] dp1 = new long[MAX];
            dp1[1] = 1;
            dp1[2] = 2;
            dp1[3] = 4;
            for (int i = 4; i < MAX; i++) {
                dp1[i] += (dp1[i - 1] + dp1[i - 2] + dp1[i - 3]) % MOD;
            }
            long[] dp2 = new long[MAX];
            dp2[1] = 1;
            dp2[2] = 2;
            dp2[3] = 4;
            dp2[4] = 8;
            for (int i = 5; i < MAX; i++) {
                dp2[i] = (dp2[i - 1] + dp2[i - 2] + dp2[i - 3] + dp2[i - 4]) % MOD;
            }
            // 统计答案
            char[] chars = pressedKeys.toCharArray();
            int res = 1;
            int index = 0;
            while (index < len) {
                // 统计连续相同字符的个数
                char c = chars[index];
                int cnt = 0;
                while (index + cnt < len && chars[index + cnt] == c) {
                    cnt++;
                }
                // 分成两类进行统计
                if (c == '7' || c == '9') {
                    res = (int)((long)res * dp2[cnt] % MOD);
                } else {
                    res = (int)((long)res * dp1[cnt] % MOD);
                }
                // 继续向后统计
                index += cnt;
            }
            return res;
        }
    }

}
