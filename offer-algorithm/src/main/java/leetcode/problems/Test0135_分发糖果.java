package leetcode.problems;

public class Test0135_分发糖果 {

    public static void main(String[] args) {
        System.out.println(new Solution().candy(
                new int[]{1, 0, 2}
        ));
        System.out.println(new Solution().candy(
                new int[]{1, 2, 2}
        ));
        System.out.println(new Solution().candy(
                new int[]{1, 3, 2, 2, 1}
        ));
    }

    static class Solution {
        public int candy(int[] ratings) {
            int len = ratings.length;
            int[] left = new int[len];
            int[] right = new int[len];
            left[0] = 1;
            for (int i = 1; i < len; i++) {
                if (ratings[i - 1] < ratings[i]) {
                    left[i] = left[i - 1] + 1;
                } else if (ratings[i - 1] == ratings[i]) {
                    left[i] = 1;
                } else {
                    left[i] = 1;
                    for (int j = i - 1; j >= 0; j--) {
                        if (ratings[j] > ratings[j + 1] && left[j] <= left[j + 1]) {
                            left[j]++;
                        } else {
                            break;
                        }
                    }
                }
            }
            right[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                } else if (ratings[i] == ratings[i + 1]) {
                    right[i] = 1;
                } else {
                    right[i] = 1;
                    for (int j = i; j < len - 1; j++) {
                        if (ratings[j] < ratings[j + 1] && right[j] <= right[j + 1]) {
                            right[j + 1]++;
                        } else {
                            break;
                        }
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < len; i++) {
                res += Math.min(left[i], right[i]);
            }
            return res;
        }
    }

}
