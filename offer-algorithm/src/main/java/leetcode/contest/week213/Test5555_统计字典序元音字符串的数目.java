package leetcode.contest.week213;

public class Test5555_统计字典序元音字符串的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countVowelStrings(1));
        System.out.println(new Solution().countVowelStrings(2));
        System.out.println(new Solution().countVowelStrings(33));
    }

    static class Solution {
        public int countVowelStrings(int n) {
            int[] a = new int[55];
            int[] e = new int[55];
            int[] i = new int[55];
            int[] o = new int[55];
            int[] u = new int[55];
            a[1] = 1;
            e[1] = 1;
            i[1] = 1;
            o[1] = 1;
            u[1] = 1;
            for (int index = 2; index <= 50; index++) {
                a[index] = a[index - 1] + e[index - 1] + i[index - 1] + o[index - 1] + u[index - 1];
                e[index] = e[index - 1] + i[index - 1] + o[index - 1] + u[index - 1];
                i[index] = i[index - 1] + o[index - 1] + u[index - 1];
                o[index] = o[index - 1] + u[index - 1];
                u[index] = u[index - 1];
            }
            return a[n] + e[n] + i[n] + o[n] + u[n];
        }
    }

}
