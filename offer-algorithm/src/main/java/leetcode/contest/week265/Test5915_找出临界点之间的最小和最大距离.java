package leetcode.contest.week265;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5915_找出临界点之间的最小和最大距离 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getMinMaxIndex(Arrays.stream(new int[]{3,1}).boxed().collect(Collectors.toList()))));
        System.out.println(Arrays.toString(new Solution().getMinMaxIndex(Arrays.stream(new int[]{5, 3, 1, 2, 5, 1, 2}).boxed().collect(Collectors.toList()))));
        System.out.println(Arrays.toString(new Solution().getMinMaxIndex(Arrays.stream(new int[]{1, 3, 2, 2, 3, 2, 2, 2, 7}).boxed().collect(Collectors.toList()))));
        System.out.println(Arrays.toString(new Solution().getMinMaxIndex(Arrays.stream(new int[]{2, 3, 3, 2}).boxed().collect(Collectors.toList()))));
    }

    static class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
            return getMinMaxIndex(list);
        }

        public int[] getMinMaxIndex(List<Integer> list) {
            List<Integer> indexs = new ArrayList<>();
            for (int i = 1; i < list.size() - 1; i++) {
                int last = list.get(i - 1);
                int current = list.get(i);
                int next = list.get(i + 1);
                if ((last < current && next < current) || (last > current && next > current)) {
                    indexs.add(i);
                }
            }
            int[] res = new int[]{-1, -1};
            if (indexs.size() > 1) {
                int max = indexs.get(indexs.size() - 1) - indexs.get(0);
                int min = indexs.get(1) - indexs.get(0);
                for (int i = 1; i < indexs.size(); i++) {
                    min = Math.min(min, indexs.get(i) - indexs.get(i - 1));
                }
                return new int[]{min, max};
            }
            return res;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
