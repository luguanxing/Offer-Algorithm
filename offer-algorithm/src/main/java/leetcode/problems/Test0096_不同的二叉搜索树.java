package leetcode.problems;

public class Test0096_不同的二叉搜索树 {

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(0));
        System.out.println(new Solution().numTrees(1));
        System.out.println(new Solution().numTrees(3));
    }

    static class Solution {
        public int numTrees(int n) {
            // 设前n个数能组成f(n)种，那么计算f(n+1)时以1..n+1为根节点可组成f(n+1)=f(0)*f(n-1)+f(1)*f(n-2)+...f(n)*f(0)种
            int[] f = new int[n + 3];
            f[0] = 1;
            f[1] = 1;
            f[2] = 2;
            for (int i = 3; i <= n; i++) {
                int sum = 0;
                for (int j = 0; j <= i - 1; j++) {
                    sum += f[j] * f[i - 1 - j];
                }
                f[i] = sum;
            }
            return f[n];
        }
    }

}
