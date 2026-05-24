package leetcode.problems;

public class Test1871_跳跃游戏VII {

    public static void main(String[] args) {
        System.out.println(new Solution().canReach("011010", 2, 3));
        System.out.println(new Solution().canReach("01101110", 2, 3));
        System.out.println(new Solution().canReach("01", 1, 1));
    }

    static class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int len = s.length();
            // 前缀和用于判断是否能从上一步跳过来
            int[] cnt = new int[len];
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += cnt[i];
                if ((sum > 0 || i == 0) && s.charAt(i) == '0') {
                    if (i + minJump < len) {
                        cnt[i + minJump]++;
                    }
                    if (i + maxJump + 1 < len) {
                        cnt[i + maxJump + 1]--;
                    }
                }
            }
            return sum > 0 && s.charAt(len - 1) == '0';
        }
    }

}
