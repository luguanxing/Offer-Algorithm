package leetcode.contest.week271;

public class Test5952_环和杆 {

    public static void main(String[] args) {
        System.out.println(new Solution().countPoints("B0B6G0R6R0R6G9"));
        System.out.println(new Solution().countPoints("B0R0G0R9R0B0G0"));
        System.out.println(new Solution().countPoints("G4"));
    }

    static class Solution {
        public int countPoints(String rings) {
            boolean[] r = new boolean[10];
            boolean[] g = new boolean[10];
            boolean[] b = new boolean[10];
            int n = rings.length() / 2;
            for (int i = 0; i < n; i++) {
                char c = rings.charAt(2 * i);
                int index = rings.charAt(2 * i + 1) - '0';
                if (c == 'R') {
                    r[index] = true;
                } else if (c == 'G') {
                    g[index] = true;
                } else if (c == 'B') {
                    b[index] = true;
                }
            }
            int res = 0;
            for (int i = 0; i < 10; i++) {
                if (r[i] && g[i] && b[i]) {
                    res++;
                }
            }
            return res;
        }
    }

}
