package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0811_子域名访问计数 {

    public static void main(String[] args) {
        System.out.println(new Solution().subdomainVisits(new String[]{
                "9001 discuss.leetcode.com"
        }));
        System.out.println(new Solution().subdomainVisits(new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        }));
    }

    static class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            // 统计每个子域名
            Map<String, Integer> domainCntMap = new HashMap<>();
            for (String cpdomain : cpdomains) {
                Integer cnt = Integer.parseInt(cpdomain.split(" ")[0]);
                String[] domains = cpdomain.split(" ")[1].split("\\.");
                String domain = domains[domains.length - 1];
                domainCntMap.put(domain, domainCntMap.getOrDefault(domain, 0) + cnt);
                for (int i = domains.length - 2; i >= 0; i--) {
                    domain = domains[i] + "." + domain;
                    domainCntMap.put(domain, domainCntMap.getOrDefault(domain, 0) + cnt);
                }
            }
            // 返回结果
            List<String> res = new ArrayList<>();
            for (String domain : domainCntMap.keySet()) {
                int cnt = domainCntMap.get(domain);
                res.add(cnt + " " + domain);
            }
            return res;
        }
    }

}
