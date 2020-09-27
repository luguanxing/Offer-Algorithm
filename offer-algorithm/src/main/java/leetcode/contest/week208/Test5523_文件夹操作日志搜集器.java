package leetcode.contest.week208;

import java.util.Stack;

public class Test5523_文件夹操作日志搜集器 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new String[]{
                "d1/", "d2/", "../", "d21/", "./"
        }));
        System.out.println(new Solution().minOperations(new String[]{
                "d1/", "d2/", "./", "d3/", "../", "d31/"
        }));
        System.out.println(new Solution().minOperations(new String[]{
                "d1/", "../", "../", "../"
        }));
    }

    static class Solution {
        public int minOperations(String[] logs) {
            Stack<String> dirs = new Stack<>();
            for (String log : logs) {
                if ("./".equals(log)) {

                } else if ("../".equals(log)) {
                    if (!dirs.isEmpty()) {
                        dirs.pop();
                    }
                } else {
                    dirs.push(log);
                }
            }
            return dirs.size();
        }
    }

}
