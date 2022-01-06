package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test0071_简化路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("//"));
    }

    static class Solution {
        public String simplifyPath(String path) {
            // 去掉多余的"/"
            while (path.contains("//")) {
                path = path.replaceAll("//", "/");
            }
            while (path.endsWith("/") && path.length() > 1) {
                path = path.substring(0, path.length() - 1);
            }
            // 计算层次
            List<String> dirs = new ArrayList<>();
            for (String dir : path.split("/")) {
                if (dir.isEmpty() || ".".equals(dir)) {
                    continue;
                }
                if ("..".equals(dir)) {
                    if (!dirs.isEmpty()) {
                        dirs.remove(dirs.size() - 1);
                    }
                    continue;
                }
                dirs.add(dir);
            }
            return dirs.stream().collect(Collectors.joining("/", "/", ""));
        }
    }

}
