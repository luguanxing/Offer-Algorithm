package leetcode.contest.week274;

public class Test5968_银行中的激光束数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBeams(new String[]{
                "011001", "000000", "010100", "001000"
        }));
        System.out.println(new Solution().numberOfBeams(new String[]{
                "000", "111", "000"
        }));
    }

    static class Solution {
        public int numberOfBeams(String[] bank) {
            int res = 0;
            int last = 0;
            for (String row : bank) {
                if (!row.contains("1")) {
                    continue;
                }
                int current = 0;
                for (char c : row.toCharArray()) {
                    if (c == '1') {
                        current++;
                    }
                }
                res += current * last;
                last = current;
            }
            return res;
        }
    }

}
