package leetcode.problems;

public class Test3106_满足距离约束且字典序最小的字符串 {

    public static void main(String[] args) {
        // s = "zbbz", k = 3
        System.out.println(new Solution().getSmallestString("zbbz", 3));
        // s = "xaxcd", k = 4
        System.out.println(new Solution().getSmallestString("xaxcd", 4));
        // s = "lol", k = 0
        System.out.println(new Solution().getSmallestString("lol", 0));
    }

    static class Solution {
        public String getSmallestString(String s, int k) {
            // 从前往后贪心分配k
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int diff1 = c - 'a';
                int diff2 = 'a' - c;
                if (diff2 < 0) {
                    diff2 += 26;
                }
                int diff = Math.min(diff1, diff2);
                // k足够到a则分配到a，否则向前减少
                if (diff <= k) {
                    chars[i] = 'a';
                    k -= diff;
                } else {
                    chars[i] -= k;
                    break;
                }
            }
            return String.valueOf(chars);
        }
    }

}
