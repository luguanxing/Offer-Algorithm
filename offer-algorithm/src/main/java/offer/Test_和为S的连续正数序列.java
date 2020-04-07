package offer;

import java.util.ArrayList;

public class Test_和为S的连续正数序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().FindContinuousSequence(3));
        System.out.println(new Solution().FindContinuousSequence(100));
    }

    static class Solution {
        public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int left = 1;
            int right = 2;
            int curSum = 3;
            // 使用滑动窗口维护序列和
            while (left + right <= sum && left < sum && right < sum) {
                if (curSum < sum) {
                    right++;
                    curSum += right;
                } else if (curSum > sum) {
                    curSum -= left;
                    left++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        list.add(i);
                    }
                    result.add(list);
                    left++;
                    right++;
                    curSum += ((right - left) + 1);
                }
            }
            return result;
        }
    }

}
