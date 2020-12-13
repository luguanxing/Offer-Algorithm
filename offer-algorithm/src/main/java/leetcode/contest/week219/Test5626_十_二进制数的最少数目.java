package leetcode.contest.week219;

public class Test5626_十_二进制数的最少数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().minPartitions("32"));
        System.out.println(new Solution().minPartitions("82734"));
        System.out.println(new Solution().minPartitions("27346209830709182346"));
    }

    static class Solution {
        public int minPartitions(String n) {
            if (n == null) {
                return 0;
            }
            // 最少数目其实是由最大的那位决定，其它按对应从小到大用1..1先凑出
            int max = 0;
            for (char c : n.toCharArray()) {
                max = Math.max(max, c - '0');
            }
            return max;
        }
    }

}
