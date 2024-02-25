package leetcode.contest.week386;

public class Test100224_分割数组 {

    public static void main(String[] args) {
        // nums = [1,1,2,2,3,4]
        System.out.println(new Solution().isPossibleToSplit(new int[]{1, 1, 2, 2, 3, 4}));
        // nums = [1,1,1,1]
        System.out.println(new Solution().isPossibleToSplit(new int[]{1, 1, 1, 1}));
    }

    static class Solution {
        public boolean isPossibleToSplit(int[] nums) {
            int[] map = new int[1005];
            for (int num : nums) {
                map[num]++;
                if (map[num] > 2) {
                    return false;
                }
            }
            return true;
        }
    }

}
