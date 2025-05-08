package stack;

import java.util.Stack;

public class SolveFractions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "-1/2+1/2+1/3";
		System.out.print(solve(exp));
	}
	
	public static String solve(String exp) {
		Stack<frac> st=new Stack<>();
		if(!exp.startsWith("-")) exp="+"+exp;
		int symbolIdx=0;
		for(int i=1;i<exp.length();i++) {
			char ch=exp.charAt(i);
			if(ch=='+'||ch=='-') {
				frac fr=new frac(exp.substring(symbolIdx,i));
				if(!st.isEmpty()) {
					frac temp=st.peek();
					temp.solve(fr);
				}
				else {
					st.add(new frac(exp.substring(symbolIdx,i)));
				}
				symbolIdx=i;
			}
		}
		frac fr=new frac(exp.substring(symbolIdx,exp.length()));
		frac temp;
		if(!st.isEmpty()) {
			temp=st.peek();
			temp.solve(fr);
		}
		else {
			temp=fr;
		}
		System.out.print(temp);
		return temp.symbol=='-'?"-"+temp.fraction:temp.fraction; 
	}

}

class frac{

	char symbol;
	String fraction;
	
	public frac(String s) {
		symbol=s.contains("-")?'-':'+';
		fraction=scrapFraction(s);
	}
	
	public String scrapFraction(String s) {
		s=s.contains("/")?s:s+"/1";
		if(s.contains("+")) {
			s=s.replace("+","");
		}
		if(s.contains("-")) {
			s=s.replace("-","");
		}
		return s;
	}
	
	public void solve(frac f1) {
		String nums1[]=this.fraction.split("/");
		String nums2[]=f1.fraction.split("/");
		int num1=Integer.valueOf(nums1[0]);
		int den1=Integer.valueOf(nums1[1]);
		int num2=Integer.valueOf(nums2[0]);
		int den2=Integer.valueOf(nums2[1]);
		int newDen=getLCS(den1,den2);
		num1=(newDen/den1)*num1;
		num2=(newDen/den2)*num2;
		int newNum=0;
		if((symbol=='+' && f1.symbol=='+')||(symbol=='-' && f1.symbol=='-')) {
			newNum=num1+num2;
		}
		else if(symbol=='-'||f1.symbol=='-') {
			newNum=Math.abs(num1-num2);
			this.symbol=num1>num2?this.symbol:f1.symbol;
		}
		int gcd=gcd(newNum,newDen);
		newNum=newNum/gcd;
		newDen=newDen/gcd;
		this.fraction=newNum+"/"+newDen;
		
	}
	
	public int getLCS(int a,int b) {
		return (a / gcd(a, b)) * b;
	}
	
	public int gcd(int a, int b)
    {
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }
	
	@Override
	public String toString() {
		return "frac [symbol=" + symbol + ", fraction=" + fraction + "]";
	}
}
