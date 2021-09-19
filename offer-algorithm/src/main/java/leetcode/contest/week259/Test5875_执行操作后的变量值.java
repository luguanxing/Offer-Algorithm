package leetcode.contest.week259;

public class Test5875_执行操作后的变量值 {

    public static void main(String[] args) {
        System.out.println(new Solution().finalValueAfterOperations(
                new String[]{"--X", "X++", "X++"}
        ));
        System.out.println(new Solution().finalValueAfterOperations(
                new String[]{"++X", "++X", "X++"}
        ));
        System.out.println(new Solution().finalValueAfterOperations(
                new String[]{"X++", "++X", "--X", "X--"}
        ));
    }

    static class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int res = 0;
            for (String op : operations) {
                if (op.contains("++")) {
                    res++;
                } else {
                    res--;
                }
            }
            return res;
        }
    }

}
