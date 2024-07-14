package leetcode.contest.week406;

public class Test100352_交换后字典序最小的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().getSmallestString("45320"));
        System.out.println(new Solution().getSmallestString("001"));
    }

    static class Solution {
        public String getSmallestString(String s) {
            String res = s;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                int n1 = chars[i] - '0';
                int n2 = chars[i + 1] - '0';
                if ((n1 % 2 == 0 && n2 % 2 == 0) || (n1 % 2 == 1 && n2 % 2 == 1)) {
                    char[] newChars = chars.clone();
                    newChars[i] = chars[i + 1];
                    newChars[i + 1] = chars[i];
                    String newS = new String(newChars);
                    if (res.compareTo(newS) > 0) {
                        res = newS;
                    }
                }
            }
            return res;
        }
    }

}
