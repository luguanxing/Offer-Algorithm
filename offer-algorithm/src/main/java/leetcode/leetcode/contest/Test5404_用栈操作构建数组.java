package leetcode.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class Test5404_用栈操作构建数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().buildArray(new int[]{1, 3}, 3));
        System.out.println(new Solution().buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(new Solution().buildArray(new int[]{1, 2}, 4));
        System.out.println(new Solution().buildArray(new int[]{2, 3, 4}, 4));
    }

    static class Solution {
        public List<String> buildArray(int[] target, int n) {
            // 遇到缺失的数字插入push/pop对，否则插入push
            int num = 1;
            int index = 0;
            List<String> result = new ArrayList<>();
            while (index < target.length && num <= n) {
                if (num != target[index]) {
                    // 缺失情况下继续匹配下一个num
                    result.add("Push");
                    result.add("Pop");
                } else {
                    // 匹配情况下继续匹配下一个num,target[index]
                    result.add("Push");
                    index++;
                }
                num++;
            }
            return result;
        }
    }

}
