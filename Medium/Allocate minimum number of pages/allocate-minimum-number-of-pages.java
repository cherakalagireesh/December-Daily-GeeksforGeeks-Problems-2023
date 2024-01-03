//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        
        if( M > N)
            return -1;
            
        long []temp = findValues(A);
        
        long low = temp[0];
        long high = temp[1];
        
        while(low <= high)
        {
            long mid = (low + high) / 2;
            
            if(isPossible(A, mid) > M)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return (int)(low);
    }
    
    public static long[] findValues(int []A)
    {
        long max = A[0];
        long sum = 0;
        
        for(int num:A)
        {
            max = Math.max(max, num);
            sum += num;
        }
        
        return new long[]{max,sum};
    }
    
    public static int isPossible(int A[], long maxPages)
    {
        long count = 1;
        long sum = 0;
        int length = A.length;
        
        for(int i = 0 ; i < length ; i++)
        {
            
            if(sum + A[i] <= maxPages)
                sum += A[i];
            else
            {
                count++;
                sum = A[i];
            }
        }
        

        return (int)count;
    }
}; 