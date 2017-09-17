import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class twochar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        int max = 0;
        Set<Character> lib = new HashSet<Character>();
        for (int n=0;n<len;n++){
        	if (n == 0){
        		lib.add(s.charAt(0));
        	}else if (n>0 && s.charAt(n) != s.charAt(n-1) && lib.contains(s.charAt(n)) == false){
                lib.add(s.charAt(n));
            }
        }
        char buff = ' ';

        int currlen = 0;
        Set<Character> lib2 = new HashSet<Character>();
        for (char l: lib){
        	if (lib2.contains(l)){
        		continue;
        	}
        	for (char k: lib){
            	if (lib2.contains(k)){
            		continue;
            	}
        		currlen = 0;
        		if (l == k){
        			continue;
        		}
        		int mark = 0;
        		for (int j=0;j<s.length();j++){
        			if (s.charAt(j) == l || s.charAt(j) == k){
        				if (s.charAt(j) == buff){
        					break;
        				}else {
        					buff = s.charAt(j);
        					currlen++;
        				}
        			}
        			if (j == s.length()-1){
        				mark = 1;
        			}
        		}
        		if (mark ==1){
            		max = Math.max(max, currlen);
        		}

        	}
        	lib2.add(l);
        }

        
        System.out.println(max);
    }
}