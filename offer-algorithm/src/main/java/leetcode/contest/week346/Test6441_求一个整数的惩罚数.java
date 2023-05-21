package leetcode.contest.week346;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test6441_求一个整数的惩罚数 {

    public static void main(String[] args) {
        System.out.println(new Solution().punishmentNumber(10));
        System.out.println(new Solution().punishmentNumber(37));
    }

    static class Solution {
        public int punishmentNumber(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (digitSum(i * i).contains(i)) {
                    sum += i * i;
                }
            }
            return sum;
        }

        private Set<Integer> digitSum(Integer num) {
            Set<Integer> set = new HashSet<>();
            dfs(num.toString(), new ArrayList<>(), set);
            return set;
        }

        private void dfs(String currentStr, List<Integer> list, Set<Integer> set) {
            if (currentStr.isEmpty()) {
                set.add(list.stream().reduce(Integer::sum).get());
                return;
            }
            for (int i = 1; i <= currentStr.length(); i++) {
                String prefix = currentStr.substring(0, i);
                String remain = currentStr.substring(i);
                // 拿prefix
                list.add(Integer.parseInt(prefix));
                dfs(remain, list, set);
                list.remove(list.size() - 1);
            }
        }
    }

}
