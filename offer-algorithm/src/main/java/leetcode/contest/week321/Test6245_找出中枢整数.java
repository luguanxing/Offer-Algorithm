package leetcode.contest.week321;

public class Test6245_找出中枢整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().pivotInteger(8));
        System.out.println(new Solution().pivotInteger(1));
        System.out.println(new Solution().pivotInteger(4));
    }

    static class Solution {
        public int pivotInteger(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            int current = 0;
            for (int i = 1; i <= n; i++) {
                current += i;
                if (current == sum - current + i) {
                    return i;
                }
            }
            return -1;
        }
    }

}
