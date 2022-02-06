package leetcode.contest.week279;

public class Test6001_重排数字的最小值 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber(310));
        System.out.println(new Solution().smallestNumber(-7605));
        System.out.println(new Solution().smallestNumber(94));
    }

    static class Solution {
        public long smallestNumber(long num) {
            int[] cnt = new int[10];
            for (char c : String.valueOf(Math.abs(num)).toCharArray()) {
                cnt[c - '0']++;
            }
            String res = "";
            if (num >= 0) {
                // 小的数字在前
                for (int i = 0; i <= 9; i++) {
                    for (int times = 0; times < cnt[i]; times++) {
                        res += i;
                    }
                }
                // 首位不能为非0
                if (res.startsWith("0")) {
                    int next = 0;
                    for (int i = 0; i < res.length(); i++) {
                        if (res.charAt(i) != '0') {
                            next = i;
                            break;
                        }
                    }
                    res = res.charAt(next) + res.substring(0, next) + res.substring(next + 1);
                }
            } else {
                // 大的数字在前
                for (int i = 9; i >= 0; i--) {
                    for (int times = 0; times < cnt[i]; times++) {
                        res += i;
                    }
                }
                res = '-' + res;
            }
            return Long.parseLong(res);
        }
    }

}
