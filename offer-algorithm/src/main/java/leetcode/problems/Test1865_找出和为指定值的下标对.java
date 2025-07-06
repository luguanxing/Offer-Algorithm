package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test1865_找出和为指定值的下标对 {

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
        findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
        findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
        findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
        findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
        findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
    }

    static class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> num1Cnt = new HashMap<>();
        Map<Integer, Integer> num2Cnt = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int num1 : nums1) {
                num1Cnt.put(num1, num1Cnt.getOrDefault(num1, 0) + 1);
            }
            for (int num2 : nums2) {
                num2Cnt.put(num2, num2Cnt.getOrDefault(num2, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int oldVal = nums2[index];
            int newVal = oldVal + val;
            nums2[index] = newVal;
            // 老值cnt-1，新值cnt+1
            num2Cnt.put(oldVal, num2Cnt.get(oldVal) - 1);
            if (num2Cnt.get(oldVal) == 0) {
                num2Cnt.remove(oldVal);
            }
            num2Cnt.put(newVal, num2Cnt.getOrDefault(newVal, 0) + 1);
        }

        public int count(int tot) {
            int res = 0;
            for (int num1 : num1Cnt.keySet()) {
                int num2 = tot - num1;
                if (num2Cnt.containsKey(num2)) {
                    res += num2Cnt.get(num2) * num1Cnt.get(num1);
                }
            }
            return res;
        }
    }


}
