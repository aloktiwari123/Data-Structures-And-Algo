package Greedy;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = {1,2,3};
		int[] s = {1,1};
		System.out.print(solve(g,s));
	}

	public static int solve(int[] g,int[] s) {
		int x=0;
		int y=0;
		
		Arrays.sort(g);
		Arrays.sort(s);
		
		while(x<g.length && y<s.length) {
			if(g[x]<=s[y]) {
				x++;
				y++;
			}else {
				y++;
			}
			
		}
		return x;
	}
}
