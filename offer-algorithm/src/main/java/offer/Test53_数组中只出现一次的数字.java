package offer;

import java.util.ArrayList;
import java.util.List;

public class Test53_数组中只出现一次的数字 {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] nums1 = {0};
        int[] nums2 = {0};
        new Solution().FindNumsAppearOnce(nums, nums1, nums2);
        System.out.println(nums1[0] + "," + nums2[0]);
    }

    static class Solution {
        public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
            if (array == null) {
                return;
            }
            // 将所有数异或一遍，由于除了A和B其它出现了两次被抵消，结果相当于A^B
            int xor = 0;
            for (int num : array) {
                xor ^= num;
            }
            // 根据异或结果其中一位把原数组分成两组，A和B必在其中一组
            int groupNum = 1;
            while ((xor & groupNum) == 0) {
                groupNum <<= 1;
            }
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int num : array) {
                if ((groupNum & num) == 0) {
                    list1.add(num);
                } else {
                    list2.add(num);
                }
            }
            // 对两组分别求异或得到A和B
            num1[0] = list1.stream().reduce((a, b) -> a ^ b).orElse(0);
            num2[0] = list2.stream().reduce((a, b) -> a ^ b).orElse(0);
        }
    }

}
