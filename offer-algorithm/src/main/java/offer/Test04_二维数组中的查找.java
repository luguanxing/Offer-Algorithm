package offer;

public class Test04_二维数组中的查找 {

    public static void main(String[] args) {
        int[][] array = new int[4][];
        array[0] = new int[]{1, 2, 8, 9};
        array[1] = new int[]{2, 4, 9, 12};
        array[2] = new int[]{4, 7, 10, 13};
        array[3] = new int[]{6, 8, 11, 15};
        System.out.println(new Solution().Find(5, array));
        System.out.println(new Solution_压缩更小范围().Find(5, array));
    }

    static class Solution {
        public boolean Find(int target, int[][] array) {
            if (array == null) {
                return false;
            }
            int x = 0;
            int y = array.length - 1;
            while (x < array[0].length && 0 <= y) {
                int value = array[y][x];
                if (value == target) {
                    return true;
                } else if (value < target) {
                    x++;
                } else {
                    y--;
                }
            }
            return  false;
        }
    }

    static class Solution_压缩更小范围 {
        public boolean Find(int target, int[][] array) {
            if (array == null) {
                return false;
            }
            int x = array[0].length - 1;
            int y = 0;
            while (0 <= x && y < array.length) {
                int value = array[y][x];
                if (value == target) {
                    return true;
                } else if (target < value) {
                    x--;
                } else {
                    y++;
                }
            }
            return  false;
        }
    }

}
