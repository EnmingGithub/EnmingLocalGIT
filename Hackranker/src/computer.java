import java.io.*;
import java.util.*;

public class computer {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int squr = Integer.MIN_VALUE;
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			String type = in.next();
			for (int j = 0; j < m; j++) {
				if (type.charAt(j) == 'G') {
					grid[i][j] = 1;
				} else {
					grid[i][j] = 0;
				}
			}
		}
		int[][] fst = new int[][] { { 0, 0, 0 }, { 0, 0, 0 } };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int index = i;
				int curr = 0;
				int max = Integer.MAX_VALUE;
				while (index >= 0 && grid[index][j] == 1) {
					curr++;
					index--;
				}
				max = Math.min(max, curr);
				index = i;
				curr = 0;
				while (index < n && grid[index][j] == 1) {
					curr++;
					index++;
				}
				max = Math.min(max, curr);
				index = j;
				curr = 0;
				while (index < m && grid[i][index] == 1) {
					curr++;
					index++;
				}
				max = Math.min(max, curr);
				index = j;
				curr = 0;
				while (index >= 0 && grid[i][index] == 1) {
					curr++;
					index--;
				}
				max = Math.min(max, curr);

				for (int l = 0; l < max; l++) {
					grid[i + l][j] = 0;
					grid[i - l][j] = 0;
					grid[i][j + l] = 0;
					grid[i][j - l] = 0;
				}
				for (int l = max - 1; l >= 0; l--) {
					for (int w = 0; w < n; w++) {
						for (int q = 0; q < m; q++) {
							int index2 = w;
							int curr2 = 0;
							int max2 = Integer.MAX_VALUE;
							while (index2 >= 0 && grid[index2][q] == 1) {
								curr2++;
								index2--;
							}
							max2 = Math.min(max2, curr2);
							index2 = w;
							curr2 = 0;
							while (index2 < n && grid[index2][q] == 1) {
								curr2++;
								index2++;
							}
							max2 = Math.min(max2, curr2);
							index2 = q;
							curr2 = 0;
							while (index2 < m && grid[w][index2] == 1) {
								curr2++;
								index2++;
							}
							max2 = Math.min(max2, curr2);
							index2 = q;
							curr2 = 0;
							while (index2 >= 0 && grid[w][index2] == 1) {
								curr2++;
								index2--;
							}
							max2 = Math.min(max2, curr2);
							if (max != 0 && max2 != 0) {
								squr = Math.max(squr, (l+1 + l * 3) * (max2 + (max2 - 1) * 3));
							}
							if (squr == 169){
		                    	System.out.println("169:"+i+" "+j+" "+q+" "+w+"max"+max+"max2"+max2);
		                    }

						}
					}

					grid[i + l][j] = 1;
					grid[i - l][j] = 1;
					grid[i][j + l] = 1;
					grid[i][j - l] = 1;
				}
			}
		}
		System.out.print(squr);

	}
}