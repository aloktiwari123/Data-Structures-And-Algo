package stack;

public class TheCelebrityProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]matrix= {{0,1,1,0},{0,0,0,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(solve(matrix));
	}
	
	public static int solve(int matrix[][]) {
		int top=0;
		int bottom=matrix.length-1;
		
		while(top<bottom) {
			if(matrix[top][bottom]==1) {
				top++;
			}else if(matrix[bottom][top]==1) {
				bottom--;
			}else {
				top++;
				bottom--;
			}
		}
		
		if(top>bottom) return -1;
		
		for(int i=0;i<matrix[0].length;i++) {
			if(i==top) continue;
			if(matrix[top][i]==0 && matrix[i][top]==1) {
				continue;
			}else {
				return -1;
			}
		}
		return top;
	}

}
