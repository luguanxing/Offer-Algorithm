package leetcode.contest.week251;

public class Test5823_字符串转化后的各位数字之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().getLucky("iiii", 1));
        System.out.println(new Solution().getLucky("leetcode", 2));
    }

    static class Solution {
        public int getLucky(String s, int k) {
            String str = "";
            for (char c : s.toCharArray()) {
                str += ((c - 'a') + 1 + "");
            }
            int res = 0;
            for (int i = 1; i <= k; i++) {
                res = 0;
                for (char c : str.toCharArray()) {
                    res += (c - '0');
                }
                str = res + "";
            }
            return res;
        }
    }

}
