package leetcode.problems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1823_找出游戏的获胜者 {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheWinner(5, 2));
        System.out.println(new Solution().findTheWinner(6, 5));
    }

    static     class Solution {
        public int findTheWinner(int n, int k) {
            List<Integer> list = Stream
                    .iterate(1, i -> i + 1)
                    .limit(n)
                    .collect(Collectors.toList());
            // 不断的累积k个数后标记删除
            int leftCnt = n;
            int currentIndex = -1;
            int currentCnt = 0;
            while (leftCnt > 1) {
                currentIndex++;
                currentIndex %= n;
                if (list.get(currentIndex) != -1) {
                    currentCnt++;
                    if (currentCnt == k) {
                        currentCnt = 0;
                        list.set(currentIndex, -1);
                        leftCnt--;
                    }
                }
            }
            // 找到最后剩下的那个
            for (int index : list) {
                if (index != -1) {
                    return index;
                }
            }
            return -1;
        }
    }

}
