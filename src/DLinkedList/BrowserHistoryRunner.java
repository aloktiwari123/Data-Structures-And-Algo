package DLinkedList;

public class BrowserHistoryRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com");
		browserHistory.visit("facebook.com");
		browserHistory.visit("youtube.com");
		System.out.println(browserHistory.back(1));
		System.out.println(browserHistory.back(1));
		System.out.println(browserHistory.back(1));
		System.out.println(browserHistory.forward(1));
		System.out.println(browserHistory.forward(4));
		
		
	}

}
