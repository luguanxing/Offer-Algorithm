package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0324_摆动排序II {

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 1, 1, 6, 4};
        int[] nums2 = {1, 3, 2, 2, 3, 1};
        int[] nums3 = {1, 1, 2, 1, 2, 2, 1};
        new Solution().wiggleSort(nums1);
        new Solution().wiggleSort(nums2);
        new Solution().wiggleSort(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }

    static class Solution {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            List<Integer> res = new ArrayList<>();
            int fast = nums.length - 1;
            int slow = fast / 2;
            while (res.size() < nums.length) {
                res.add(nums[slow--]);
                if (res.size() < nums.length) {
                    res.add(nums[fast--]);
                }
            }
            for (int i = 0; i < res.size(); i++) {
                nums[i] = res.get(i);
            }
        }
    }

}
