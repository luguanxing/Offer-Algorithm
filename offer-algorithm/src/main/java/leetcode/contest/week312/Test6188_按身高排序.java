package leetcode.contest.week312;

import java.util.Arrays;

public class Test6188_按身高排序 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortPeople(
                new String[]{"Mary", "John", "Emma"},
                new int[]{180, 165, 170}
        )));
        System.out.println(Arrays.toString(new Solution().sortPeople(
                new String[]{"Alice", "Bob", "Bob"},
                new int[]{155, 185, 150}
        )));
    }

    static class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            int len = names.length;
            People[] peoples = new People[len];
            for (int i = 0; i < len; i++) {
                peoples[i] = new People(names[i], heights[i]);
            }
            Arrays.sort(peoples, (p1, p2) -> Integer.compare(p2.height, p1.height));
            String[] res = new String[len];
            for (int i = 0; i < len; i++) {
                res[i] = peoples[i].name;
            }
            return res;
        }

        class People {
            String name;
            int height;

            public People(String name, int height) {
                this.name = name;
                this.height = height;
            }
        }
    }

}
