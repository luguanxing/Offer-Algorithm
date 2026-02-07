package leetcode.problems;

public class Test1653_使字符串平衡的最少删除次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeletions("aababbab"));
        System.out.println(new Solution().minimumDeletions("bbaaaaabb"));
        System.out.println(new Solution().minimumDeletions("b"));
        System.out.println(new Solution().minimumDeletions("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba"));
    }

    static class Solution {
        public int minimumDeletions(String s) {
            int len = s.length();
            // 计算a和b的总数
            int totalA = 0;
            int totalB = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') {
                    totalA++;
                } else {
                    totalB++;
                }
            }
            // 计算当前a和b的数量，以及最小删除次数
            int currentA = 0;
            int currentB = 0;
            int minCnt = totalA; // 边界情况：全部删除a（可能在最右边）
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == 'a') {
                    currentA++;
                } else {
                    currentB++;
                }
                // 删除前面b的数量 + 删除后面a的数量
                int deleteCnt = currentB + (totalA - currentA);
                minCnt = Math.min(minCnt, deleteCnt);
            }
            return minCnt;
        }
    }

    static class Solution_OLD {
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
