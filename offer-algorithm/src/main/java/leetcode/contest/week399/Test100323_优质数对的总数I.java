package leetcode.contest.week399;

public class Test100323_优质数对的总数I {

    public static void main(String[] args) {
        // nums1 = [1,3,4], nums2 = [1,3,4], k = 1
        System.out.println(new Solution().numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        // nums1 = [1,2,4,12], nums2 = [2,4], k = 3
        System.out.println(new Solution().numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    static class Solution {
        public int numberOfPairs(int[] nums1, int[] nums2, int k) {
            int cnt = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] % (nums2[j] * k) == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

}
