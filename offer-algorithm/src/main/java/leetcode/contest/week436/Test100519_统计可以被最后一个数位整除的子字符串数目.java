package leetcode.contest.week436;

public class Test100519_统计可以被最后一个数位整除的子字符串数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("12936"));
        System.out.println(new Solution().countSubstrings("5701283"));
        System.out.println(new Solution().countSubstrings("1010101010"));
    }

    static class Solution {
        public long countSubstrings(String s) {
            int len = s.length();
            long res = 0;
            // 前缀值
            int p3 = 0, p9 = 0, p4 = 0, p8 = 0, p6 = 0, p7 = 0;
            // 频率数组
            int[] f3 = new int[3], f9 = new int[9], f6 = new int[6], f7 = new int[7];
            f3[0] = f9[0] = f6[0] = f7[0] = 1;
            // 对应的逆元
            int[] inv = {1, 5, 4, 6, 2, 3};
            for (int i = 0; i < len; i++) {
                int num = s.charAt(i) - '0';
                p3 = (p3 + num) % 3;
                p9 = (p9 + num) % 9;
                p4 = (p4 * 2 + num) % 4;
                p8 = (p8 * 2 + num) % 8;
                p6 = (p6 * 4 + num) % 6;
                p7 = (p7 * 3 + num) % 7;
                int k6 = (4 * p6) % 6;
                int k7 = (p7 * inv[(i + 1) % 6]) % 7;
                // 分类处理最后一位的情况
                if (num != 0) {
                    switch (num) {
                        case 1:
                        case 2:
                        case 5:
                            res += (i + 1);
                            break;
                        case 3:
                            res += f3[p3];
                            break;
                        case 4:
                            long c4 = 1;
                            if (i >= 1 && ((s.charAt(i - 1) - '0') * 10 + 4) % 4 == 0) {
                                c4++;
                            }
                            if (i >= 2 && p4 == 0) {
                                c4 += (i - 1);
                            }
                            res += c4;
                            break;
                        case 6:
                            res += f6[p6];
                            break;
                        case 7:
                            res += f7[k7];
                            break;
                        case 8:
                            long c8 = 1;
                            if (i >= 1 && ((s.charAt(i - 1) - '0') * 10 + 8) % 8 == 0) {
                                c8++;
                            }
                            if (i >= 2 && p8 == 0) {
                                c8 += (i - 1);
                            }
                            res += c8;
                            break;
                        case 9:
                            res += f9[p9];
                            break;
                    }
                }
                f3[p3]++;
                f9[p9]++;
                f6[k6]++;
                f7[k7]++;
            }
            return res;
        }
    }

}
