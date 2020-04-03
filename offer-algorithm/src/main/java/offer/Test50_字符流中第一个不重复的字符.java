package offer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test50_字符流中第一个不重复的字符 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (char ch : "google".toCharArray()) {
            solution.Insert(ch);
            System.out.print(solution.FirstAppearingOnce());
        }
    }

    static class Solution {
        Set<Character> firstShownChar = new LinkedHashSet<>();
        Set<Character> multiShownChar = new LinkedHashSet<>();

        public void Insert(char ch) {
            if (multiShownChar.contains(ch)) {
                // 出现过多次，不参与计算
                return;
            }
            if (firstShownChar.contains(ch)) {
                // 已经出现过一次，则移到出现多次的set中
                firstShownChar.remove(ch);
                multiShownChar.add(ch);
            } else {
                // 未出现过则记录
                firstShownChar.add(ch);
            }
        }

        public char FirstAppearingOnce() {
            return firstShownChar.stream().findFirst().orElse('#');
        }
    }

}
