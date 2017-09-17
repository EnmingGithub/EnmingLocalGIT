
import java.io.*;
import java.util.*;

public class bigger {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0;i<n;i++){
            String line = in.next();
            char[] letters = new char[line.length()];
            int index = line.length() - 1;
            while(index != 0 && Character.getNumericValue(line.charAt(index))<= Character.getNumericValue(line.charAt(index-1))){
                index--;
            }
            if (index!= 0){
                int j = 0;
/*                for(int k=index-1;k<line.length();k++){
                    
                    letters[j] = line.charAt(k);
                    j++;
                }*/
                System.out.print(line.substring(0, index-1));
                int tar = index-1;
                index = line.length()-1;
                while(index != tar && Character.getNumericValue(line.charAt(index)) <= Character.getNumericValue(line.charAt(tar))){
                    index--;
                }
                if (index != tar){
                	System.out.print(line.charAt(index));
                	int num = line.length()-1;
                	while (num > tar){
                		if (num != index){
                		System.out.print(line.charAt(num));
                		}else{
                			System.out.print(line.charAt(tar));
                		}
                		num--;
                	}
/*                    char swap = letters[index];
                    letters[index] = letters[tar];
                    letters[tar] = swap;
                    tar++;
                    index = line.length()-1;
                    while(tar<index){
                        swap = letters[index];
                        letters[index] = letters[tar];
                        letters[tar] = swap;
                        tar++;
                        index--;
                    }*/
                }
/*                for(int k=tar;k<line.length();k++){
                    System.out.print(letters[k]);
                }*/
                System.out.println();
            }else{
                System.out.println("no answer");
            }
        }
    }
}