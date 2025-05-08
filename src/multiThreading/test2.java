package multiThreading;

import java.util.*;

public class test2 {
	volatile static List<Integer> st=new ArrayList<>();
	public static void main(String args[]) {
		int n=2;
		for(int i=0;i<n;i++) {
			Thread t1=new Thread(new test1(st));
			t1.start();
		}
	}
}
