package leetcode.problems;

public class Test0788_旋转数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(10));
    }

    static class Solution {
        public int rotatedDigits(int n) {
            int res = 0;
            for (int i = 1; i <= n; i++) {
                boolean[] map = new boolean[10];
                int num = i;
                while (num > 0) {
                    map[num % 10] = true;
                    num /= 10;
                }
                // 有 3 4 7 直接失败
                if (map[3] || map[4] || map[7]) {
                    continue;
                }
                // 有 2 5 6 9 直接成功
                if (map[2] || map[5] || map[6] || map[9]) {
                    res++;
                }
                // 只有剩下堆成的0 1 8也是失败
            }
            return res;
        }
    }

}
