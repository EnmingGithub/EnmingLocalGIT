package Amazon;
import java.util.*;
public class deque {
    public static void main(String[] args){
    	int[] in = {1,3,1,2,0,5};
    	System.out.println(maxSlidingWindow(in,3));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length - k +1];
        Queue<Integer> q = new LinkedList<Integer>();
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i = 0;i<nums.length;i++){
            if (q.size() < k){
                q.offer(nums[i]);
                adddq(dq,nums[i]);
            }else{

                removedq(dq,q.poll());
                q.offer(nums[i]);
                adddq(dq,nums[i]);
            }
            if (i>=k-1){
                res[i-k+1] = dq.peekFirst();
            }
        }
        return res;
    }
    public static void adddq(Deque<Integer> dq, int next){
        while(dq.size() != 0 && dq.peekLast()<next){
            dq.removeLast();
        }
        dq.offerLast(next);
    }
    public static void removedq(Deque<Integer> dq,int rm){
        if (dq.peekFirst() == rm){
            dq.removeFirst();
        }
    }
}
