package leetcode.contest.week268;

import java.util.*;

public class Test5186_区间内查询数字的频率 {

    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rangeFreqQuery.query(1, 2, 4));
        System.out.println(rangeFreqQuery.query(0, 11, 33));
    }

    static class RangeFreqQuery {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                list.add(i);
                map.put(num, list);
            }
        }

        public int query(int left, int right, int value) {
            if (!map.containsKey(value)) {
                return 0;
            }
            List<Integer> list = map.get(value);
            int start = binarySearchLeftIndex(list, left);
            int end = binarySearchRightIndex(list, right);
            return end - start + 1;
        }

        private int binarySearchLeftIndex(List<Integer> list, int target) {
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) == target) {
                    right = mid;
                } else if (list.get(mid) < target) {
                    left = mid + 1;
                } else if (list.get(mid) > target) {
                    right = mid;
                }
            }
            return left;
        }

        private int binarySearchRightIndex(List<Integer> list, int target) {
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) == target) {
                    left = mid + 1;
                } else if (list.get(mid) < target) {
                    left = mid + 1;
                } else if (list.get(mid) > target) {
                    right = mid;
                }
            }
            return left - 1;
        }
    }

}
