package offer;

public class Test10_矩形覆盖 {

    public static void main(String[] args) {
        System.out.println(new Solution().RectCover(1));
        System.out.println(new Solution().RectCover(2));
        System.out.println(new Solution().RectCover(3));
    }

    static class Solution {
        public int RectCover(int n) {
            int[] nums = new int[n + 3];
            nums[1] = 1;    // 一块竖的矩形
            nums[2] = 2;    // 两块竖的矩形或者两块横的矩形
            for (int len = 3; len <= n; len++) {
                // 长度为len的矩形可以由长度为len-1的矩形加1块竖矩形或者长度为len-2加2块横矩形凑出
                nums[len] = nums[len - 1] + nums[len - 2];
            }
            return nums[n];
        }
    }

}
