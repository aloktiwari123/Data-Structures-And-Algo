package BackTracking;

import java.util.HashSet;

public class SudukoSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board= {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		helper(board,0,0);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]);
			}System.out.println();
		}
	}
	
	public static void solve(char[][] board,int x,int y) {
		if(x == 9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(board[i][j]);
				}System.out.println();
			}
			return;
		}
		
		if(y==9) {
			solve(board,x+1,0);
			return;
		}
		
		if(board[x][y]=='.') {
			for(int j=1;j<=9;j++) {
				if(isValid(j,x,y,board)) {
					board[x][y]=(char)(j+'0');
					solve(board,x,y+1);
					board[x][y]='.';
				}
			}
			
		}
		else {
			solve(board,x,y+1);
		}
		
	}
	
	public static boolean helper(char[][] board,int x,int y) {
		if(x == 9) {
			return true;
		}
		
		if(y==9) {
			return helper(board,x+1,0);
		}
		
		if(board[x][y]=='.') {
			for(int j=1;j<=9;j++) {
				if(isValid(j,x,y,board)) {
					board[x][y]=(char)(j+'0');
					boolean res=helper(board,x,y+1);
					if(res==true) return true;
					board[x][y]='.';
				}
			}
			
		}
		else {
			return helper(board,x,y+1);
		}
		return false;
	}

	public static boolean isValid(int choice, int x, int y,char[][] board) {
		// TODO Auto-generated method stub
		// vertical
		for(int i=0;i<9;i++) {
			if((board[x][i]-'0') == choice) {
				return false;
			}
		}
		//horizontal
		for(int i=0;i<9;i++) {
			if((board[i][y]-'0') == choice) {
				return false;
			}
		}
		
		//sub grid check
		x=(x/3)*3;
		y=(y/3)*3;
		for(int i=x;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				if((board[i][j]-'0') == choice) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
