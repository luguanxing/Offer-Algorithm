package leetcode.contest.week212;

public class Test5546_按键持续时间最长的键 {

    public static void main(String[] args) {
        System.out.println(new Solution().slowestKey(
                new int[]{9, 29, 49, 50}, "cbcd"
        ));
        System.out.println(new Solution().slowestKey(
                new int[]{12, 23, 36, 46, 62}, "spuda"
        ));
    }

    static class Solution {
        public char slowestKey(int[] releaseTimes, String keysPressed) {
            // 计算每个按键时间
            int[] pressTimes = new int[releaseTimes.length];
            pressTimes[0] = releaseTimes[0];
            for (int i = 1; i < releaseTimes.length; i++) {
                pressTimes[i] = releaseTimes[i] - releaseTimes[i - 1];
            }
            // 找出按键时间最长的键
            char[] chars = keysPressed.toCharArray();
            int maxTime = pressTimes[0];
            char maxChar = chars[0];
            for (int i = 1; i < chars.length; i++) {
                if (maxTime < pressTimes[i] || (maxTime == pressTimes[i] && maxChar < chars[i])) {
                    maxTime = pressTimes[i];
                    maxChar = chars[i];
                }
            }
            return maxChar;
        }
    }

}
