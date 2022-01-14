package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Test0373_查找和最小的K对数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().kSmallestPairs(
                new int[]{1, 7, 11},
                new int[]{2, 4, 6},
                3
        ));
        System.out.println(new Solution().kSmallestPairs(
                new int[]{1, 1, 2},
                new int[]{1, 2, 3},
                2
        ));
        System.out.println(new Solution().kSmallestPairs(
                new int[]{1, 2},
                new int[]{3},
                3
        ));
    }

    static class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<Tuple> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.sum(), o1.sum()));
            int MAX_INDEX = 1005;
            for (int i = 0; i < Math.min(nums1.length, MAX_INDEX); i++) {
                for (int j = 0; j < Math.min(nums2.length, MAX_INDEX); j++) {
                    int num1 = nums1[i];
                    int num2 = nums2[j];
                    queue.add(new Tuple(num1, num2));
                    if (queue.size() > k) {
                        queue.poll();
                    }
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            for (Tuple tuple : queue) {
                List<Integer> list = new ArrayList<>();
                list.add(tuple.num1);
                list.add(tuple.num2);
                res.add(list);
            }
            return res;
        }

        class Tuple {
            int num1;
            int num2;

            public Tuple(int num1, int num2) {
                this.num1 = num1;
                this.num2 = num2;
            }

            public int sum() {
                return num1 + num2;
            }
        }
    }

}
