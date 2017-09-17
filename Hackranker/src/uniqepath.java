import java.util.Scanner;

public class uniqepath {
    public static void main(String[] args){
    	Scanner in =new Scanner(System.in);
    	int m = in.nextInt();
    	int n = in.nextInt();
    	System.out.println(uniquePaths(m,n));
    }

        public static int uniquePaths(int m, int n) {
            int[][] matrix = new int[m+1][n+1];
            for (int i = 0;i <matrix[0].length;i++){
                matrix[0][i]=0;
            }
            for (int i = 0;i< matrix.length;i++){
                matrix[i][0] = 0;
            }

            for (int i = 1;i<matrix.length;i++){
                for(int j = 1;j<matrix[0].length;j++){
                    if (i == 1 && j == 1){
                        matrix[i][j] =1;
                    }else {
                        matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
                    }
                }
            }
            return matrix[m][n];
        }
    
}
