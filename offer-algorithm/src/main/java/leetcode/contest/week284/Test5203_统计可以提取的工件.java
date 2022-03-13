package leetcode.contest.week284;

import java.util.HashSet;
import java.util.Set;

public class Test5203_统计可以提取的工件 {

    public static void main(String[] args) {
        System.out.println(new Solution().digArtifacts(
                2, new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}}, new int[][]{{0, 0}, {0, 1}}
        ));
        System.out.println(new Solution().digArtifacts(
                2, new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}}, new int[][]{{0, 0}, {0, 1}, {1, 1}}
        ));
    }

    static class Solution {
        public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
            // 保存挖掘位置
            Set<String> digSet = new HashSet<>();
            for (int[] d : dig) {
                int digY = d[0];
                int digX = d[1];
                digSet.add(digY + "," + digX);
            }
            // 检查所有组件是否挖过
            int res = 0;
            for (int[] artifact : artifacts) {
                int leftY = artifact[0];
                int leftX = artifact[1];
                int rightY = artifact[2];
                int rightX = artifact[3];
                boolean isOk = true;
                for (int y = leftY; y <= rightY; y++) {
                    for (int x = leftX; x <= rightX; x++) {
                        if (!digSet.contains(y + "," + x)) {
                            isOk = false;
                            break;
                        }
                    }
                }
                if (isOk) {
                    res++;
                }
            }
            return res;
        }
    }

}
