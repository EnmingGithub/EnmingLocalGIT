
public class listnode {


 public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

 public static void main(String[] args){
	 ListNode head = new ListNode(1);
	 head.next = new ListNode(2);
	 head.next.next=new ListNode(3);
	 head.next.next.next=new ListNode(4);
	 head.next.next.next.next=new ListNode(5);
	 System.out.println(reverseList(head));
 }

	    public static ListNode reverseList(ListNode head) {
	        
	        if (head == null){
	            return null;
	        }
	        ListNode pre = null;
	        while(head != null){
	            ListNode tem = head.next;
	            head.next = pre;
	            pre = head;
	            head = tem;
	        }
	        return pre;
	        
	        
	        
	    }

}
