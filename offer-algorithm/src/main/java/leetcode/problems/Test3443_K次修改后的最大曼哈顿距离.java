package leetcode.problems;

public class Test3443_K次修改后的最大曼哈顿距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance("NSEW", 1));
        System.out.println(new Solution().maxDistance("NSWWEW", 3));
        System.out.println(new Solution().maxDistance("EWWE", 0));
    }

    static class Solution {
        public int maxDistance(String s, int k) {
            // 穷举+贪心
            int[] map = new int[4];
            int max = 0;
            for (char c : s.toCharArray()) {
                if (c == 'N') {
                    map[0]++;
                } else if (c == 'S') {
                    map[1]++;
                } else if (c == 'E') {
                    map[2]++;
                } else if (c == 'W') {
                    map[3]++;
                }
                // N+W
                max = Math.max(max, map[0] + map[3] - map[1] - map[2] + 2 * Math.min(k, map[2] + map[1]));
                // N+E
                max = Math.max(max, map[0] + map[2] - map[1] - map[3] + 2 * Math.min(k, map[3] + map[1]));
                // S+W
                max = Math.max(max, map[1] + map[3] - map[0] - map[2] + 2 * Math.min(k, map[2] + map[0]));
                // S+E
                max = Math.max(max, map[1] + map[2] - map[0] - map[3] + 2 * Math.min(k, map[3] + map[0]));
            }
            return max;
        }
    }

}
