package stack;

import java.util.Stack;

public class MaximumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class pair{
        int el;
        int idx;
        
        public pair(int el,int idx)
        {
            this.el=el;
            this.idx=idx;
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        
        int[] left=nsl(heights);
        int[] right=nsr(heights);
        int n=heights.length;
        int[] ans=new int[n];
        int max=0;
        
        for(int i=0;i<n;i++)
        {
            ans[i]=heights[i]*(right[i]-left[i]-1);
            
            if(max<ans[i])
            {
                max=ans[i];
            }
        }
        return max;
    }
    
    public int[] nsl(int heights[])
    {
        Stack<pair> st=new Stack<>();
        int n=heights.length;
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && st.peek().el>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i]=-1;
            }
            else
            {
                ans[i]=st.peek().idx;
            }
            st.push(new pair(heights[i],i));
        }
        return ans;
        
    }
    
    public int[] nsr(int heights[])
    {
        Stack<pair> st=new Stack<>();
        int n=heights.length;
        int[] ans=new int[n];
        
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek().el>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i]=n;
            }
            else
            {
                ans[i]=st.peek().idx;
            }
            st.push(new pair(heights[i],i));
        }
        return ans;
        
    }

}
