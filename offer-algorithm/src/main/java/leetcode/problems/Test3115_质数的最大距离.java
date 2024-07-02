package leetcode.problems;

public class Test3115_质数的最大距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
        System.out.println(new Solution().maximumPrimeDifference(new int[]{4, 8, 2, 8}));

    }

    static class Solution {
        public int maximumPrimeDifference(int[] nums) {
            int firstIndex = -1;
            int lastIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (isPrime(num)) {
                    if (firstIndex == -1) {
                        firstIndex = i;
                    }
                    lastIndex = i;
                }
            }
            return lastIndex - firstIndex;
        }

        private boolean isPrime(int num) {
            if (num == 1) {
                return false;
            }
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
