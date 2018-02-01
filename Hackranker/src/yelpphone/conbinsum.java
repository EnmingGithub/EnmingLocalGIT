package yelpphone;
import java.util.*;
public class conbinsum {
        public static void main(String[] args){
        	int[] i= new int[]{1};
        	int tar = 1;
        	System.out.println(combinationSum(i,tar));
        }
	    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(candidates);
	        
	        List<Integer> curr = new ArrayList<>();
	        helper(candidates,target,0,res,curr);
	        return res;
	    }
/*	    public static void helper (int[] nums, int tar,int index,List<List<Integer>> res, List<Integer> curr ){
	    	if (index >= nums.length||tar<0){
	        	
	            return;
	        }
	    	if (tar == 0){
	            res.add(new ArrayList<>(curr));

	            return;
	        }


	        
	        for (int i= index;i<nums.length;i++){
	        	if (tar<nums[i]){
	        		break;
	        	}
	        	curr.add(nums[i]);
	            helper(nums,tar-nums[i],i,res,curr);
	            curr.remove(curr.size()-1);
	            
	        }
	        return;
	    }*/
	    public static void helper(int[] nums,int tar,int idx,List<List<Integer>> res,List<Integer> curr){
	        if (tar == 0){
	            res.add(new ArrayList<>(curr));
	            return;
	        }
	    	if (idx>=nums.length|| tar<0){
	            return;
	        }

	        for(int i = idx;i<nums.length;i++){
	            if (nums[i]>tar){
	                break;
	            }
	            if (i>idx && nums[i] == nums[i-1]){
	                continue;
	            }
	            curr.add(nums[i]);
	            helper(nums,tar-nums[i],i+1,res,curr);
	            curr.remove(curr.size()-1);
	        }
	        return;
	    }

}
