
public class searchmatrix {
      public static void main(String[] args){
    	//  int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
    	  int[][] matrix ={{-1,3}};
          System.out.println(searchMatrix(matrix,1));
      }
	    public static boolean searchMatrix(int[][] matrix, int target) {
	        if (matrix == null || matrix.length == 0|| matrix[0].length == 0){
	            return false;
	        }
	        int lenx = matrix[0].length;
	        
	        int leny = matrix.length;
	        if (matrix[0][0] > target || matrix[leny-1][lenx-1] < target){
	            return false;
	        }
	        int start = 0;
	        int end = leny - 1;
	        int index = 0;
	        int mid = 0;
	        while (start + 1 < end ){
	            mid = start+(end - start)/2;
	            if (matrix[mid][0] == target){
	                return true;
	            }else if (matrix[mid][0] > target){
	                end = mid;
	            }else{
	                start = mid;
	            }
	        }
	        if (matrix[start][0] == target || matrix[end][0] == target){
	            return true;
	        }
	        if (matrix[end][0] < target){
	            index = end;
	        }else {
	            index = start;
	        }
	        start = 0;
	        end = lenx-1;
	        mid = 0;
	        while (start + 1 < end){
	            mid = start + (end - start)/2;
	            if (matrix[index][mid] == target){
	                return true;
	            }else if (matrix[index][mid] > target){
	                end = mid;
	            }else{
	                start = mid;
	            }
	        }
	        if (matrix[index][start] == target || matrix[index][end] == target){
	            return true;
	        }else {
	            return false;
	        }

	    }

}
