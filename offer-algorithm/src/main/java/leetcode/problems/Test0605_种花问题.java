package leetcode.problems;

public class Test0605_种花问题 {

    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(
                new int[]{1, 0, 0, 0, 1}, 1
        ));
        System.out.println(new Solution().canPlaceFlowers(
                new int[]{1, 0, 0, 0, 1}, 2
        ));
        System.out.println(new Solution().canPlaceFlowers(
                new int[]{1, 0, 1, 0, 1, 0, 1}, 1
        ));
        System.out.println(new Solution().canPlaceFlowers(
                new int[]{0, 0, 1, 0, 1}, 1
        ));
        System.out.println(new Solution().canPlaceFlowers(
                new int[]{1, 0, 1, 0, 0}, 1
        ));
        System.out.println(new Solution().canPlaceFlowers(
                new int[]{1, 0, 1, 0, 0}, 2
        ));
        System.out.println(new Solution().canPlaceFlowers(
                new int[]{0}, 1
        ));
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (flowerbed.length == 1 && flowerbed[0] == 0) {
                n--;
            }
            if (flowerbed.length > 0 && flowerbed[0] == 0) {
                if (flowerbed.length > 1 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    n--;
                }
            }
            if (flowerbed.length > 0 && flowerbed[flowerbed.length - 1] == 0) {
                if (flowerbed.length > 1 && flowerbed[flowerbed.length - 2] == 0) {
                    flowerbed[flowerbed.length - 1] = 1;
                    n--;
                }
            }
            for (int i = 1; i < flowerbed.length - 1; i++) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            return n <= 0;
        }
    }

}
