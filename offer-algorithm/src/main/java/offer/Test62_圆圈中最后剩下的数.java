package offer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test62_圆圈中最后剩下的数 {

    public static void main(String[] args) {
        System.out.println(new Solution().LastRemaining_Solution(5, 3));
    }

    static class Solution {
        public int LastRemaining_Solution(int n, int m) {
            if (n <= 0) {
                return -1;
            }
            // 模拟圆环中所有数
            List<Integer> list = Stream
                    .iterate(0, i -> i + 1)
                    .limit(n)
                    .collect(Collectors.toList());
            // 标记当前所报的数字和再数组中的序号
            int current = 0;
            int index = 0;
            while (list.size() > 1) {
                if (current == m - 1) {
                    // 报数到m-1移除该数重新报数
                    list.remove(index);
                    current = 0;
                }
                current = (current + 1) % m;
                index = (index + 1) % list.size();
            }
            return list.get(0);
        }
    }

}
