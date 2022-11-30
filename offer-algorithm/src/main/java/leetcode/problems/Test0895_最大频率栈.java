package leetcode.problems;

import java.util.*;

public class Test0895_最大频率栈 {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);//堆栈为 [5]
        freqStack.push(7);//堆栈是 [5,7]
        freqStack.push(5);//堆栈是 [5,7,5]
        freqStack.push(7);//堆栈是 [5,7,5,7]
        freqStack.push(4);//堆栈是 [5,7,5,7,4]
        freqStack.push(5);//堆栈是 [5,7,5,7,4,5]
        freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        freqStack.pop();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        freqStack.pop();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成
    }

    static class FreqStack {
        // 每个数出现的次数
        HashMap<Integer, Integer> numCntMap;
        // 出现某个次数的所有数
        HashMap<Integer, List<Integer>> cntNumsMap;
        // 当前最大频率
        int maxCnt;

        public FreqStack() {
            numCntMap = new HashMap<>();
            cntNumsMap = new HashMap<>();
            maxCnt = 0;
        }

        public void push(int val) {
            int oldCnt = numCntMap.getOrDefault(val, 0);
            int newCnt = oldCnt + 1;
            // 更新numCntMap
            numCntMap.put(val, newCnt);
            // 更新cntNumsMap，注意不用维护cntNumsMap.get(oldCnt)里面的，因为后面不影响pop
            List<Integer> list = cntNumsMap.getOrDefault(newCnt, new ArrayList<>());
            list.add(val);
            cntNumsMap.put(newCnt, list);
            // 更新maxCnt
            maxCnt = Math.max(maxCnt, newCnt);
        }

        public int pop() {
            List<Integer> maxCntNums = cntNumsMap.get(maxCnt);
            int res = maxCntNums.get(maxCntNums.size() - 1);
            // 更新numCntMap
            numCntMap.put(res, maxCnt - 1);
            // 更新cntNumsMap
            cntNumsMap.get(maxCnt).remove(maxCntNums.size() - 1);
            cntNumsMap.get(maxCnt - 1);
            // 更新maxCnt
            if (maxCntNums.isEmpty()) {
                maxCnt--;
            }
            return res;
        }
    }


}
