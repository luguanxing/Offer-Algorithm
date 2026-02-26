package leetcode.problems;

public class Test1404_将二进制表示减到1的步骤数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSteps("1101"));
        System.out.println(new Solution().numSteps("10"));
        System.out.println(new Solution().numSteps("1110"));

    }

    static class Solution {
        public int numSteps(String s) {
            int res = 0;
            while (!s.equals("1")) {
                if (s.endsWith("1")) {
                    res++;
                    // 往左边进位，即找最右边的0改1，剩下右边全变0
                    for (int i = s.length() - 1; i >= 0; i--) {
                        if (s.charAt(i) == '0') {
                            s = s.substring(0, i) + "1" + s.substring(i + 1);
                            break;
                        } else {
                            s = s.substring(0, i) + "0" + s.substring(i + 1);
                        }
                    }
                    if (s.charAt(0) == '0') {
                        s = "1" + s;
                    }
                }
                res++;
                s = s.substring(0, s.length() - 1);
            }
            return res;
        }
    }

}
