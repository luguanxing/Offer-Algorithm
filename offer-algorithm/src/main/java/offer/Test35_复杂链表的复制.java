package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test35_复杂链表的复制 {

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node3.random = node2;
        System.out.println(node1.nexts());
        System.out.println(node1.randoms());
        System.out.println(new Solution().Clone(node1).nexts());
        System.out.println(new Solution().Clone(node1).randoms());
    }

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        public String nexts() {
            return label + "->" + (next != null ? next.nexts() : "");
        }

        public String randoms() {
            return label + "->" + (random != null ? random.randoms() : "");
        }
    }

    static class Solution {
        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null) {
                return null;
            }
            // 保存所有节点及其对应序号关系
            Map<RandomListNode, Integer> nodesIndexMap = new HashMap<>();
            List<RandomListNode> oldNodesList = new ArrayList<>();
            List<RandomListNode> newNodesList = new ArrayList<>();
            RandomListNode current = pHead;
            int index = 0;
            while (current != null) {
                nodesIndexMap.put(current, index++);
                oldNodesList.add(current);
                newNodesList.add(new RandomListNode(current.label));
                current = current.next;
            }
            // 根据对应关系构建新链表
            for (int i = 0; i < newNodesList.size() - 1; i++) {
                newNodesList.get(i).next = newNodesList.get(i + 1);
            }
            for (int i = 0; i < newNodesList.size(); i++) {
                Integer randomIndex = nodesIndexMap.get(oldNodesList.get(i).random);
                if (randomIndex != null) {
                    newNodesList.get(i).random = newNodesList.get(randomIndex);
                }
            }
            return newNodesList.get(0);
        }
    }

}
