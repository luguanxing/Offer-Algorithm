package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0763_划分字母区间 {

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }

    static class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] max = new int[26];
            char[] chars = S.toCharArray();
            // 统计每个字符最远出现的地方(分段时只能比该长度要长)
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                max[c - 'a'] = Math.max(max[c - 'a'], i);
            }
            // 不断划分出最大的段
            List<Integer> res = new ArrayList<>();
            int start = 0;
            int end = max[chars[start] - 'a'];
            while (start < S.length()) {
                for (int i = start + 1; i < end; i++) {
                    end = Math.max(end, max[chars[i] - 'a']);
                }
                res.add(end - start + 1);
                start = end + 1;
                if (start < chars.length) {
                    end = max[chars[end + 1] - 'a'];
                }
            }
            return res;
        }
    }

}
