package leetcode.contest.dweek27;

public class Test1461_检查一个字符串是否包含所有长度为K的二进制子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().hasAllCodes("00110110", 2));
        System.out.println(new Solution().hasAllCodes("00110", 2));
        System.out.println(new Solution().hasAllCodes("0110", 1));
        System.out.println(new Solution().hasAllCodes("0110", 2));
        System.out.println(new Solution().hasAllCodes("0000000001011100", 4));
    }

    static class Solution {
        public boolean hasAllCodes(String s, int k) {
            // 滑动窗口截取每个长度为K的字符串
            boolean[] flags = new boolean[(int) Math.pow(2, k)];
            for (int i = 0; i < s.length() - k + 1; i++) {
                String subStr = s.substring(i, i + k);
                int index = Integer.parseInt(subStr, 2);
                flags[index] = true;
            }
            // 检查是否所有0-2^K-1都出现过了
            for (boolean flag : flags) {
                if (!flag) {
                    return false;
                }
            }
            return true;
        }
    }

}
