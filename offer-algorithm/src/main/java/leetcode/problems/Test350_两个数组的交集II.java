package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test350_两个数组的交集II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            // 先排序
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            // 双指针找子集
            int index1 = 0;
            int index2 = 0;
            List<Integer> list = new ArrayList<>();
            while (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] == nums2[index2]) {
                    list.add(nums1[index1]);
                    index1++;
                    index2++;
                } else if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

}
