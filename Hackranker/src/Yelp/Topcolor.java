package Yelp;
import java.util.*;
import java.util.Map.Entry;

public class Topcolor {
     public static void main(String[] args){
    	 String [][] colors = {{"r","g","blue"},
    			 {"r","g","blake"}};
    	 Map<String,Integer> map = new HashMap<>();
    	 int max = 0;
    	 for (int i = 0;i<colors.length;i++){
    		 for (int k = 0;k<colors[0].length;k++){
    			 if (map.containsKey(colors[i][k])){
    				 map.put(colors[i][k], map.get(colors[i][k])+1);
    				 max = Math.max(max,map.get(colors[i][k]));
    			 }else{
    				 map.put(colors[i][k], 1);
    			 }
    		 }
    	 }
    	 ArrayList<String> res = new ArrayList<String>();
    	 for (Entry<String, Integer> m:map.entrySet()){
    		 if (m.getValue() == max){
    			 res.add(m.getKey());
    		 }
    	 }
    	 Collections.sort(res);
    	 System.out.println(res); ;
    	 
     }

}
