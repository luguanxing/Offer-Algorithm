package leetcode.contest.week400;

public class Test100307_候诊室中的最少椅子数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumChairs("EEEEEEE"));
        System.out.println(new Solution().minimumChairs("ELELEEL"));
        System.out.println(new Solution().minimumChairs("ELEELEELLL"));
    }

    static class Solution {
        public int minimumChairs(String s) {
            int max = 0;
            int current = 0;
            for (char c : s.toCharArray()) {
                if (c == 'E') {
                    current++;
                } else if (c == 'L') {
                    current--;
                }
                max = Math.max(max, current);
            }
            return max;
        }
    }

}
