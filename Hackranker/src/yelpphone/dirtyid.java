package yelpphone;
import java.util.*;
public class dirtyid {
    public static void main (String[] args){
    	List<String> res = new ArrayList<>();
    	Set<Integer> numidx = new HashSet<Integer>();
    	String in= "E24BU5VMHV";
    	dfs(in,res,0,numidx);
    }
    public static void dfs (String in,List<String> res,int idx,Set<Integer> numidx){
    	if (idx == in.length()){
    		System.out.println(Arrays.toString(res.toArray(new String[res.size()])));
    	    return;
    	}
    	for (int i = idx;i<in.length();i++){
    		if (in.charAt(i) >= 'A' && in.charAt(i)<='Z'){
    			res.add(in.substring(i, i+1));
    			dfs(in,res,i+1,numidx);
    			res.remove(res.size()-1);
    			res.add(in.substring(i, i+1).toLowerCase());
    			dfs(in,res,i+1,numidx);
    			res.remove(res.size()-1);
    			while(numidx.contains(res.size()-1)){
    				numidx.remove(res.size()-1);
    				res.remove(res.size()-1);

    			}
    			break;
    		}else{
    			res.add(in.substring(i,i+1));
    			numidx.add(i);
    			continue;
    		}
    	}
    }
}
