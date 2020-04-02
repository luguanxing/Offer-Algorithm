package offer;

public class Test39_数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3}));
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{2, 2, 2, 2, 2, 1, 3, 4, 5}));
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{1}));
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{}));
        System.out.println(new Solution().MoreThanHalfNum_Solution(null));
    }

    static class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            // 计数出现次数最多的
            int last = array[0];
            int lastCnt = 1;
            for (int i = 1; i < array.length; i++) {
                if (array[i] == last) {
                    // 与上个数相同则计数加一
                    lastCnt++;
                } else {
                    // 与上个数不同则计数减一，计数减到0则重置
                    lastCnt--;
                    if (lastCnt == 0) {
                        last = array[i];
                        lastCnt = 1;
                    }
                }
            }
            // 区分是否受最后一位影响，但同时需要避免误判数组只有1位数的情况
            if (lastCnt == 1 && last == array[array.length - 1] && array.length != 1) {
                return 0;
            } else {
                return last;
            }
        }
    }

}
