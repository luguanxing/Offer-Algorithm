package leetcode.problems;

public class Test2327_知道秘密的人数 {

    public static void main(String[] args) {
        System.out.println(new Solution().peopleAwareOfSecret(6, 2, 4));
        System.out.println(new Solution().peopleAwareOfSecret(4, 1, 3));
    }

    static class Solution {
        public int peopleAwareOfSecret(int n, int delay, int forget) {
            // add[i]表示第i天新知道秘密的人数
            int MOD = (int) 1e9 + 7;
            int[] add = new int[n + 1];
            add[1] = 1;
            // add[i]当天新增的人对add[i+delay]到add[i+forget-1]有影响
            for (int i = 1; i <= n; i++) {
                for (int j = i + delay; j <= Math.min(i + forget - 1, n); j++) {
                    add[j] += add[i];
                    add[j] %= MOD;
                }
            }
            // 计算能对第n天产生影响的人数，即在第n天还没有忘记秘密的人数
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (n < i + forget) {
                    res += add[i];
                    res %= MOD;
                }
            }
            return res;
        }
    }

}
