package offer;

public class Test33_二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(new Solution().VerifySquenceOfBST(new int[]{7, 4, 6, 5}));
        System.out.println(new Solution().VerifySquenceOfBST(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().VerifySquenceOfBST(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().VerifySquenceOfBST(new int[]{1}));
        System.out.println(new Solution().VerifySquenceOfBST(new int[]{}));
    }

    static class Solution {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence == null) {
                return true;
            }
            if (sequence.length == 0) {
                return false;
            }
            // 验证末尾数字是否能够中分前面的序列
            return isMidPoint(0, sequence.length - 1, sequence);
        }

        private boolean isMidPoint(int start, int end, int[] sequence) {
            if (start >= end) {
                return true;
            }
            int mid = sequence[end];
            // 检测mid是否能够中分sequence[start]至sequence[end-1]
            int midIndex = -1;
            for (int index = start; index <= end; index++) {
                boolean leftOk = true;
                boolean rightOk = true;
                for (int left = 0; left < index; left++) {
                    if (sequence[left] > mid) {
                        leftOk = false;
                        break;
                    }
                }
                for (int right = index; right <= end - 1; right++) {
                    if (sequence[right] < mid) {
                        rightOk = false;
                        break;
                    }
                }
                if ((leftOk && rightOk)) {
                    midIndex = index;
                    break;
                }
            }
            // 能够中分则递归继续检查
            if (midIndex != -1) {
                return isMidPoint(start, midIndex - 1, sequence) && isMidPoint(midIndex, end - 1, sequence);
            } else {
                return false;
            }
        }
    }

}
