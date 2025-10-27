package leetcode.problems;

public class Test2125_银行中的激光束数量 {

    public static void main(String[] args) {
        // bank = ["011001","000000","010100","001000"]
        System.out.println(new Solution().numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        // bank = ["000","111","000"]
        System.out.println(new Solution().numberOfBeams(new String[]{"000", "111", "000"}));
    }

    static class Solution {
        public int numberOfBeams(String[] bank) {
            int res = 0;
            int prev = 0;
            for (String b : bank) {
                // 计算当前有多少台激光器
                int current = 0;
                for (char c : b.toCharArray()) {
                    if (c == '1') {
                        current++;
                    }
                }
                res += prev * current;
                if (current != 0) {
                    prev = current;
                }
            }
            return res;
        }
    }

}
