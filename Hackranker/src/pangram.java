import java.util.Scanner;

public class pangram {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] alf = new int[26];
        for (int i = 0;i<s.length();i++){
            int curr = (int)s.charAt(i);
            int index = 0;
            if (curr >=65 && curr <= 90){
                index = 65;
            }else if(curr >=97 && curr <= 122) {
                index = 97;
            }
            if (s.charAt(i) != ' '){
                alf[curr - index] = 1;
            }
        }
        int max = 0;
        for (int i:alf){
            max = max + i;
        }
        if (max == 26){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }
}

