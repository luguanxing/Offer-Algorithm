package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0846_一手顺子 {

    public static void main(String[] args) {
        System.out.println(new Solution().isNStraightHand(
                new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3
        ));
        System.out.println(new Solution().isNStraightHand(
                new int[]{1, 2, 3, 4, 5}, 4
        ));
        System.out.println(new Solution().isNStraightHand(
                new int[]{1, 2, 3, 4, 5, 6}, 2
        ));
        System.out.println(new Solution().isNStraightHand(
                new int[]{8, 8, 9, 7, 7, 7, 6, 7, 10, 6}, 2
        ));
    }

    static class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            // 不能分成整数组或一组一个的情况
            if (hand.length % groupSize != 0) {
                return false;
            }
            if (groupSize == 1) {
                return true;
            }
            // 统计个数
            Map<Integer, Integer> map = new HashMap<>();
            for (int h : hand) {
                map.put(h, map.getOrDefault(h, 0) + 1);
            }
            // 判断能否组成顺子
            int groupCount = hand.length / groupSize;
            int filledCount = 0;
            // 需要排序，从小开始组成
            Set<Integer> set = Arrays.stream(hand).boxed().collect(Collectors.toCollection(TreeSet::new));
            for (int h : set) {
                boolean isOk = true;
                for (int i = 0; i < groupSize; i++) {
                    isOk &= map.containsKey(h + i);
                }
                if (isOk) {
                    int size = map.get(h);
                    for (int i = 0; i < groupSize; i++) {
                        int cnt = map.get(h + i);
                        if (cnt == size) {
                            map.remove(h + i);
                        } else if (cnt > size) {
                            map.put(h + i, cnt - size);
                        } else {
                            return false;
                        }
                    }
                    filledCount += size;
                }
            }
            return filledCount == groupCount;
        }
    }

    static class Solution_TLE {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            // 不能分成整数组或一组一个的情况
            if (hand.length % groupSize != 0) {
                return false;
            }
            if (groupSize == 1) {
                return true;
            }
            // 统计个数
            Map<Integer, Integer> map = new HashMap<>();
            for (int h : hand) {
                map.put(h, map.getOrDefault(h, 0) + 1);
            }
            // 判断能否组成顺子
            int groupCount = hand.length / groupSize;
            int filledCount = 0;
            // 需要排序，从小开始组成
            Arrays.sort(hand);
            for (int h : hand) {
                boolean isOk = true;
                for (int i = 0; i < groupSize; i++) {
                    isOk &= map.containsKey(h + i);
                }
                if (isOk) {
                    for (int i = 0; i < groupSize; i++) {
                        int cnt = map.get(h + i);
                        if (cnt == 1) {
                            map.remove(h + i);
                        } else {
                            map.put(h + i, cnt - 1);
                        }
                    }
                    filledCount++;
                }
            }
            return filledCount == groupCount;
        }
    }

}
