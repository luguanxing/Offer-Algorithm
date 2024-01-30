package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test0365_水壶问题 {

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(3, 5, 4)); // true
        System.out.println(new Solution().canMeasureWater(2, 6, 5)); // false
        System.out.println(new Solution().canMeasureWater(1, 2, 3)); // true
        System.out.println(new Solution().canMeasureWater(34, 5, 6)); // true
        System.out.println(new Solution().canMeasureWater(11, 3, 13)); // true
        System.out.println(new Solution().canMeasureWater(13, 11, 1)); // true
    }

    static class Solution {
        boolean result = false;
        int jug1Capacity = 0;
        int jug2Capacity = 0;
        int targetCapacity = 0;
        Set<String> visited = new HashSet<>();

        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
            if (targetCapacity > jug1Capacity + jug2Capacity) {
                return false;
            }
            if (targetCapacity == 0 || targetCapacity == jug1Capacity || targetCapacity == jug2Capacity || targetCapacity == jug1Capacity + jug2Capacity) {
                return true;
            }
            // 使用递归判断
            this.jug1Capacity = jug1Capacity;
            this.jug2Capacity = jug2Capacity;
            this.targetCapacity = targetCapacity;
            dfs(0, 0);
            return result;
        }

        private void dfs(int jug1, int jug2) {
            if (result || visited.contains(jug1 + "," + jug2)) {
                return;
            }
            if (jug1 == targetCapacity || jug2 == targetCapacity || jug1 + jug2 == targetCapacity) {
                result = true;
                return;
            }
            visited.add(jug1 + "," + jug2);
            // 1. 把第一个水壶灌满
            dfs(jug1Capacity, jug2);
            // 2. 把第二个水壶灌满
            dfs(jug1, jug2Capacity);
            // 3. 把第一个水壶倒空
            dfs(0, jug2);
            // 4. 把第二个水壶倒空
            dfs(jug1, 0);
            // 5. 把第一个水壶的水倒入第二个水壶，直至倒空或者第二个水壶满
            dfs(jug1 - Math.min(jug1, jug2Capacity - jug2), jug2 + Math.min(jug1, jug2Capacity - jug2));
            // 6. 把第二个水壶的水倒入第一个水壶，直至倒空或者第一个水壶满
            dfs(jug1 + Math.min(jug2, jug1Capacity - jug1), jug2 - Math.min(jug2, jug1Capacity - jug1));
        }
    }

}
