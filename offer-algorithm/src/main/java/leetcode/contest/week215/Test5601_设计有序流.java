package leetcode.contest.week215;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test5601_设计有序流 {

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // 插入 (3, "ccccc")，返回 []
        System.out.println(os.insert(1, "aaaaa")); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee")); // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(4, "ddddd")); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }

    static class OrderedStream {
        int n;
        int ptr;
        Map<Integer, String> map = new TreeMap<>();

        public OrderedStream(int n) {
            this.n = n;
            this.ptr = 1;
        }

        public List<String> insert(int id, String value) {
            map.put(id, value);
            List<String> res = new ArrayList<>();
            if (id == ptr) {
                for (int i = ptr; i <= n; i++) {
                    if (map.containsKey(i)) {
                        res.add(map.get(i));
                        ptr++;
                    } else {
                        break;
                    }
                }
            }
            return res;
        }
    }

}
