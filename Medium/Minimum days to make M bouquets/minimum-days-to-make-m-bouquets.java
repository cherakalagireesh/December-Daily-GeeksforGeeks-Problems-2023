//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int M, int K, int[] bloomDay) {
       
        int length = bloomDay.length;
       
        if((long)(M) * (long)(K) > length)   
            return -1;
            
        int low  = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int num:bloomDay)
        {
            low = Math.min(low,num);
            high = Math.max(high,num);
        }
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            if(isPossible(bloomDay,mid,M,K))
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return low;
    }
    
    public static boolean isPossible(int[] bloomDay, int mid, int M , int K)
    {
        int count = 0;
        int length = bloomDay.length;
        int noBkts = 0;
        
        for(int i=0;i<length;i++)
        {
            if(bloomDay[i] <= mid)
                count++;
            else
            {
                noBkts += count / K;
                count = 0;
            }
        }
        
        noBkts += count / K;
        
        return noBkts >= M;
    }
}