package Sorting;

import java.util.Arrays;

public class DividePlayers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] skill = {3,2,5,1,3,4};
		 System.out.print(solve(skill));
	}
	
	public static long solve(int[] skills) {
		if(skills.length%2!=0) return -1;
		
		int sum=0;
		for(int skill:skills) {
			sum+=skill;
		}
		
		int target=sum/(skills.length/2);
		Arrays.sort(skills);
		long ans=0;
		int i=0;
		while(i<(skills.length/2)) {
			if((skills[i]+skills[skills.length-1-i])!=target) return -1;
			ans+=skills[i]*skills[skills.length-1-i];
			i++;
		}
		return ans;
	}

}
