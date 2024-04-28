package leetcode.contest.week395;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test100287_找出与数组相加的整数II {

    public static void main(String[] args) {
        // nums1 = [4,20,16,12,8], nums2 = [14,18,10]
        System.out.println(new Solution().minimumAddedInteger(new int[]{4, 20, 16, 12, 8}, new int[]{14, 18, 10}));
        // nums1 = [3,5,5,3], nums2 = [7,7]
        System.out.println(new Solution().minimumAddedInteger(new int[]{3, 5, 5, 3}, new int[]{7, 7}));
    }

    static class Solution {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            for (int i = 0; i < list1.size(); i++) {
                for (int j = i + 1; j < list1.size(); j++) {
                    List<Integer> list = new ArrayList<>();
                    for (int k = 0; k < list1.size(); k++) {
                        if (k != i && k != j) {
                            list.add(list1.get(k));
                        }
                    }
                    int diff = list2.get(0) - list.get(0);
                    boolean flag = true;
                    for (int k = 0; k < list2.size(); k++) {
                        if (list2.get(k) - list.get(k) != diff) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return diff;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
    }

}
