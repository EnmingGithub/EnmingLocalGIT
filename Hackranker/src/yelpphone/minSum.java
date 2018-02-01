package yelpphone;
import java.util.*;
public class minSum {
	public static void main(String[] args){
		String[] in1 = {"A","B","C"};
		String[] in2 = {"G","C","A"};
		System.out.println(Arrays.toString(findRestaurant(in1,in2)));
//		System.out.println(in1);
	}
    public static String[] findRestaurant(String[] list1, String[] list2) {
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
     }
}
