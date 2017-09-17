import java.util.Scanner;

public class mars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        char[] sos = new char[]{'S','O','S'};
        int num = 0;
        for(int i =0;i<S.length();i++){
            if (sos[i%3] != S.charAt(i)){
                num++;
            }
        }
        System.out.println(num);
    }
}


