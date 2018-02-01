package yelpphone;
import java.util.*;
public class RandomizedCollection{


	    
	    /** Initialize your data structure here. */
	    public static void main(String[] args) {
		    List<Integer> l = null;
		    Map<Integer,List<Integer>> keymp = null;
	        keymp = new HashMap<Integer,List<Integer>>();
	        l = new ArrayList<Integer>();
	    }
	    
	    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	    public boolean insert(int val) {
	        l.add(val);
	        if (!keymp.containsKey(val)){
	            
	            keymp.put(val,new ArrayList<Integer>());
	            keymp.get(val).add(l.size()-1);

	            return true;
	        }else{

	            keymp.get(val).add(l.size()-1);

	            return false;
	        }
	    }
	    
	    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	    public boolean remove(int val) {
	        if (keymp.containsKey(val)){
	            int idx = keymp.get(val).size()-1;
	            int keyidx = keymp.get(val).get(idx);
	            int lastidx = l.size()-1;
	            if (keyidx != lastidx){
	               l.set(keyidx,l.get(lastidx));

	               keymp.get(l.get(lastidx)).set(keymp.get(l.get(lastidx)).size()-1,keyidx);
	            }
	            l.remove(lastidx);

	            keymp.get(val).remove(idx);
	            if (idx == 0){
	                keymp.remove(val);
	            }

	            return true;
	        }else{
	            return false;
	        }
	    }
	    
	    /** Get a random element from the collection. */
	    public int getRandom() {
	        Random r = new Random();
	        return l.get(r.nextInt(l.size()));
	    }
	
}
