import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class pindex {

    static int palindromeIndex(String s){
        // Complete this function
        int front = 0;
        int end = s.length()-1;
        String mk = s.substring(front,end+1);
        while(front < end){
            if (s.charAt(front) == s.charAt(end)){
                front ++ ;
                end --;
            }else if(s.charAt(front+1)== s.charAt(end) && palindromeIndex(s.substring(front+1, end+1))== -1){
                return front;

            }else if(s.charAt(front) == s.charAt(end -1) && palindromeIndex(s.substring(front, end ))== -1){
                return end;

            }else{
                return -2;
            }
            }
                return -1;
        }

    
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            if (result == -2){
               System.out.println(-1);
            }else{
               System.out.println(result);
            }

        }
    }
}
