package yelpphone;
import java.util.*;
public class groupanagra {
	public static void main (String[] args){
		String[] in = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(in);
	}
	
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> mp = new HashMap<>();

        for(String s :strs){
            char[] key = new char[26];
            for(char c : s.toCharArray()){
                key[c-'a']++;
            }
            String str = new String(key);
            mp.putIfAbsent(str,new ArrayList<String>());
            mp.get(str).add(s);
            
        }
        res.addAll(mp.values());
        return res;
    }
}
