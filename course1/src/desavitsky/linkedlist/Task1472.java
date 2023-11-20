package desavitsky.linkedlist;

// Design Browser History
public class Task1472 {
    public static void main(String[] args) {
        //Input:
        //["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        //[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
        //Output:
        //[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

        var bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));
        bh.visit("linkedin.com");
        System.out.println(bh.forward(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(7));
    }
}

class BrowserHistory {

    private BrowserPage current;

    public BrowserHistory(String homepage) {
        current = new BrowserPage(homepage);
    }

    public void visit(String url) {
        current = new BrowserPage(url, current);
        current.back.forward = current;
    }

    public String back(int steps) {
        var completed = 0;
        var currentPage = current;
        while (completed < steps && currentPage.back != null) {
            currentPage = currentPage.back;
            completed++;
        }
        current = currentPage;
        return current.url;
    }

    public String forward(int steps) {
        var completed = 0;
        var currentPage = current;
        while (completed < steps && currentPage.forward != null) {
            currentPage = currentPage.forward;
            completed++;
        }
        current = currentPage;
        return current.url;
    }
}

class BrowserPage{
    BrowserPage back;
    String url;
    BrowserPage forward;
    public BrowserPage(String url){
        this.url = url;
        back = forward = null;
    }
    public BrowserPage(String url, BrowserPage back) {
        this.url = url;
        this.back = back;
    }
}