package leetcode.contest.week237;

public class Test5734_判断句子是否为全字母句 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(new Solution().checkIfPangram("leetcode"));
    }

    static class Solution {
        public boolean checkIfPangram(String sentence) {
            boolean[] flags = new boolean[26];
            for (char c : sentence.toCharArray()) {
                flags[c - 'a'] = true;
            }
            boolean res = true;
            for (boolean flag : flags) {
                res &= flag;
            }
            return res;
        }
    }

}
