package multiThreading;

import java.util.List;

public class test1 implements Runnable {

	List<Integer> st;
	test1(List<Integer> st){
		this.st=st;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running ");
	      for(int i = 4; i > 0; i--) {
		    System.out.println(i);
		    st.add(i);
		 }
	     System.out.println("Thread  exiting.");
	     System.out.print(st);
	     try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


