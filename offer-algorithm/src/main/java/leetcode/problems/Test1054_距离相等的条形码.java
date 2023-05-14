package leetcode.problems;

import java.util.*;

public class Test1054_距离相等的条形码 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
        System.out.println(Arrays.toString(new Solution().rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})));
        System.out.println(Arrays.toString(new Solution().rearrangeBarcodes(new int[]{2, 2, 2, 1, 5})));
        System.out.println(Arrays.toString(new Solution().rearrangeBarcodes(new int[]{3, 7, 3, 7, 7, 7, 7, 2, 2, 2})));
    }

    static class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int barcode : barcodes) {
                map.put(barcode, map.getOrDefault(barcode, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
            for (int k : map.keySet()) {
                int v = map.get(k);
                pq.add(new int[]{k, v});
            }
            int len = barcodes.length;
            int[] res = new int[len];
            int last = -1;
            for (int i = 0; i < len; i++) {
                int b = -1;
                int c = -1;
                for (int[] kv : pq) {
                    int barcode = kv[0];
                    int cnt = kv[1];
                    if (barcode != last) {
                        pq.remove(kv);
                        b = barcode;
                        c = cnt;
                        break;
                    }
                }
                res[i] = b;
                last = b;
                if (c - 1 > 0) {
                    pq.add(new int[]{b, c - 1});
                }
            }
            return res;
        }
    }

}
