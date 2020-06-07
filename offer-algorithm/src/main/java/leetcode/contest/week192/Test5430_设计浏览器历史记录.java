package leetcode.contest.week192;

import java.util.ArrayList;
import java.util.List;

public class Test5430_设计浏览器历史记录 {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");                 // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");               // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");                // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(1));       // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));       // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));    // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");               // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));    // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));       // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));       // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }

    static class BrowserHistory {
        List<String> urls;
        int index;

        public BrowserHistory(String homepage) {
            // 初始化
            int index = 0;
            urls = new ArrayList<>();
            urls.add(homepage);
        }

        public void visit(String url) {
            // 访问某个url，有可能要覆盖
            if (index < urls.size()) {
                urls = urls.subList(0, index + 1);
            }
            index++;
            urls.add(url);
        }

        public String back(int steps) {
            // 回退steps步
            index = index - steps;
            if (index < 0) {
                index = 0;
            }
            return urls.get(index);
        }

        public String forward(int steps) {
            // 前进steps步
            index = index + steps;
            if (urls.size() <= index) {
                index = urls.size() - 1;
            }
            return urls.get(index);
        }
    }

}
