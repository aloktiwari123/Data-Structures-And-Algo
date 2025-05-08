package BackTracking;

public class WordSearch {

	static int[][] isVisited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] board = {{'C','C','C'},{'A','A','A'},{'B','C','D'}};
		String word = "AAB";
		System.out.print(solve(board,word));
	}
	
	public static boolean solve(char[][] board,String word) {
		char[] chars=word.toCharArray();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(chars[0]==board[i][j]) {
					isVisited=new int[board.length][board[0].length];
					if(dfs(i,j,board,chars,1)) return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isValid(int x,int y,char[][] board,char next) {
		return (x>=0 && x<board.length && y>=0 &&  y<board[0].length && isVisited[x][y] !=1 &&board[x][y] == next);
	}
	
	
	public static boolean dfs(int x,int y,char[][] board,char[] words,int idx) {
		if(words.length ==idx) return true;
		int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
		boolean ans=false;
		for(int[] dir:dirs) {
			int newX=x+dir[0];
			int newY=y+dir[1];
			
			if(isValid(newX,newY,board,words[idx])) {
				isVisited[x][y]=1;
				ans=ans||dfs(newX,newY,board,words,idx+1);
				isVisited[x][y]=0;
			}
		}
		
		return ans;
	}
	

}
