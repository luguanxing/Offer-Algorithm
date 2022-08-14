package leetcode.contest.week306;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test6150_根据模式串构造最小数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber("IIIDIDDD"));
        System.out.println(new Solution().smallestNumber("DDD"));
        System.out.println(new Solution().smallestNumber("DDDIII"));
    }

    static class Solution {
        String res = "";

        public String smallestNumber(String pattern) {
            for (int start = 1; start <= 9; start++) {
                List<Integer> currentList = new ArrayList<>();
                currentList.add(start);
                dfs(currentList, 0, pattern);
            }
            return res;
        }

        private void dfs(List<Integer> currentList, int index, String pattern) {
            if (!res.equals("")) {
                return;
            }
            if (index == pattern.length()) {
                res = String.join("", currentList.stream().map(Object::toString).collect(Collectors.toList()));
                return;
            }
            int current = currentList.get(currentList.size() - 1);
            if (pattern.charAt(index) == 'I') {
                for (int i = current + 1; i <= 9; i++) {
                    if (!currentList.contains(i)) {
                        currentList.add(i);
                        dfs(currentList, index + 1, pattern);
                        currentList.remove(currentList.size() - 1);
                    }
                }
            } else {
                for (int i = current - 1; i >= 1; i--) {
                    if (!currentList.contains(i)) {
                        currentList.add(i);
                        dfs(currentList, index + 1, pattern);
                        currentList.remove(currentList.size() - 1);
                    }
                }
            }
        }
    }

}
