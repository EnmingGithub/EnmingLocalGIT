package Yelp;

public class compressPnum {
    public static void main(String[] args){
    	String a = "aaaaabbbccd";
    	char temp = a.charAt(0);
    	int num = 1;
    	StringBuilder res = new StringBuilder();
        for (int i = 1;i<a.length();i++){
      	  if (a.charAt(i) == temp){
      		  num++;
      	  }else{
      		  res.append(num);
      		  res.append(temp);
      		  num = 1;
      		  temp = a.charAt(i);
      	  }
        }
		  res.append(num);
		  res.append(temp);
		System.out.println(res);
    }

}
