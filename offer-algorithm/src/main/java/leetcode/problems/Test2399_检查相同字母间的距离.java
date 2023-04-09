package leetcode.problems;

public class Test2399_检查相同字母间的距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(new Solution().checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    static class Solution {
        public boolean checkDistances(String s, int[] distance) {
            for (int i = 0; i < distance.length; i++) {
                int d = distance[i];
                char c = (char) ('a' + i);
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == c) {
                        if ((j + d + 1 < s.length()) && s.charAt(j + d + 1) == c) {
                            break;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

}
