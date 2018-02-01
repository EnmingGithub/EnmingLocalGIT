import java.util.*;
public class liskpara {
	  public static class ListNode {
		      int val;
		      ListNode next;
		      public ListNode(int x) { val = x; }
		  }
	  public static void main (String[] args){
		  ListNode head = new ListNode(0);
		  ListNode mid = new ListNode(1);
		  ListNode last = new ListNode(1);
		  head.next = mid;
		  mid.next = last;
		  System.out.println(isPalindrome(head));
	  }
	 public static boolean isPalindrome(ListNode head) {
	        if (head == null){
	            return true;
	        }
	        Stack<Integer> t = new Stack<Integer>();
	        int sum = 0;
	        ListNode fir = head;
	        ListNode sec = head;
	       
	        while(fir != null && fir.next != null){

	            if (fir.next == null){
	                t.push(sec.val);
	                sum = 1;
	                break;
	            }else{
	            fir = fir.next.next;
	            t.push(sec.val);
	            sec = sec.next;
	            }

	        }
	        if (sum == 1){
	            t.pop();
	            sec = sec.next;
	        }
	        if (sum != 1 && fir != null && fir.next == null){
	        	sec = sec.next;
	        }
	        while(!t.empty() && sec != null){
	            if (t.peek() == sec.val){
	                t.pop();
	                sec = sec.next;
	            }else {
	                break;
	            }
	        }
	        if (!t.empty() || sec != null){
	            return false;
	        }else{
	            return true;
	        }
	    }
}
