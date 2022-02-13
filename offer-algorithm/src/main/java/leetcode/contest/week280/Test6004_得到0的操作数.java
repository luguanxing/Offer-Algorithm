package leetcode.contest.week280;

public class Test6004_得到0的操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countOperations(2, 3));
        System.out.println(new Solution().countOperations(10, 10));
    }

    static class Solution {
        public int countOperations(int num1, int num2) {
            int res = 0;
            while (num1 != 0 && num2 != 0) {
                if (num1 > num2) {
                    num1 -= num2;
                } else {
                    num2 -= num1;
                }
                res++;
            }
            return res;
        }
    }

}
