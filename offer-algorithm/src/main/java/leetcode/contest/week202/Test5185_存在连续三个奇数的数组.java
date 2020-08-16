package leetcode.contest.week202;

public class Test5185_存在连续三个奇数的数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(new Solution().threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

    static class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            boolean exist = false;
            for (int i = 2; i < arr.length; i++) {
                if (arr[i - 2] % 2 == 1 && arr[i - 1] % 2 == 1 && arr[i] % 2 == 1) {
                    exist = true;
                    break;
                }
            }
            return exist;
        }
    }

}
