import java.util.Scanner;

public class cipher {
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	int num = in.nextInt();
    	String s = in.next();
    	int move = in.nextInt();
    	for (int i = 0;i<num;i++){
    		int ac = (int)s.charAt(i);
            int buff = 0;
    			if (ac >=65 && ac <= 90){
    				if (ac+move <=90){
    					System.out.print((char)(ac+move));
    				}else{
                        buff = (move-90+ac)%26;
                        if (buff == 0){
                            System.out.print('Z');
                        }else{
                            System.out.print((char)(64+buff));
                        }

    				}
    			}else if (ac >=97 && ac <= 122){
    				if (ac+move <=122){
    					System.out.print((char)(ac+move));
    				}else{
                        buff = (move-122+ac)%26;
                        if (buff ==0){
                            System.out.print('z');
                        }else{
                            System.out.print((char)(96+buff));
                        }

    				}
    			}else{
                    System.out.print(s.charAt(i));
                }	
    	}
    }
}
