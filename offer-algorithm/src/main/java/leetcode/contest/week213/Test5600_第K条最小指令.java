package leetcode.contest.week213;

public class Test5600_第K条最小指令 {

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallestPath(new int[]{2, 3}, 1));
        System.out.println(new Solution().kthSmallestPath(new int[]{2, 3}, 2));
        System.out.println(new Solution().kthSmallestPath(new int[]{2, 3}, 3));
        System.out.println(new Solution().kthSmallestPath(new int[]{15, 15}, 3));
    }

    static class Solution {
        public String kthSmallestPath(int[] destination, int k) {
            int height = destination[0];
            int width = destination[1];
            // 计算组合数nCm
            int[][] C = new int[height + width][width];
            C[0][0] = 1;
            for (int n = 1; n < height + width; n++) {
                C[n][0] = 1;
                for (int m = 1; m < width; m++) {
                    // nCm = n-1Cm + n-1Cm-1
                    C[n][m] = C[n - 1][m] + C[n - 1][m - 1];
                }
            }
            // 当前H开头的组合数为(height-1+width)C(height-1)
            // 若当前结果大于K则当前字符串为则为H(k在范围内)
            // 否则为V并继续算剩下的k-组合数
            String res = "";
            while (height > 0 && width > 0) {
                int current = C[height + width - 1][width - 1];
                if (current >= k) {
                    res += "H";
                    width--;
                } else {
                    res += "V";
                    height--;
                    k -= current;
                }
            }
            while (height != 0) {
                res += "V";
                height--;
            }
            while (width != 0) {
                res += "H";
                width--;
            }
            return res;
        }
    }

}
