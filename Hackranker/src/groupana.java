import java.util.*;
public class groupana {
   public static void main(String[] args){
	   String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
	   System.out.println(groupAnagrams(strs));
   }
	
	
	    public static List<List<String>> groupAnagrams(String[] strs) {
	        int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,43,47,51,59,61,67,73,79,83,87,89,91,97,101};
	        List<List<String>> result = new ArrayList<>();
	        Map<Integer,List<String>> map = new HashMap<>();
	        for (String n : strs){
	            int key = 1;
	            for (Character c:n.toCharArray()){
	                key *= prime[c-'a'];
	            }
	            if (map.containsKey(key)){
	                map.get(key).add(n);
	            }else{
	                List<String> l = new ArrayList<>();
	                l.add(n);
	                map.put(key,l);
	            }
	        }
	        for (List<String> row :map.values()){
	            result.add(row);
	        }
	        return result;
	    }

}
