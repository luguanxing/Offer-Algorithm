package leetcode.contest.week276;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5980_将字符串拆分为若干长度为k的组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().divideString("abcdefghi", 3, 'x')));
        System.out.println(Arrays.toString(new Solution().divideString("abcdefghij", 3, 'x')));
        System.out.println(Arrays.toString(new Solution().divideString("ctoyjrwtngqwt", 8, 'n')));
    }

    static class Solution {
        public String[] divideString(String s, int k, char fill) {
            List<String> list = new ArrayList<>();
            String str = "";
            for (char c : s.toCharArray()) {
                str += c;
                if (str.length() % k == 0) {
                    list.add(str);
                    str = "";
                }
            }
            if (!str.isEmpty()) {
                while (str.length() < k){
                    str += fill;
                }
                list.add(str);
            }
            String[] res = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

}
