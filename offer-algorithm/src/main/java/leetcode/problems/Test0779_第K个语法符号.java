package leetcode.problems;

public class Test0779_第K个语法符号 {

    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(1, 1));
        System.out.println(new Solution().kthGrammar(2, 1));
        System.out.println(new Solution().kthGrammar(2, 2));
        System.out.println(new Solution().kthGrammar(3, 1));
        System.out.println(new Solution().kthGrammar(3, 2));
        System.out.println(new Solution().kthGrammar(3, 3));
        System.out.println(new Solution().kthGrammar(3, 4));
    }

    static class Solution {
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return k == 1 ? 0 : 1;
            }
            int last = kthGrammar(n - 1, (k + 1) / 2);
            if (last == 0) {
                return k % 2 == 1 ? 0 : 1;
            } else {
                return k % 2 == 1 ? 1 : 0;
            }
        }
    }

}
