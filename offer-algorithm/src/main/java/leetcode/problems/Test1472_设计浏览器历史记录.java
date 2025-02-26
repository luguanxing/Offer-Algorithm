package leetcode.problems;

import java.util.*;

public class Test1472_设计浏览器历史记录 {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"

    }

    static class BrowserHistory {
        List<String> history;
        int index;

        public BrowserHistory(String homepage) {
            history = new ArrayList<>();
            history.add(homepage);
            index = 0;
        }

        public void visit(String url) {
            while (history.size() > index + 1) {
                history.remove(history.size() - 1);
            }
            history.add(url);
            index++;
        }

        public String back(int steps) {
            index = Math.max(index - steps, 0);
            return history.get(index);
        }

        public String forward(int steps) {
            index = Math.min(index + steps, history.size() - 1);
            return history.get(index);
        }
    }


}
