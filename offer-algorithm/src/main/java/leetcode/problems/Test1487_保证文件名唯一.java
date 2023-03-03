package leetcode.problems;

import java.util.*;

public class Test1487_保证文件名唯一 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{
                "pes", "fifa", "gta", "pes(2019)"
        })));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{
                "gta", "gta(1)", "gta", "avalon"
        })));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{
                "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"
        })));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{
                "wano", "wano", "wano", "wano"
        })));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{
                "kaido", "kaido(1)", "kaido", "kaido(1)"
        })));
    }

    static class Solution {
        public String[] getFolderNames(String[] names) {
            int len = names.length;
            Map<String, Integer> map = new HashMap<>();
            String[] res = new String[len];
            for (int i = 0; i < len; i++) {
                String name = names[i];
                if (map.containsKey(name)) {
                    int idx = map.get(name);
                    String newName = name + "(" + (idx + 1) + ")";
                    while (map.containsKey(newName)) {
                        idx++;
                        newName = name + "(" + idx + ")";
                    }
                    map.put(name, idx);
                    map.put(newName, 0);
                    res[i] = newName;
                } else {
                    map.put(name, 0);
                    res[i] = name;
                }
            }
            return res;
        }
    }

}
