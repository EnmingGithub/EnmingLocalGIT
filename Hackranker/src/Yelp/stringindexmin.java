package Yelp;
import java.util.*;

public class stringindexmin {
   public static void main(String[] args){
	   List<String> list1 = new ArrayList<>(Arrays.asList("xyz", "abc"));
	   List<String> list2 = new ArrayList<>(Arrays.asList("xyz", "abc"));
	   Map<String,Integer> map = new HashMap<String,Integer>();
	   int min = Integer.MAX_VALUE;
	   String res = "";
	   for (int i = 0;i<list1.size();i++){
		   map.put(list1.get(i), i);
	   }
	   for (int i = 0;i<list2.size();i++){
		   int indexsum = i + map.get(list2.get(i));
		   if (indexsum < min){
			   min = indexsum;
			   res = list2.get(i);
		   }
	   }
	   System.out.println(res);
	   
   }
}
/*

public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String,Integer> map = new HashMap<>();
     int min = Integer.MAX_VALUE;
     List<String> res = new LinkedList<>();
     for(int i = 0 ;i< list1.length;i++)         map.put(list1[i],i);
     for(int i = 0;i<list2.length;i++){
         Integer j = map.get(list2[i]);
         if (j != null && i + j <= min){
             if (i + j < min) {
                 res.clear();
                 min = i+j;
             }
             res.add(list2[i]);
         }
     }
     return res.toArray(new String[res.size()]);
 }*/