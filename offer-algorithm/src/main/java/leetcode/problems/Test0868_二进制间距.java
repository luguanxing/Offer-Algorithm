package leetcode.problems;

public class Test0868_二进制间距 {

    public static void main(String[] args) {
        System.out.println(new Solution().binaryGap(22));
        System.out.println(new Solution().binaryGap(8));
        System.out.println(new Solution().binaryGap(5));
    }

    static class Solution {
        public int binaryGap(int n) {
            String str = Integer.toBinaryString(n);
            int max = 0;
            Integer last = null;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '1') {
                    if (last == null) {
                        last = i;
                        continue;
                    }
                    max = Math.max(max, i - last);
                    last = i;
                }
            }
            return max;
        }
    }

}
