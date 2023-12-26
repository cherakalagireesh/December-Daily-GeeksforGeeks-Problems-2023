//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        
        int left = 0;
        int right = n-1;
        int ans = Integer.MAX_VALUE;
        
        while(left <= right)
        {
            int mid = (left + right) / 2;
            
            if(arr[left] <= arr[mid])
            {
                ans = Math.min(ans,arr[left]);
                left = mid+1;
            }
            else
            {
                ans = Math.min(ans,arr[mid]);
                right = mid-1;
            }
        }
        
        return ans;
    }
}
