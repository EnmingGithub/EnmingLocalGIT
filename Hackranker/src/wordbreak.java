import java.util.Arrays;
import java.util.*;

public class wordbreak {
   public static void main(String[] args){
	   List<String> input =  Arrays.asList("leetddddd","code","codefb");
	   String s = "leetdddddcodefb";
	   System.out.println(wordBreak(s,input));
   }

	    public static boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> set = new HashSet<String>();
	        boolean[] dp = new boolean[s.length()+1];
	        int maxlen = 0;
	        for(int i = 0;i<wordDict.size();i++){
	            maxlen = Math.max(maxlen,wordDict.get(i).length());
	            set.add(wordDict.get(i));
	        }
	        dp[0] = true;
	        for (int i = 1;i<=s.length();i++){
	          for (int k = (i - maxlen > 0)? i-maxlen:0;k<i;k++){
	              if (dp[k] && set.contains(s.substring(k,i))){
	                  dp[i] = true;
	                  break;
	              }
	          }   
	        }
	        return dp[s.length()];
	    }

}
