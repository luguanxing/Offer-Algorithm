package leetcode.contest.week361;

public class Test7020_统计对称整数的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSymmetricIntegers(1, 100));
        System.out.println(new Solution().countSymmetricIntegers(1200, 1230));
    }

    static class Solution {
        public int countSymmetricIntegers(int low, int high) {
            int cnt = 0;
            for (int i = low; i <= high; i++) {
                String str = String.valueOf(i);
                if (str.length() % 2 == 0) {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int j = 0; j < str.length() / 2; j++) {
                        sum1 += (str.charAt(j) - '0');
                    }
                    for (int j = str.length() / 2; j < str.length(); j++) {
                        sum2 += (str.charAt(j) - '0');
                    }
                    if (sum1 == sum2) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

}
