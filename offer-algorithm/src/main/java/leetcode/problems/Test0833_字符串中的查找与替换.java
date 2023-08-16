package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test0833_字符串中的查找与替换 {

    public static void main(String[] args) {
        System.out.println(new Solution2().findReplaceString(
                "abcd",
                new int[]{0, 2},
                new String[]{"a", "cd"},
                new String[]{"eee", "ffff"}
        ));
        System.out.println(new Solution2().findReplaceString(
                "abcd",
                new int[]{0, 2},
                new String[]{"ab", "ec"},
                new String[]{"eee", "ffff"}
        ));
        System.out.println(new Solution2().findReplaceString(
                "vmokgggqzp",
                new int[]{3, 5, 1},
                new String[]{"kg", "ggq", "mo"},
                new String[]{"s", "so", "bfr"}
        ));
        System.out.println(new Solution2().findReplaceString(
                "mhnbzxkwzxtaanmhtoirxheyanoplbvjrovzudznmetkkxrdmr",
                new int[]{46, 29, 2, 44, 31, 26, 42, 9, 38, 23, 36, 12, 16, 7, 33, 18},
                new String[]{"rym", "kv", "nbzxu", "vx", "js", "tp", "tc", "jta", "zqm", "ya", "uz", "avm", "tz", "wn", "yv", "ird"},
                new String[]{"gfhc", "uq", "dntkw", "wql", "s", "dmp", "jqi", "fp", "hs", "aqz", "ix", "jag", "n", "l", "y", "zww"}
        ));
    }

    static class Solution2 {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            int len = indices.length;
            Info[] infos = new Info[len];
            for (int i = 0; i < len; i++) {
                infos[i] = new Info(indices[i], sources[i], targets[i]);
            }
            Arrays.sort(infos, Comparator.comparingInt(o -> o.index));
            for (int i = len - 1; i >= 0; i--) {
                int index = infos[i].index;
                String source = infos[i].source;
                String target = infos[i].target;
                // 从后往前替换，不影响前面顺序
                if (s.substring(index).startsWith(source)) {
                    s = s.substring(0, index) + target + s.substring(index + source.length());
                }
            }
            return s;
        }

        class Info {
            int index;
            String source;
            String target;

            public Info(int index, String source, String target) {
                this.index = index;
                this.source = source;
                this.target = target;
            }
        }
    }

    static class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            int len = indices.length;
            Info[] infos = new Info[len];
            for (int i = 0; i < len; i++) {
                infos[i] = new Info(indices[i], sources[i], targets[i]);
            }
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                boolean isMatch = false;
                for (int idx = 0; idx < len; idx++) {
                    int index = infos[idx].index;
                    String source = infos[idx].source;
                    String target = infos[idx].target;
                    if (index == i && s.substring(i).startsWith(source)) {
                        res += target;
                        i += source.length() - 1;
                        isMatch = true;
                        break;
                    }
                }
                if (!isMatch) {
                    res += s.charAt(i);
                }
            }
            return res;
        }

        class Info {
            int index;
            String source;
            String target;

            public Info(int index, String source, String target) {
                this.index = index;
                this.source = source;
                this.target = target;
            }
        }
    }

}
