package BackTracking;

import java.util.Optional;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp="00000 dsadad";
		for(String s:temp.split("/")){
			System.out.println(s);
		}
		boolean res= Optional.ofNullable(temp)
		.map(String::trim).filter(s->!s.isEmpty())
		.map(s->{
			try {
				Float.parseFloat(s);
				return true;
			}catch (NumberFormatException e) {
				return false;
			}
		}).orElse(false);
		System.out.println(res);
	}

}
