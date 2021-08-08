package leetcode.contest.week253;

import java.util.Stack;

public class Test5840_使字符串平衡的最小交换次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps("][]["));
        System.out.println(new Solution().minSwaps("]]][[["));
        System.out.println(new Solution().minSwaps("[]"));
        System.out.println(new Solution().minSwaps("[[]]"));
        System.out.println(new Solution().minSwaps("]]]][[[["));
        System.out.println(new Solution().minSwaps("]]]]][[[[["));
        System.out.println(new Solution().minSwaps("][][][][[]"));
        System.out.println(new Solution().minSwaps("[[[]]]][][]][[]]][[["));
        System.out.println(new Solution().minSwaps("[[[][[]][[[][][]]]]]"));
        System.out.println(new Solution().minSwaps("[][[[][[[]]]]][]"));
    }

    static class Solution {
        public int minSwaps(String s) {
            int res = 0;
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    // 左括号数量+1
                    cnt++;
                } else if (c == ']') {
                    if (cnt > 0) {
                        // 能匹配左括号
                        cnt--;
                    } else {
                        // 不能匹配左括号，从后边替换掉一个左括号
                        cnt++;
                        res++;
                    }
                }
            }
            // 返回最终要替换才能匹配的括号数目
            return res;
        }
    }

}
