package leetcode.problems;

public class Test1024_视频拼接 {

    public static void main(String[] args) {
        System.out.println(new Solution().videoStitching(
                new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10
        ));
        System.out.println(new Solution().videoStitching(
                new int[][]{{0, 1}, {1, 2}}, 5
        ));
        System.out.println(new Solution().videoStitching(
                new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}
                , 9
        ));
        System.out.println(new Solution().videoStitching(
                new int[][]{{0, 4}, {2, 8}}
                , 5
        ));
        System.out.println(new Solution().videoStitching(
                new int[][]{{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}}
                , 5
        ));
    }

    static class Solution {
        public int videoStitching(int[][] clips, int T) {
            int[] maxTo = new int[T + 1];
            // 先算出最远能到哪个片段
            for (int[] fromTo : clips) {
                int from = fromTo[0];
                int to = fromTo[1];
                if (from > T) {
                    from = T;
                }
                if (to > T) {
                    to = T;
                }
                maxTo[from] = Math.max(maxTo[from], to);
            }
            // 从0开始看看能不能到T，注意每次需要找到下个区间内的最大值，再扩大到下个区间
            int next = maxTo[0];
            int nextMax = next;
            int res = 1;
            for (int i = 0; i <= next; i++) {
                if (next < maxTo[i]) {
                    nextMax = Math.max(nextMax, maxTo[i]);
                }
                if (i == next && nextMax > next) {
                    next = nextMax;
                    res++;
                }
            }
            if (next == T) {
                return res;
            } else {
                return -1;
            }
        }
    }

}
