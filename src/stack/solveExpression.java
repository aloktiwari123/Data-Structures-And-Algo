package stack;
import java.util.*;
public class solveExpression {
	
	public static void main(String args[]) {
		String expression="&(|(f))";
		System.out.print(solve(expression));
	}
	public static boolean solve(String ex) {
		Stack<Character>stk=new Stack<>();
		for(int i=0;i<ex.length();i++) {
			char ch=ex.charAt(i);
			if(ch==')') {
				Set<Character>operand=new HashSet<>();
				while(stk.peek() !='(') {
					operand.add(stk.peek());
					stk.pop();
				}
				stk.pop();
				char operator=stk.pop();
				if(operator == '&') {
					stk.push(operand.contains('f')?'f':'t');
				}
				else if(operator == '|')
				{
					stk.push(operand.contains('t')?'t':'f');
				}
				else {
					stk.push(operand.contains('t')?'f':'t');
				}
				
			}
			else if(ch != ',') {
				stk.push(ch);
			}
		}
		return stk.pop()=='t';	
	}

}
