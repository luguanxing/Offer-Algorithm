package leetcode.problems;

public class Test2048_下一个更大的数值平衡数 {

    public static void main(String[] args) {
        System.out.println(new Solution().nextBeautifulNumber(1));
        System.out.println(new Solution().nextBeautifulNumber(1000));
        System.out.println(new Solution().nextBeautifulNumber(477852));
    }

    static class Solution {
        public int nextBeautifulNumber(int n) {
            for (int i = n + 1; i <= 1E7; i++) {
                if (isBeautifulNumber(i)) {
                    return i;
                }
            }
            return -1;
        }

        private boolean isBeautifulNumber(int num) {
            int[] count = new int[10];
            while (num > 0) {
                count[num % 10]++;
                num /= 10;
            }
            for (int i = 0; i < 10; i++) {
                if (count[i] != 0 && count[i] != i) {
                    return false;
                }
            }
            return true;
        }
    }

}
