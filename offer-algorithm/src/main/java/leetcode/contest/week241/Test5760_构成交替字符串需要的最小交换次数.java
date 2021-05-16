package leetcode.contest.week241;

public class Test5760_构成交替字符串需要的最小交换次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps("111000"));
        System.out.println(new Solution().minSwaps("010"));
        System.out.println(new Solution().minSwaps("1110"));
        System.out.println(new Solution().minSwaps("1100"));
        System.out.println(new Solution().minSwaps("100"));
        System.out.println(new Solution().minSwaps("10001"));
        System.out.println(new Solution().minSwaps("10010"));
    }

    static class Solution {
        public int minSwaps(String s) {
            // 判断可行性
            int cnt0 = 0;
            int cnt1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
            if (cnt0 - cnt1 > 1 || cnt0 - cnt1 < -1) {
                return -1;
            }
            // 分布构造1和0开头的连续串
            String start1 = "1";
            String start0 = "0";
            for (int i = 1; i < s.length(); i++) {
                if (start1.charAt(start1.length() - 1) == '1') {
                    start1 += '0';
                } else {
                    start1 += '1';
                }
            }
            for (int i = 1; i < s.length(); i++) {
                if (start0.charAt(start0.length() - 1) == '0') {
                    start0 += '1';
                } else {
                    start0 += '0';
                }
            }
            // 比较得出最小 结果
            if (s.length() % 2 == 0) {
                int cntTrans1 = 0;
                int cntTrans0 = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != start1.charAt(i)) {
                        cntTrans1++;
                    }
                    if (s.charAt(i) != start0.charAt(i)) {
                        cntTrans0++;
                    }
                }
                return Math.min(cntTrans0, cntTrans1) / 2;
            } else {
                int cntTrans1 = 0;
                int cntTrans0 = 0;
                if (cnt1 * 2 == s.length() + 1) {
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != start1.charAt(i)) {
                            cntTrans1++;
                        }
                    }
                    return cntTrans1 / 2;
                }
                if (cnt0 * 2 == s.length() + 1) {
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != start0.charAt(i)) {
                            cntTrans0++;
                        }
                    }
                    return cntTrans0 / 2;
                }
                return -1;
            }
        }
    }

}
