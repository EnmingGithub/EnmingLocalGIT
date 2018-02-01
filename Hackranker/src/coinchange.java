
public class coinchange {
   public static void main(String[] args){
	   int[] coins = {2};
	   int amount = 1;

	   System.out.println(bfshelper(coins,amount,(long)0,(long)Integer.MAX_VALUE+1,0));
   }
   class resultType {
	   int a;
	   String b;
   }
   
   public static int bfshelper(int[] coins, int amount, long curr, long min,int step){
       if (curr == (long)amount && (long)step < min){
           return step;
       }
       if (curr > (long)amount){
           return -1;
       }
       int result = 0;
       for (int i = 0;i<coins.length;i++){
           curr += (long)coins[i];
           result = Math.max(-1,bfshelper(coins,amount,curr,min,step+1)) ;
           if (result != -1){
              min = (long)Math.min(result,min);
           }

           curr -= (long)coins[i];
       }
       if ((long)min != -1 && min!= (long)Integer.MAX_VALUE+1){
           return (int) min;
       }else{
       return -1;
       }

   }
}
