package leetcode.contest.week271;

public class Test5954_给植物浇水II {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumRefill(new int[]{2, 2, 3, 3}, 5, 5));
        System.out.println(new Solution().minimumRefill(new int[]{2, 2, 3, 3}, 3, 4));
        System.out.println(new Solution().minimumRefill(new int[]{5}, 10, 8));
        System.out.println(new Solution().minimumRefill(new int[]{1, 2, 4, 4, 5}, 6, 5));
        System.out.println(new Solution().minimumRefill(new int[]{2, 2, 5, 2, 2}, 5, 5));
    }

    static class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int res = 0;
            int currentA = capacityA;
            int currentB = capacityB;
            int left = 0;
            int right = plants.length - 1;
            while (left <= right) {
                if (left != right || (currentA > currentB)) {
                    // 左边浇水
                    if (currentA >= plants[left]) {
                        currentA -= plants[left];
                    } else {
                        res++;
                        currentA = capacityA - plants[left];
                    }
                    left++;
                }
                if (left > right) {
                    break;
                }
                // 右边浇水
                if (currentB >= plants[right]) {
                    currentB -= plants[right];
                } else {
                    res++;
                    currentB = capacityB - plants[right];
                }
                right--;
            }
            return res;
        }
    }

}
