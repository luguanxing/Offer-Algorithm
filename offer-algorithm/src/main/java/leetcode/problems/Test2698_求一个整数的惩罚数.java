package leetcode.problems;

public class Test2698_求一个整数的惩罚数 {

    public static void main(String[] args) {
        System.out.println(new Solution().punishmentNumber(10));
        System.out.println(new Solution().punishmentNumber(37));
    }

    static class Solution {
        public int punishmentNumber(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (isPunishmentNumber(i)) {
                    sum += i * i;
                }
            }
            return sum;
        }

        boolean isOk;

        private boolean isPunishmentNumber(int num) {
            isOk = false;
            dfs(num, String.valueOf(num*num), 0, 0);
            return isOk;
        }

        private void dfs(int num, String numSqureStr, int index, int currentSum) {
            if (currentSum > num) {
                return;
            }
            if (index == numSqureStr.length()) {
                if (currentSum == num) {
                    isOk = true;
                }
                return;
            }
            for (int i = index + 1; i <= numSqureStr.length(); i++) {
                String newPart = numSqureStr.substring(index, i);
                dfs(num, numSqureStr, i, currentSum + Integer.parseInt(newPart));
            }
        }
    }

}
