package leetcode.contest.week213;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test5554_能否连接形成数组 {

    public static void main(String[] args) {
        System.out.println(
                new Solution().canFormArray(
                        new int[]{85},
                        new int[][]{
                                new int[]{85},
                        }
                )
        );
        System.out.println(
                new Solution().canFormArray(
                        new int[]{15, 88},
                        new int[][]{
                                new int[]{88},
                                new int[]{15},
                        }
                )
        );
        System.out.println(
                new Solution().canFormArray(
                        new int[]{49, 18, 16},
                        new int[][]{
                                new int[]{16, 18, 49},
                        }
                )
        );
        System.out.println(
                new Solution().canFormArray(
                        new int[]{91, 4, 64, 78},
                        new int[][]{
                                new int[]{78},
                                new int[]{4, 64},
                                new int[]{91},
                        }
                )
        );
        System.out.println(
                new Solution().canFormArray(
                        new int[]{1, 3, 5, 7},
                        new int[][]{
                                new int[]{2, 4, 6, 8},
                        }
                )
        );
    }

    static class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            String arrStr = Arrays.stream(arr).boxed().collect(Collectors.toList()).toString();
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            for (int[] piece : pieces) {
                String pieceStr = Arrays.stream(piece).boxed().collect(Collectors.toList()).toString();
                pieceStr = pieceStr.substring(1, pieceStr.length() - 1);
                if (!arrStr.contains(pieceStr)) {
                    return false;
                }
            }
            return true;
        }
    }

}
