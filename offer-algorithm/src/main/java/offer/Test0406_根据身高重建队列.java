package offer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test0406_根据身高重建队列 {

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = new Solution().reconstructQueue(people);
        for (int[] hk : res) {
            int h = hk[0];
            int k = hk[1];
            System.out.println(h + "-" + k);
        }
    }

    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            int num = people.length;
            int[][] res = new int[num][2];
            List<Integer> list = Stream
                    .iterate(0, i -> i + 1)
                    .limit(num)
                    .collect(Collectors.toList());
            // 对people按h升序，k降序排列
            for (int i = 0; i < num; i++) {
                for (int j = i + 1; j < num; j++) {
                    if (people[i][0] > people[j][0] || (people[i][0] == people[j][0] && people[i][1] < people[j][1])) {
                        int tmpH = people[i][0];
                        int tmpK = people[i][1];
                        people[i][0] = people[j][0];
                        people[i][1] = people[j][1];
                        people[j][0] = tmpH;
                        people[j][1] = tmpK;
                    }
                }
            }
            // 去掉list里对应的k，保证前面小的不存在，第k大就在list的第k位
            for (int[] hk : people) {
                int h = hk[0];
                int k = hk[1];
                int index = list.get(k);
                res[index][0] = h;
                res[index][1] = k;
                list.remove(k);
            }
            return res;
        }
    }

}
