package leetcode.contest.week291;

import java.util.Arrays;

public class Test6050_字符串的总引力 {

    public static void main(String[] args) {
        System.out.println(new Solution().appealSum("abbca"));
        System.out.println(new Solution().appealSum("code"));
    }

    static class Solution {
        public long appealSum(String s) {
            // 使用lastIndexs[c]表示c上次出现时的索引
            int[] lastIndexs = new int[26];
            Arrays.fill(lastIndexs, -1);
            long currentG = 0;
            long res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int lastIndex = lastIndexs[c - 'a'];
                if (lastIndex == -1) {
                    // 若s[i]之前未出现过，s[i]作为连续字符串的末尾，则总引力可加上i-0+1=i+1
                    currentG += i + 1;
                } else {
                    // 若s[i]之前已出现过且位置为lastIndex，s[i]作为连续字符串的末尾，则总引力可加上j+1到i的数量即i-(lastIndex+1)+1=i-lastIndex
                    currentG += i - lastIndex;
                }
                res += currentG;
                lastIndexs[c - 'a'] = i;
            }
            return res;
        }
    }

}
