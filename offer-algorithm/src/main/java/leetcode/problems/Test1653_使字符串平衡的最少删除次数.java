package leetcode.problems;

public class Test1653_使字符串平衡的最少删除次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeletions("aababbab"));
        System.out.println(new Solution().minimumDeletions("bbaaaaabb"));
    }

    static class Solution {
        public int minimumDeletions(String s) {
            // 计算b前缀和与b后缀和
            int len = s.length();
            int[] bCnt = new int[len];
            int[] aCnt = new int[len];
            bCnt[0] = s.charAt(0) == 'b' ? 1 : 0;
            aCnt[len - 1] = s.charAt(len - 1) == 'a' ? 1 : 0;
            for (int i = 1; i < len; i++) {
                bCnt[i] = bCnt[i - 1];
                bCnt[i] += s.charAt(i) == 'b' ? 1 : 0;
            }
            for (int i = len - 2; i >= 0; i--) {
                aCnt[i] = aCnt[i + 1];
                aCnt[i] += s.charAt(i) == 'a' ? 1 : 0;
            }
            // 枚举某个位置，为了满足条件需要去掉前面的a和后面b
            int res = len;
            for (int i = 0; i < len; i++) {
                res = Math.min(res, bCnt[i] + aCnt[i]);
            }
            return res - 1;
        }
    }

}
