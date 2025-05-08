package HashFunction;

import java.util.HashMap;

public class PaintRowAndColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,4,2};
		int[][] mat = {{1,4},{2,3}};
		System.out.print(solve(arr,mat));
	}
	
	public static int solve(int[] arr,int[][]matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[] rowCount = new int[numRows];
        int[] colCount = new int[numCols];
		HashMap<Integer,int[]>map=new HashMap<>();
		for(int i=0;i<numRows;i++) {
			for(int j=0;j<numCols;j++) {
				map.put(matrix[i][j],new int[] {i,j});
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			int[] idx=map.get(arr[i]);
			matrix[idx[0]][idx[1]]=-1;
			rowCount[idx[0]]++;
			colCount[idx[1]]++;
			if(rowCount[idx[0]]==numRows ||colCount[idx[1]]==numCols) {
				return i;
			}
		}
		return -1;
		
	}
	public static boolean checkRow(int row, int[][] mat) {
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(int col, int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }
}
