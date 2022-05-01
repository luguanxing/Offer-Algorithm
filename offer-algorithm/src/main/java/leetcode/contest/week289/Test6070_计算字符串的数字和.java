package leetcode.contest.week289;

public class Test6070_计算字符串的数字和 {

    public static void main(String[] args) {
        System.out.println(new Solution().digitSum("11111222223", 3));
        System.out.println(new Solution().digitSum("00000000", 3));
    }

    static class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                String newS = "";
                while (s.length() > k) {
                    String subS = s.substring(0, k);
                    s = s.substring(k);
                    int subSsum = 0;
                    for (char c : subS.toCharArray()) {
                        subSsum += c - '0';
                    }
                    newS += subSsum;
                }
                int subSsum = 0;
                for (char c : s.toCharArray()) {
                    subSsum += c - '0';
                }
                newS += subSsum;
                s = newS;
            }
            return s;
        }
    }

}
