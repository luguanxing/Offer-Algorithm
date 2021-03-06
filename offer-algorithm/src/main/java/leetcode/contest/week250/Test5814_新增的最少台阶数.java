package leetcode.contest.week250;

public class Test5814_新增的最少台阶数 {

    public static void main(String[] args) {
        System.out.println(new Solution().addRungs(
                new int[]{1, 3, 5, 10}, 2
        ));
        System.out.println(new Solution().addRungs(
                new int[]{3, 6, 8, 10}, 3
        ));
        System.out.println(new Solution().addRungs(
                new int[]{3, 4, 6, 7}, 2
        ));
        System.out.println(new Solution().addRungs(
                new int[]{5}, 10
        ));
        System.out.println(new Solution().addRungs(
                new int[]{3}, 1
        ));
        System.out.println(new Solution().addRungs(
                new int[]{1, 2, 3, 5}, 1
        ));
        System.out.println(new Solution().addRungs(
                new int[]{9, 10}, 1
        ));
        System.out.println(new Solution().addRungs(
                new int[]{9, 10, 12}, 1
        ));
    }

    static class Solution {
        public int addRungs(int[] rungs, int dist) {
            int res = 0;
            int pos = 0;
            int index = 0;
            while (index < rungs.length && pos < rungs[rungs.length - 1]) {
                if (pos + dist >= rungs[index]) {
                    // 直接爬上去
                    pos = rungs[index++];
                } else {
                    // 加上梯子
                    int diff = rungs[index] - pos;
                    int add = diff / dist;
                    if (pos + add * dist == rungs[index]) {
                        pos = rungs[index];
                        res += add - 1;
                        continue;
                    }
                    pos += add * dist;
                    res += add;
                }
            }
            return res;
        }
    }

    static class Solution_TLE {
        public int addRungs(int[] rungs, int dist) {
            int res = 0;
            int pos = 0;
            int index = 0;
            while (index < rungs.length && pos < rungs[index]) {
                if (pos + dist >= rungs[index]) {
                    // 直接爬上去
                    pos = rungs[index++];
                } else {
                    // 加上梯子
                    pos += dist;
                    res++;
                }
            }
            return res;
        }
    }

}
