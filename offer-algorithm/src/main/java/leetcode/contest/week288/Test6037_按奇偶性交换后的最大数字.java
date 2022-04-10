package leetcode.contest.week288;

public class Test6037_按奇偶性交换后的最大数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestInteger(1234));
        System.out.println(new Solution().largestInteger(65875));
        System.out.println(new Solution().largestInteger(29));
    }

    static class Solution {
        public int largestInteger(int num) {
            int[] odds = new int[10];
            int[] evens = new int[10];
            for (char c : String.valueOf(num).toCharArray()) {
                int n = c - '0';
                if (n % 2 == 1) {
                    odds[n]++;
                } else {
                    evens[n]++;
                }
            }
            int res = 0;
            for (char c : String.valueOf(num).toCharArray()) {
                int n = c - '0';
                if (n % 2 == 1) {
                    for (int i = 9; i >= 0; i--) {
                        if (odds[i] != 0) {
                            odds[i]--;
                            res = res * 10 + i;
                            break;
                        }
                    }
                } else {
                    for (int i = 9; i >= 0; i--) {
                        if (evens[i] != 0) {
                            evens[i]--;
                            res = res * 10 + i;
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }

}
