package prefixSum;

public class WillReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chalk = {1};
		int k = 1000000000;
		System.out.print(chalkReplacer(chalk,k));
	}
	
	public static int chalkReplacer(int[] chalk, int k) {
		int n=chalk.length;
		int i=0;
		while(k>=chalk[i]) {
			k=k-chalk[i];
			i++;
			i=i%n;
		}
		return i; 
    }

}
