package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test0929_独特的电子邮件地址 {

    public static void main(String[] args) {
        System.out.println(new Solution().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        System.out.println(new Solution().numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}));
    }

    static class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> set = new HashSet<>();
            for (String email : emails) {
                String[] emailStrs = email.split("@");
                String local = emailStrs[0];
                String domain = emailStrs[1];
                local = local.replaceAll("\\.", "");
                local = local.split("\\+")[0];
                domain = domain.split("\\+")[0];
                set.add(local + "@" + domain);
            }
            System.out.println(set);
            return set.size();
        }
    }

}
