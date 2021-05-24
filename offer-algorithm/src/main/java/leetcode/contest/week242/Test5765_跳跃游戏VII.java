package leetcode.contest.week242;

import java.util.HashSet;
import java.util.Set;

public class Test5765_跳跃游戏VII {

    public static void main(String[] args) {
        System.out.println(new Solution().canReach(
                "011010", 2, 3
        ));
        System.out.println(new Solution().canReach(
                "01101110", 2, 3
        ));
        System.out.println(new Solution().canReach(
                "00111010", 3, 5
        ));
        String s = "";
        for (int i = 1; i <= 100000; i++) {
            s += "0";
        }
        System.out.println(new Solution().canReach(s, 5, 99998));
        System.out.println(new Solution().canReach(
                "0000000000", 8, 8
        ));
    }

    static class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            // 前缀和判断
            int len = s.length();
            int[] canJump = new int[len];
            int[] sum = new int[len + 1];
            canJump[0] = 1;
            sum[1] = 1;
            for (int i = 1; i < len; i++) {
                // 判断i是否可达只需判断[i-max,i-min]是否可达，即sum(i-max,i-min)是否大于1
                if (s.charAt(i) == '0') {
                    int left = Math.max(0, i - maxJump);
                    int right = i - minJump;
                    if ( 0 <= right && left <= right && sum[right + 1] - sum[left] > 0) {
                        canJump[i] = 1;
                    } else {
                        canJump[i] = 0;
                    }
                }
                sum[i + 1] = sum[i] + canJump[i];
            }
            return canJump[len - 1] == 1;
        }
    }

    static class Solution_递归 {
        Set<Integer> canGo = new HashSet<>();

        public boolean canReach(String s, int minJump, int maxJump) {
            checkStep(0, s.toCharArray(), minJump, maxJump);
            return canGo.contains(s.length() - 1);
        }

        private void checkStep(int index, char[] chars, int minJump, int maxJump) {
            canGo.add(index);
            for (int nextIndex = index + minJump; nextIndex <= Math.min(index + maxJump, chars.length - 1); nextIndex++) {
                if (chars[nextIndex] == '0' && !canGo.contains(nextIndex)) {
                    checkStep(nextIndex, chars, minJump, maxJump);
                }
            }
        }
    }

}
