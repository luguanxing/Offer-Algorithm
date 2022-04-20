package leetcode.problems;

import java.util.ArrayList;
import java.util.Stack;

public class Test0388_文件的最长绝对路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\new\tsubdir2\n\t\tfile.ext"));
        System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(new Solution().lengthLongestPath("a"));
        System.out.println(new Solution().lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
        System.out.println(new Solution().lengthLongestPath("dir\n        file.txt"));
        System.out.println(new Solution().lengthLongestPath("a\n\tb\n\t\tc.txt\n\taaaa.txt"));
    }

    static class Solution {
        public int lengthLongestPath(String input) {
            String[] paths = input.split("\n");
            int maxLen = 0;
            Stack<String> stack = new Stack<>();
            for (String path : paths) {
                if (!path.contains(".")) {
                    // 文件夹
                    int level = 0;
                    while (path.contains("\t")) {
                        path = path.replaceFirst("\t", "");
                        level++;
                    }
                    while (stack.size() > level) {
                        stack.pop();
                    }
                    stack.add(path);
                } else {
                    // 文件
                    int level = 0;
                    if (path.startsWith("    ")) {
                        path = path.replaceFirst("    ", "\t");
                    }
                    while (path.contains("\t")) {
                        path = path.replaceFirst("\t", "");
                        level++;
                    }
                    while (stack.size() > level) {
                        stack.pop();
                    }
                    int len = 0;
                    for (String dirPath : new ArrayList<>(stack)) {
                        len += dirPath.length() + 1;
                    }
                    len += path.length();
                    maxLen = Math.max(maxLen, len);
                }
            }
            return maxLen;
        }
    }

}
