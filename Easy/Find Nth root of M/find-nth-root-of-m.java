//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        
        long low = 1;
        long high = m;
        
        while(low <= high)
        {
            long mid = (low + high) / 2;
            long val = findVal(n,mid,m);
            
            if( val == m)
                return (int)(mid);
            else if(val > m)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        
        return -1;
    }
    
    public long findVal(int n, long mid,int m)
    {
        long ans = 1;
        
        while(n>0)
        {
            ans = ans * mid;
            n--;
            
            if(ans > m)
                return m+1;
        }
        
        return ans;
    }
}