package leetcode.problems;

public class Test2929_给小朋友们分糖果II {

    public static void main(String[] args) {
        System.out.println(new Solution().distributeCandies(5, 2));
        System.out.println(new Solution().distributeCandies(3, 3));
    }

    static class Solution {
        public long distributeCandies(int n, int limit) {
            long res = 0;
            // 第一个人拿x颗，x不能超过n或limit，剩下n-x颗分给两人，且剩下的不能超过2*limit
            // 第二个人至少拿n-x-limit颗，否则拿少了第三个人就超了
            // 第二个人至多拿limit颗或n-x颗，否则违规
            // 第二个人能拿[n-x-limit, min(limit,n-x)]的范围
            for (int x = 0; x <= Math.min(n, limit); x++) {
                if (n - x > 2 * limit) {
                    continue;
                }
                long min = Math.max(n-x-limit, 0);
                long max = Math.min(limit, n-x);
                res += max - min + 1;
            }
            return res;
        }
    }

}
