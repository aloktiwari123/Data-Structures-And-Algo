package prefixSum;
import java.util.Arrays;

public class ShiftBalls {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "110";
		System.out.print(Arrays.toString(minOperations(s)));
	}
	
	public static int[] minOperations(String boxes) {
        int[] ans=new int[boxes.length()];

        for(int curr=0;curr<boxes.length();curr++){
            if(boxes.charAt(curr)=='1'){
                for(int i=0;i<boxes.length();i++){
                    ans[i]+=Math.abs(i-curr);
                }
            }
        }
        return ans;
    }
}
