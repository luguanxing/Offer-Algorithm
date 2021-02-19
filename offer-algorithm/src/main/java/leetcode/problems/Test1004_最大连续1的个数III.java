package leetcode.problems;

public class Test1004_最大连续1的个数III {

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(
                new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2
        ));
        System.out.println(new Solution().longestOnes(
                new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3
        ));
        System.out.println(new Solution().longestOnes(
                new int[]{0, 0, 0, 1}, 1
        ));
    }

    static class Solution {
        public int longestOnes(int[] A, int K) {
            int left = 0;
            int right = 0;
            int current = 0;
            int max = 0;
            // 保证滑动窗口内最多不超过K个0即可
            while (right < A.length) {
                int num = A[right++];
                if (num == 0) {
                    current++;
                    while (current > K) {
                        if (A[left++] == 0) {
                            current--;
                        }
                    }
                }
                max = Math.max(max, right - left);
            }
            return max;
        }
    }

}
