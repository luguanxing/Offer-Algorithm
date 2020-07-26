package leetcode.contest.week199;

public class Test5473_灯泡开关IV {

    public static void main(String[] args) {
        System.out.println(new Solution().minFlips("10111"));
        System.out.println(new Solution().minFlips("101"));
        System.out.println(new Solution().minFlips("00000"));
        System.out.println(new Solution().minFlips("001011101"));
        System.out.println(new Solution().minFlips("10101"));
        System.out.println(new Solution().minFlips("10001"));
        System.out.println(new Solution().minFlips("1000110001"));
        System.out.println(new Solution().minFlips("100010001"));
        System.out.println(new Solution().minFlips("11000"));
        System.out.println(new Solution().minFlips("001011101"));
    }

    static class Solution {
        public int minFlips(String target) {
            if (!(target.contains("0") && target.contains("1"))) {
                return 0;
            }
            // 去掉前面的0
            int first1 = 0;
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) != '0') {
                    first1 = i;
                    break;
                } else {
                    first1++;
                }
            }
            target = target.substring(first1);
            // 从后到前，不相同就开一次
            int res = 0;
            Character lastC = null;
            for (int i = target.length() - 1; i >= 0; i--) {
                char c = target.charAt(i);
                if (lastC == null || lastC != c) {
                    res++;
                    lastC = c;
                }
            }
            return res;
        }
    }

}
