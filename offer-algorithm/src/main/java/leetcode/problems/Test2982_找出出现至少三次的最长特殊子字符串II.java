package leetcode.problems;

import java.util.*;

public class Test2982_找出出现至少三次的最长特殊子字符串II {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("aaaa"));
        System.out.println(new Solution().maximumLength("abcdef"));
        System.out.println(new Solution().maximumLength("abcaba"));
        System.out.println(new Solution().maximumLength("abcccccdddd"));
        System.out.println(new Solution().maximumLength("acc"));
        System.out.println(new Solution().maximumLength("aaa"));
        System.out.println(new Solution().maximumLength("eccdnmcnkl"));
        System.out.println(new Solution().maximumLength("lkwwdddddnnnnnynnnnl"));
        System.out.println(new Solution().maximumLength("ceeeeeeeeeeeebmmmfffeeeeeeeeeeeewww"));
        System.out.println(new Solution().maximumLength("cddedeedccedcedecdedcdeededdddcdddddcdeecdcddeecdc"));
        System.out.println(new Solution().maximumLength("jinhhhtttttttefffffjjjjjjjjjfffffjjjjjjjjjqvvvvvvg"));
    }

    static class Solution {
        public int maximumLength(String s) {
            // 统计字符连续次数
            List<Integer>[] map = new ArrayList[26];
            Arrays.setAll(map, i -> new ArrayList<>());
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnt++;
                if (i == s.length() - 1 || c != s.charAt(i + 1)) {
                    map[c - 'a'].add(cnt);
                    cnt = 0;
                }
            }
            //  根据次数计算结果
            //  （1）从最长的特殊子串（a[0]a[0]a[0]）中取三个长度均为 a[0]−2a[0]-2a[0]−2 的特殊子串。例如示例 1 的 aaaa 可以取三个 aa。
            //  （2）或者，从最长和次长的特殊子串（a[0],a[1]a[0],a[1]a[0],a[1]）中取三个长度一样的特殊子串：
            //      如果 a[0]=a[1]a[0]=a[1]a[0]=a[1]，那么可以取三个长度均为 a[0]−1a[0]-1a[0]−1 的特殊子串。
            //      如果 a[0]>a[1]a[0]>a[1]a[0]>a[1]，那么可以取三个长度均为 a[1]a[1]a[1] 的特殊子串：从最长中取两个，从次长中取一个。
            //      这两种情况合并成 min⁡(a[0]−1,a[1])\min(a[0]-1, a[1])min(a[0]−1,a[1])。
            //  （3）又或者，从最长、次长、第三长的的特殊子串（a[0],a[1],a[2]a[0],a[1],a[2]a[0],a[1],a[2]）中各取一个长为 a[2]a[2]a[2] 的特殊子串。
            //  这三种情况取最大值，即 max(a[0]−2,min(a[0]−1,a[1]),a[2])
            int res = -1;
            for (List<Integer> cnts : map) {
                Collections.sort(cnts, Collections.reverseOrder());
                if (!cnts.isEmpty()) {
                    res = Math.max(res, cnts.get(0) - 2);
                }
                if (cnts.size() >= 2) {
                    res = Math.max(res, Math.min(cnts.get(0) - 1, cnts.get(1)));
                }
                if (cnts.size() >= 3) {
                    res = Math.max(res, cnts.get(2));
                }
            }
            return res > 0 ? res : -1;
        }
    }

}
