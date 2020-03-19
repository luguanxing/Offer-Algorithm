package offer;

public class Test15_剪绳子 {

    public static void main(String[] args) {
        int len = 8;
        System.out.println(new Solution().cutRope(len));
    }

    static class Solution {
        public int cutRope(int target) {
            int[] maxN = new int[target + 1];
            // 长度在4之前的绳子剪了比不剪还小，需要特殊处理
            switch (target) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
            }
            // 长度为4以后绳子可以剪成更小绳子，并遍历寻找最优解
            maxN[1] = 1;
            maxN[2] = 2;
            maxN[3] = 3;
            for (int len = 4; len <= target; len++) {
                for (int cut = 1; cut < len; cut++) {
                    maxN[len] = Math.max(maxN[len], maxN[cut] * maxN[len - cut]);
                }
            }
            return maxN[target];
        }
    }

}
