package leetcode.contest.week241;

import java.util.HashMap;
import java.util.Map;

public class Test5761_找出和为指定值的下标对 {

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(
                new int[]{9, 70, 14, 9, 76},
                new int[]{26, 26, 58, 23, 74, 68, 68, 78, 58, 26}
        );
        findSumPairs.add(6, 10);
        findSumPairs.add(5, 6);
        System.out.println(findSumPairs.count(32));
        findSumPairs.add(3, 55);
        findSumPairs.add(9, 32);
        findSumPairs.add(9, 16);
        findSumPairs.add(1, 48);
        findSumPairs.add(1, 4);
        findSumPairs.add(0, 52);
        findSumPairs.add(8, 20);
        findSumPairs.add(9, 4);
        System.out.println(findSumPairs.count(88));
        System.out.println(findSumPairs.count(154));
    }

    static class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> map1;
        Map<Integer, Integer> map2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.map1 = new HashMap<>();
            this.map2 = new HashMap<>();
            for (int num : nums1) {
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }
            for (int num : nums2) {
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int oldNum = nums2[index];
            int newNum = oldNum + val;
            nums2[index] = newNum;
            map2.put(oldNum, map2.get(oldNum) - 1);
            map2.put(newNum, map2.getOrDefault(newNum, 0) + 1);
        }

        public int count(int tot) {
            int res = 0;
            for (int num1 : map1.keySet()) {
                int cnt1 = map1.get(num1);
                int diff = tot - num1;
                if (map2.containsKey(diff)) {
                    int cnt2 = map2.get(diff);
                    res += cnt1 * cnt2;
                }
            }
            return res;
        }
    }

}
