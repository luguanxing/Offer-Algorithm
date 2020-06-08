package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test0990_等式方程的可满足性 {

    public static void main(String[] args) {
        System.out.println(new Solution().equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(new Solution().equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(new Solution().equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(new Solution().equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(new Solution().equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
        System.out.println(new Solution().equationsPossible(new String[]{"a!=a"}));
        System.out.println(new Solution().equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"}));
    }

    static class Solution {
        public boolean equationsPossible(String[] equations) {
            // 构建等式集合，区分输入的等式和不等式
            List<Set<String>> equationsSets = new ArrayList<>();
            List<String> equations1 = new ArrayList<>();
            List<String> equations2 = new ArrayList<>();
            for (String equation : equations) {
                if (equation.contains("==")) {
                    equations1.add(equation);
                } else {
                    equations2.add(equation);
                }
            }
            // 将等式放入集合中
            putEquations(equationsSets, equations1);
            // 注意等式不连续时可能要合并或者重复放一次
            putEquations(equationsSets, equations1);
            // 判断不等式是否冲突
            for (String equation : equations2) {
                String eq1 = equation.split("!=")[0];
                String eq2 = equation.split("!=")[1];
                if (eq1.equals(eq2)) {
                    return false;
                }
                for (Set<String> equationsSet : equationsSets) {
                    if (equationsSet.contains(eq1) && equationsSet.contains(eq2)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void putEquations(List<Set<String>> equationsSets, List<String> equations1) {
            for (String equation : equations1) {
                String eq1 = equation.split("==")[0];
                String eq2 = equation.split("==")[1];
                boolean isFound = false;
                for (Set<String> equationsSet : equationsSets) {
                    if (equationsSet.contains(eq1) || equationsSet.contains(eq2)) {
                        equationsSet.add(eq1);
                        equationsSet.add(eq2);
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    Set<String> equationsSet = new HashSet<>();
                    equationsSet.add(eq1);
                    equationsSet.add(eq2);
                    equationsSets.add(equationsSet);
                }
            }
        }
    }

}
