package leetcode.contest.week317;

public class Test6222_美丽整数的最小增量 {

    public static void main(String[] args) {
        System.out.println(new Solution().makeIntegerBeautiful(16, 6));
        System.out.println(new Solution().makeIntegerBeautiful(467, 6));
        System.out.println(new Solution().makeIntegerBeautiful(1, 1));
        System.out.println(new Solution().makeIntegerBeautiful(1999, 10));
        System.out.println(new Solution().makeIntegerBeautiful(1999, 19));
        System.out.println(new Solution().makeIntegerBeautiful(1999, 28));
        System.out.println(new Solution().makeIntegerBeautiful(19, 1));
        System.out.println(new Solution().makeIntegerBeautiful(839, 11));
        System.out.println(new Solution().makeIntegerBeautiful(50043, 9));
    }

    static class Solution {
        public long makeIntegerBeautiful(long n, int target) {
            String nStr = Long.toString(n);
            int len = nStr.length();
            long oldN = n;
            while (getSum(n) > target) {
                int sum = 0;
                int idx = 0;
                for (idx = 0; idx < len; idx++) {
                    sum += nStr.charAt(idx) - '0';
                    if (sum > target) {
                        break;
                    }
                }
                long diff = 0;
                diff += Math.pow(10, len - idx);
                diff -= Long.parseLong(nStr.substring(idx));
                n += diff;
                nStr = Long.toString(n);
            }
            return n - oldN;
        }

        private int getSum(long n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
    }

}
