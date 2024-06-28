package BackTracking;
import java.util.*;
public class RatInMaze {
	static int max=0;
	public static void main(String args[]) {
		int m[][] = {{1, 0, 0, 0},
		         {1, 1, 0, 1}, 
		         {1, 1, 0, 0},
		         {0, 1, 1, 1}};
		List<choice>choices=new ArrayList<>();
		choices.add(new choice('U',-1,0));
		choices.add(new choice('D',1,0));
		choices.add(new choice('L',0,-1));
		choices.add(new choice('R',0,1));
		List<String>res=new ArrayList<>();
		if(m[0][0]==1) {
			solve(m,4,0,0,"",res,choices);
		}
		System.out.print(res);
		
	}
	
	public static void solve(int m[][],int n,int x,int y,String s,List<String>res ,List<choice> choices) {
		if(x==n-1 && y==n-1) {
			res.add(s);
			return;
		}
		
		for(choice c:choices) {
			int newX=x+c.dx;
			int newY=y+c.dy;
			if(isValidChoice(newX,newY,n,m)) {
				m[x][y]=0;
				solve(m,n,newX,newY,s+c.move,res,choices);
				m[x][y]=1;
			}
			
		}
		
	}
	
	public static boolean isValidChoice(int x,int y,int n,int m[][]) {
		return x >= 0 && x<n && y>=0 && y<n && m[x][y]==1;
	}

}

class choice{
	char move;
	int dx;
	int dy;
	
	choice(char move,int dx,int dy){
		this.move=move;
		this.dx=dx;
		this.dy=dy;
	}
}

