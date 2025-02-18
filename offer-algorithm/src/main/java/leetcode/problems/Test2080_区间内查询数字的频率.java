package leetcode.problems;

import java.util.*;

public class Test2080_区间内查询数字的频率 {

    public static void main(String[] args) {
        RangeFreqQuery rfq1 = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rfq1.query(1, 2, 4));
        System.out.println(rfq1.query(0, 11, 33));
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
            // 找满足idx1 >= left的最小idx1，即左边界
            List<Integer> list = map.get(value);
            int l = 0;
            int r = list.size();
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid) < left) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int idx1 = l;
            // 找idx2 <= right的最大idx2，即右边界
            l = 0;
            r = list.size();
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid) <= right) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int idx2 = l - 1;
            // 计算两个序号相差结果
            return idx2 - idx1 + 1;
        }
    }


}
