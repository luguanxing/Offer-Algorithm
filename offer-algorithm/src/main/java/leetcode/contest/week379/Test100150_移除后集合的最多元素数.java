package leetcode.contest.week379;

import java.util.*;

public class Test100150_移除后集合的最多元素数 {

    public static void main(String[] args) {
        // nums1 = [1,2,1,2], nums2 = [1,1,1,1]
        System.out.println(new Solution().maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}));
        // nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]
        System.out.println(new Solution().maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
        // nums1 = [1,1,2,2,3,3], nums2 = [4,4,5,5,6,6]
        System.out.println(new Solution().maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}));
        // [1,2,1,1] , [1,2,3,4]
        System.out.println(new Solution().maximumSetSize(new int[]{1, 2, 1, 1}, new int[]{1, 2, 3, 4}));
        // [1,1,1,1], [12,23,41,9]
        System.out.println(new Solution().maximumSetSize(new int[]{1, 1, 1, 1}, new int[]{12, 23, 41, 9}));
    }

    static class Solution {
        public int maximumSetSize(int[] nums1, int[] nums2) {
            // 使用哈希表记录两个数组中每个数字的频率
            Map<Integer, int[]> freq = new HashMap<>();
            for (int num : nums1) {
                int[] arr = freq.getOrDefault(num, new int[2]);
                arr[0]++;
                freq.put(num, arr);
            }
            for (int num : nums2) {
                int[] arr = freq.getOrDefault(num, new int[2]);
                arr[1]++;
                freq.put(num, arr);
            }
            // 优先删除频率多的数字
            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : freq.keySet()) {
                int[] arr = freq.get(num);
                if (arr[0] > 1) {
                    cnt1 += arr[0] - 1;
                    arr[0] = 1;
                }
                if (arr[1] > 1) {
                    cnt2 += arr[1] - 1;
                    arr[1] = 1;
                }
            }
            // 看看各自是否删够了N/2个，优先删另一边也有的
            int len = nums1.length;
            if (cnt1 < len / 2) {
                List<int[]> list = new ArrayList<>();
                for (int k : freq.keySet()) {
                    int p = 0;
                    int[] arr = freq.get(k);
                    if (arr[0] > 0) {
                        p++;
                        if (arr[1] > 0) {
                            p++;
                        }
                    }
                    list.add(new int[]{k, p});
                }
                Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);
                int idx = 0;
                for (int i = cnt1; i < len / 2; i++) {
                    int[] arr = freq.get(list.get(idx)[0]);
                    arr[0] = 0;
                    idx++;
                }
            }
            if (cnt2 < len / 2) {
                List<int[]> list = new ArrayList<>();
                for (int k : freq.keySet()) {
                    int p = 0;
                    int[] arr = freq.get(k);
                    if (arr[1] > 0) {
                        p++;
                        if (arr[0] > 0) {
                            p++;
                        }
                    }
                    list.add(new int[]{k, p});
                }
                Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);
                int idx = 0;
                for (int i = cnt2; i < len / 2; i++) {
                    int[] arr = freq.get(list.get(idx)[0]);
                    arr[1] = 0;
                    idx++;
                }
            }
            // 返回结果
            int res = 0;
            for (int[] arr : freq.values()) {
                if (arr[0] + arr[1] > 0) {
                    res++;
                }
            }
            return res;
        }
    }


}
