package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test1306_跳跃游戏III {

    public static void main(String[] args) {
        System.out.println(new Solution().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(new Solution().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(new Solution().canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    static class Solution {
        boolean isOk;
        boolean[] visited;
        Set<Integer> targets = new HashSet<>();

        public boolean canReach(int[] arr, int start) {
            int len = arr.length;
            visited = new boolean[len];
            for (int i = 0; i < len; i++) {
                if (arr[i] == 0) {
                    targets.add(i);
                }
            }
            dfs(arr, start);
            return isOk;
        }

        public void dfs(int[] arr, int currentIdx) {
            if (currentIdx < 0 || currentIdx >= arr.length || visited[currentIdx]) {
                return;
            }
            if (isOk || targets.contains(currentIdx)) {
                isOk = true;
                return;
            }
            visited[currentIdx] = true;
            dfs(arr, currentIdx + arr[currentIdx]);
            dfs(arr, currentIdx - arr[currentIdx]);
        }
    }

}
