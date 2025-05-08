package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensLeetCode {

	static List<List<String>>ans=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int[][] board=new int[n][n];
		solve(0,n,board,new ArrayList<>());
		System.out.print(ans);
	}
	
	public static void solve(int rowIdx,int n,int[][] board,List<String>temp) {
		if(rowIdx==n) {
			List<String> tempAns=new ArrayList<>(temp);
			if(!ans.contains(tempAns)) {
				ans.add(tempAns);
			}
			return;
		}
		//column we are deciding for
		char[] move=new char[n];
		Arrays.fill(move,'.');
		for(int colIdx=0;colIdx<n;colIdx++) {
			if(isSafe(rowIdx,colIdx,board)) {
				board[rowIdx][colIdx]=1;
				move[colIdx]='Q';
				temp.add(new String(move));
				solve(rowIdx+1,n,board,temp);
				move[colIdx]='.';
				board[rowIdx][colIdx]=0;
				temp.remove(temp.size()-1);
				
			}
		}
	}
	
	public static boolean isSafe(int x,int y,int[][] board) {
		// same row
		for(int i=x;i>=0;i--) {
			if(board[i][y]==1) {
				return false;
			}
		}
		//upper diagonal
		for(int i=x,j=y;i>=0 && j>=0;i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		//lower diagonal
		for(int i=x,j=y;j<board.length && i>=0;i--,j++) {
			if(board[i][j]==1) {
				return false;
			}
		}
		return true;
	}

}
