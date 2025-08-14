package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1780_判断一个数字是否可以表示成三的幂的和 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkPowersOfThree(12));
        System.out.println(new Solution().checkPowersOfThree(91));
        System.out.println(new Solution().checkPowersOfThree(21));
    }

    static class Solution {
        boolean result = false;

        public boolean checkPowersOfThree(int n) {
            dfs(n, 0);
            dfs(n, 0);
            return result;
        }

        private void dfs(int n, int exp) {
            if (n == 0) {
                result = true;
                return;
            }
            if (n < 0 || Math.pow(3, exp) > 1e7) {
                return;
            }
            // take 3^exp
            dfs(n - (int) Math.pow(3, exp), exp + 1);
            // don't take 3^exp
            dfs(n, exp + 1);
        }
    }

    static class Solution_OLD {
        boolean isOk = false;

        public boolean checkPowersOfThree(int n) {
            List<Integer> list = new ArrayList<>();
            int pow = 1;
            while (pow <= n) {
                list.add(pow);
                pow *= 3;
            }
            dfs(n, list, 0, 0);
            return isOk;
        }

        private void dfs(int n, List<Integer> list, int sum, int index) {
            if (isOk || sum > n) {
                return;
            }
            if (index == list.size()) {
                if (sum == n) {
                    isOk = true;
                }
                return;
            }
            dfs(n, list, sum, index + 1);
            dfs(n, list, sum + list.get(index), index + 1);
        }
    }

}
