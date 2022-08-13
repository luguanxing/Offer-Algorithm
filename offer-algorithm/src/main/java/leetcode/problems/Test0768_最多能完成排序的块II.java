package leetcode.problems;

import java.util.TreeMap;

public class Test0768_最多能完成排序的块II {

    public static void main(String[] args) {
        System.out.println(new Solution().maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
        System.out.println(new Solution().maxChunksToSorted(new int[]{4, 2, 2, 1, 1}));
        System.out.println(new Solution().maxChunksToSorted(new int[]{1, 1, 0, 0, 1}));
        System.out.println(new Solution().maxChunksToSorted(new int[]{0, 3, 0, 3, 2}));
        System.out.println(new Solution().maxChunksToSorted(new int[]{1, 0, 1, 3, 2}));
    }

    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            TreeMap<Integer, Integer> cntMap = new TreeMap<>();
            for (int num : arr) {
                cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            }
            // 对于每一个num，只有比自己小的数和自己对应的cnt减完了才能分组
            int res = 0;
            int max = 0;
            for (int num : arr) {
                max = Math.max(max, num);
                int cnt = cntMap.get(num);
                if (cntMap.lowerKey(num) == null) {
                    if (num == max) {
                        // 当前是max，只要cnt大于0即可分组
                        res++;
                    } else if (cnt == 1 && cntMap.lowerKey(max) == num) {
                        // 当前不是max，只有cnt为1且和max之间没其他数才可分组
                        res++;
                    }
                }
                cntMap.put(num, cnt - 1);
                if (cnt - 1 == 0) {
                    cntMap.remove(num);
                }
            }
            return res;
        }
    }

    class Solution_Detail {
        public int maxChunksToSorted(int[] arr) {
            TreeMap<Integer, Integer> cntMap = new TreeMap<>();
            for (int num : arr) {
                cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            }
            // 对于每一个num，只有比自己小的数和自己(如果当前不为max)对应的cnt减完了才能分组
            int res = 0;
            int max = 0;
            for (int num : arr) {
                max = Math.max(max, num);
                int cnt = cntMap.get(num);
                if (cntMap.lowerKey(num) == null) {
                    // 没有更小的数了
                    if (num == max) {
                        // 当前是max，只要cnt大于0即可分组
                        res++;
                        cntMap.put(num, cnt - 1);
                        if (cnt - 1 == 0) {
                            cntMap.remove(num);
                        }
                    } else {
                        // 当前不是max，只有cnt为1才可分组
                        if (cnt == 1 && cntMap.lowerKey(max) == num) {
                            res++;
                        }
                        cntMap.put(num, cnt - 1);
                        if (cnt - 1 == 0) {
                            cntMap.remove(num);
                        }
                    }
                } else {
                    // 还有更小的数，只减去自己对应的cnt
                    cntMap.put(num, cnt - 1);
                    if (cnt - 1 == 0) {
                        cntMap.remove(num);
                    }
                }
            }
            return res;
        }
    }

}
