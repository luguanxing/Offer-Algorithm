package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0165_比较版本号 {

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion(
                "1.01", "1.001"
        ));
        System.out.println(new Solution().compareVersion(
                "1.0", "1.0.0"
        ));
        System.out.println(new Solution().compareVersion(
                "0.1", "1.1"
        ));
        System.out.println(new Solution().compareVersion(
                "1.0.1", "1"
        ));
        System.out.println(new Solution().compareVersion(
                "7.5.2.4", "7.5.3"
        ));
        System.out.println(new Solution().compareVersion(
                "1", "1.1"
        ));
    }

    static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] s1 = version1.split("\\.");
            String[] s2 = version2.split("\\.");
            List<Integer> nums1 = new ArrayList<>();
            List<Integer> nums2 = new ArrayList<>();
            for (String s : s1) {
                nums1.add(Integer.parseInt(s));
            }
            for (String s : s2) {
                nums2.add(Integer.parseInt(s));
            }
            for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
                if (i >= s1.length || i >= s2.length) {
                    int sum1 = nums1.stream().reduce(Integer::sum).orElse(0);
                    int sum2 = nums2.stream().reduce(Integer::sum).orElse(0);
                    if (sum1 == sum2) {
                        continue;
                    } else if (sum1 < sum2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                if (nums1.get(i) < nums2.get(i)) {
                    return -1;
                } else if (nums1.get(i) > nums2.get(i)) {
                    return 1;
                }
            }
            return 0;
        }
    }

}
