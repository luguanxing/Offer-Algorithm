package leetcode.problems;

import java.util.*;

public class Test0721_账户合并 {

    public static void main(String[] args) {
        // accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
        System.out.println(new Solution().accountsMerge(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        )));
        // [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]
        System.out.println(new Solution().accountsMerge(Arrays.asList(
                Arrays.asList("David","David0@m.co","David1@m.co"),
                Arrays.asList("David","David3@m.co","David4@m.co"),
                Arrays.asList("David","David4@m.co","David5@m.co"),
                Arrays.asList("David","David2@m.co","David3@m.co"),
                Arrays.asList("David","David1@m.co","David2@m.co")
        )));
    }

    static class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // 存储KEY=名字+序号，VALUE=邮件集合
            Map<String, Set<String>> idEmails = new HashMap<>();
            int len = accounts.size();
            mainLoop:
            for (int i = 0; i < len; i++) {
                // 对当前每一个进行检查
                String currentName = accounts.get(i).get(0);
                List<String> currentAccounts = accounts.get(i).subList(1, accounts.get(i).size());
                boolean isMerge = false;
                for (String currentAccount : currentAccounts) {
                    // 判断是否已存在，存在则合并
                    for (String k : idEmails.keySet()) {
                        Set<String> emails = idEmails.get(k);
                        if (emails.contains(currentAccount)) {
                            emails.addAll(currentAccounts);
                            isMerge = true;
                            continue mainLoop;
                        }
                    }
                }
                if (!isMerge) {
                    idEmails.put(i + "-" + currentName, new TreeSet<>(currentAccounts));
                }
            }
            // 返回结果
            List<List<String>> res = new ArrayList<>();
            for (String k : idEmails.keySet()) {
                String name = k.split("-")[1];
                Set<String> emails = idEmails.get(k);
                List<String> list = new ArrayList<>();
                list.add(name);
                list.addAll(emails);
                res.add(list);
            }
            return res;
        }
    }

}
