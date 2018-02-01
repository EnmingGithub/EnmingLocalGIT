package Yelp;
import java.util.*;

class BusinessInfo {
    int id;
    int rating;

    public BusinessInfo(int id, int rating){
        this.id = id;
        this.rating = rating;
    }

}
public class binfo {

  public static void main(String[] args){
        List<BusinessInfo> list = new ArrayList<>();
        BusinessInfo a = new BusinessInfo(101,3);
        list.add(new BusinessInfo(101,5));
        list.add(new BusinessInfo(102,2));
        list.add(new BusinessInfo(103,3));
        list.add(new BusinessInfo(104,5));
        list.add(new BusinessInfo(105,4));
        List<BusinessInfo> res = sRating(list);
        for(int i = 0;i<res.size();i++){
        	System.out.println(res.get(i).id+"  "+res.get(i).rating);
        }
        
  }
  public static List<BusinessInfo> sRating(List<BusinessInfo> businesses){
	  PriorityQueue<BusinessInfo> pq = new PriorityQueue<BusinessInfo>(
			  new Comparator<BusinessInfo>(){
				 public int compare (BusinessInfo b1,BusinessInfo b2){
					 return b2.rating - b1.rating;
				 }
			  });
	  for (int i = 0;i<businesses.size();i++){
		  pq.add(businesses.get(i));
	  }
	  List<BusinessInfo> res = new ArrayList<>();
	  while (!pq.isEmpty()){
		  res.add(pq.poll());
	  }
	  return res;
  }
}
