package yelpphone;
import java.util.*;
public class wordpattern {
    public static void main(String[] args){
    	String in1 = "abba";
    	String in2 = "cat dog dog fish";
    	System.out.println(wordPattern(in1,in2));
    }
    public static boolean wordPattern(String pattern, String str) {
        Map<String,Character> mp = new HashMap<>();
        int idx=0;

        for (int i = 0;i<pattern.length();i++){
            StringBuilder sb = new StringBuilder();
            while(idx<str.length() && str.charAt(idx) != ' '){
                sb.append(str.charAt(idx));
                idx++;
            }
            idx++;
            String s = sb.toString();
            if (mp.containsKey(s)){
                if (mp.get(s) == pattern.charAt(i)){
                    continue;
                }else{
                    return false;
                }
            }else{
                mp.put(s,pattern.charAt(i));
            }
        }
        return true;
    }
}
