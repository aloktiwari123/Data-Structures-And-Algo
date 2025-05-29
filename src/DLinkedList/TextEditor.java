package DLinkedList;

public class TextEditor {
	
	ListNode current = null;
	ListNode head = null;
	ListNode tail = null;
	int len;
	int totalLen;
	public TextEditor() {
        ListNode head=new ListNode(null, null,"<"); 
        ListNode tail=new ListNode(null, null,">"); 
        head.next=tail;
        tail.prev=head;
        current=head;
        len=0;
        totalLen=0;
    }
    
    public void addText(String text) {
    	ListNode end=current.next;
    	for(char ch:text.toCharArray()) {
    		ListNode temp = new ListNode(null,null,""+ch);
    		current.next=temp;
    		temp.prev=current;
    		current=temp;
    		len++;
    		totalLen++;
    	}
    	current.next=end;
    	end.prev=current;
    }
    
    public int deleteText(int k) {
    	int count=0;
    	ListNode end = current.next;
		while(k>0 && len>0) {
			current=current.prev;
			k--;
			len--;
			count++;
		}
		totalLen-=count;
		current.next=end;
		end.prev=current;
		return count;
    }
    
    public String cursorLeft(int k) {
		while(k>0 && len>0) {
			current=current.prev;
			k--;
			len--;
		}
		return fetchString();
    }
    
	public String cursorRight(int k) {
		while(k>0 && len<totalLen) {
			current=current.next;
			k--;
			len++;
		}
		return fetchString();
    }
	
    private String fetchString() {
    	String str="";
    	int count=0;
    	ListNode mover=current;
    	
    	while(count<Math.min(10,len)) {
    		str=mover.value+str;
			mover=mover.prev;
			count++;
    	}
    	return str;
	}

}
