package leetcode.contest.week194;

import java.util.*;

public class Test5441_保证文件名唯一 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{"pes","fifa","gta","pes(2019)"})));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{"gta","gta(1)","gta","avalon"})));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"})));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{"wano","wano","wano","wano"})));
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"})));
    }

    static class Solution {
        public String[] getFolderNames(String[] names) {
            String[] res = new String[names.length];
            Map<String, Integer> map = new HashMap<>();
            int resIndex = 0;
            for (String name : names) {
                // 检测文件名是否存在
                String fileName;
                if (map.containsKey(name)) {
                    int count = map.get(name) + 1;
                    fileName = name + "(" + count + ")";
                    while (map.containsKey(fileName)) {
                        count++;
                        fileName = name + "(" + count + ")";
                    }
                    map.put(name, count);
                    map.put(fileName, 0);
                } else {
                    fileName = name;
                    map.put(name, 0);
                }
                // 保存到结果
                res[resIndex++] = fileName;
            }
            return res;
        }
    }

}
