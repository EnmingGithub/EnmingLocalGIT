import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Sherlock {

    static String isValid(String s){
        // Complete this function
        Map<Character,Integer> map =new HashMap<Character,Integer>();
        for (int i = 0;i<s.length();i++){
            if (map.containsKey(s.charAt(i)) == false){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Character a = ' ';
        Map<Integer,Integer> numlist = new HashMap<Integer,Integer>();

        for (Integer value:map.values()){
            if (numlist.containsKey(value) == false){
                numlist.put(value,1);
                numbers.add(value);
            }else{
                numlist.put(value,numlist.get(value)+1);
            }
        }
        if (numlist.size() == 1){
            return "YES";
        }else if (numlist.size() >2){
            return "NO";
        }else{
            if (Math.abs(numbers.get(0) - numbers.get(1))>1){
                if ((numbers.get(0) == 1 && numlist.get(numbers.get(0)) == 1) ||(numbers.get(1) == 1 && numlist.get(numbers.get(1)) == 1)){
                return "YES";
                }else{
                return "NO";
                }


            }else{
                if (numlist.get(numbers.get(0)) * numlist.get(numbers.get(1)) == numlist.get(numbers.get(0)) || numlist.get(numbers.get(0)) * numlist.get(numbers.get(1)) == numlist.get(numbers.get(1))){
                    return "YES";
                }else {
                    return "NO";
                }
            }
        }
        
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
