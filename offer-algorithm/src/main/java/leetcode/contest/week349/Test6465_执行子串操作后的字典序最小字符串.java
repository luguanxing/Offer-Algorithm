package leetcode.contest.week349;

public class Test6465_执行子串操作后的字典序最小字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestString("cbabc"));
        System.out.println(new Solution().smallestString("acbbc"));
        System.out.println(new Solution().smallestString("leetcode"));
        System.out.println(new Solution().smallestString("acbbac"));
        System.out.println(new Solution().smallestString("a"));
        System.out.println(new Solution().smallestString("aaa"));
    }

    static class Solution {
        public String smallestString(String s) {
            int len = s.length();
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (!s.isEmpty()) {
                if (idx == len - 1 && s.charAt(idx) == 'a') {
                    sb.append("z");
                    break;
                }
                if (s.charAt(idx) == 'a') {
                    sb.append("a");
                    idx++;
                    continue;
                }
                int firstAindex = s.indexOf('a', idx);
                if (firstAindex > 0) {
                    sb.append(change(s.substring(idx, firstAindex)));
                    sb.append(s.substring(firstAindex));
                    break;
                }
                sb.append(change(s.substring(idx)));
                break;
            }
            return sb.toString();
        }

        private String change(String s) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i]--;
            }
            return new String(chars);
        }
    }

}
