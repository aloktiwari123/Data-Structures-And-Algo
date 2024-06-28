package stack;

public class MaxDepth {
	public static void main(String args[]) {
		String s="(1+(2*3)+((8)/4))+1";
		System.out.print(maxDepth(s));
	}
	public static int maxDepth(String s) {
		int counter=0;
		int maxCounter=0;
		for(char ch:s.toCharArray()) {
			if(ch=='(') {
				counter++;
			}
			if(ch==')') {
				counter--;
			}
			maxCounter=Math.max(maxCounter, counter);
		}
		return maxCounter;
	}
}
