package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test1233_删除子文件夹 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
        System.out.println(new Solution().removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"}));
        System.out.println(new Solution().removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
        System.out.println(new Solution().removeSubfolders(new String[]{"/ah/al/am", "/ah/al"}));
        System.out.println(new Solution().removeSubfolders(new String[]{"/c","/d/c/e"}));
    }

    static class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder, Comparator.comparingInt(String::length));
            List<String> list = new ArrayList<>();
            for (String f : folder) {
                boolean hasPrefix = false;
                for (String prefix : list) {
                    if (f.startsWith(prefix + "/")) {
                        hasPrefix = true;
                        break;
                    }
                }
                if (!hasPrefix) {
                    list.add(f);
                }
            }
            return list;
        }
    }

}
