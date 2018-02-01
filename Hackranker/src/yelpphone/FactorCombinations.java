package yelpphone;
import java.util.*;
public class FactorCombinations {

	    public List<List<Integer>> getFactors(int n) {
	        List<List<Integer>> res = new ArrayList<>();
	        helper(res,new ArrayList<>(),n,2);
	        return res;
	    }
	    public void helper(List<List<Integer>> res,List<Integer> output,int n,int start){
	        if (n<= 1){
	            return;
	        }
	        for(int i = start;i<=Math.sqrt(n);i++){
	            if (n%i != 0){
	                continue;
	            }
	            output.add(i);
	            output.add(n/i);
	            res.add(new ArrayList<>(output));
	            output.remove(output.size()-1);
	            helper(res,output,n/i,i);
	            output.remove(output.size()-1);
	        }
	    }
	
}
