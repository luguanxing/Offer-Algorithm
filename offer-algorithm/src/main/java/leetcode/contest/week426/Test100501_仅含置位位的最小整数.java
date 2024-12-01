package leetcode.contest.week426;

public class Test100501_仅含置位位的最小整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber(5));
        System.out.println(new Solution().smallestNumber(10));
        System.out.println(new Solution().smallestNumber(3));
    }

    static class Solution {
        public int smallestNumber(int n) {
            String current = "1";
            while (Integer.parseInt(current, 2) < n) {
                current += "1";
            }
            return Integer.parseInt(current, 2);
        }
    }

}
