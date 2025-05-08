package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	
	static List<List<Integer>>ans=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int[][] board=new int[n][n];
		solve(0,n,board,new ArrayList<>());
		System.out.print(ans);
	}
	
	public static void solve(int idx,int n,int[][] board,List<Integer>temp) {
		if(idx==n) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		
		//column we are deciding for
		for(int i=0;i<n;i++) {
			if(isSafe(i,idx,board)) {
				board[i][idx]=1;
				temp.add(i+1);
				solve(idx+1,n,board,temp);
				board[i][idx]=0;
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static boolean isSafe(int x,int y,int[][] board) {
		// same row
		for(int i=y;i>=0;i--) {
			if(board[x][i]==1) {
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
		for(int i=x,j=y;i<board.length && j>=0;i++,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}
}
