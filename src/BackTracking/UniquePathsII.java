package BackTracking;
import java.util.*;
public class UniquePathsII {

	public static void main(String args[]) {
		int[][]mm= {{0,0,1},{0,1,0},{0,0,0}};
		System.out.println(solve(mm,2,2,0,0));
		System.out.println(solveDp(mm));
	}
	
	public static int solve(int[][]mm,int m,int n,int x,int y) {
		if(x==m && y==n) {
			return 1;
		}
		
		if(x>m||y>m) {
			return 0;
		}
		int left=0;
		int right=0;
		
		if((x+1)<=m && mm[x+1][y]!=1) {
			left=solve(mm,m,n,x+1,y);
		}
		
		if((y+1)<=n && mm[x][y+1]!=1) {
			right=solve(mm,m,n,x,y+1);
		}
		
		return left+right;
	}
	
	public  static int solveDp(int[][]mm) {
		int m=mm.length;
        int n=mm[0].length;
        int[][]t=new int[m][n];
        int obs=0;
        for(int i=0;i<m;i++) {
        	if(mm[i][0]!=1 && obs !=1) {
        		t[i][0]=1;
        	}
        	else {
        		obs=1;
        	}
        }
        obs=0;
        for(int i=0;i<n;i++) {
        	if(mm[0][i]!=1 && obs !=1) {
        		t[0][i]=1;
        	}
        	else {
        		obs=1;
        	}
        }
        
        for(int i=1;i<m;i++) {
        	for(int j=1;j<n;j++) {
        		if(mm[i][j]!=1) {
        			t[i][j]=t[i-1][j]+t[i][j-1];
        		}
        		else {
        			t[i][j]=0;
        		}
            	
            }
        }
        return t[m-1][n-1];
        
	}
}
