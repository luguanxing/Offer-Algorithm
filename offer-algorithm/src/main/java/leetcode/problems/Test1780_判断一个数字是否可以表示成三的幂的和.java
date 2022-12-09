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
