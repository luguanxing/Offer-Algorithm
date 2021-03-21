package leetcode.contest.week233;

public class Test5711_有界数组中指定下标处的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(4, 2, 6));
        System.out.println(new Solution().maxValue(6, 1, 10));
        System.out.println(new Solution().maxValue(3, 2, 18));
    }

    static class Solution {
        public int maxValue(int n, int index, int maxSum) {
            // 过程模拟，从index开始往两边扩充：维护一个[l,r]范围
            // 每次往范围内每个位置+1，通过这种方式维护一个向上生长的“三角形
            int left = index;
            int right = index;
            // 整个数组一开始全部填充为1
            int res = 1;
            maxSum -= n;
            while (0 < left || right < n - 1) {
                int len = right - left + 1;
                if (maxSum >= len) {
                    // 当前[l,r]范围全部+1
                    res++;
                    maxSum -= len;
                    // 往左右两边扩
                    left = Math.max(0, left - 1);
                    right = Math.min(right + 1, n - 1);
                } else {
                    break;
                }
            }
            // 扩大到整个数组之后，剩余的值“雨露均沾”一下
            res += maxSum / n;
            return res;
        }
    }

}
