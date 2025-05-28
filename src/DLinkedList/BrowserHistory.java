package DLinkedList;

public class BrowserHistory {

	ListNode current=null;
    public BrowserHistory(String homepage) {
       ListNode head=new ListNode(null,null, homepage);
       current=head;
       
    }
    
    public void visit(String url) {
    	ListNode temp=new ListNode(null, null, url);
    	current.next=temp;
    	temp.prev=current;
    	current=temp;
    }
    
    public String back(int steps) {
		while(current.prev!=null && steps>0) {
			current=current.prev;
			steps--;
		}
		return current.value;
    }
    
    public String forward(int steps) {
    	while(current.next!=null && steps>0) {
			current=current.next;
			steps--;
		}
		return current.value;
        
    }

}
