//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        
        int max = findMax(piles);
        int low = 1;
        int high = max;
        
        while(low <= high)
        {
            int mid  = (low + high) / 2;
            
            if(isPossible(piles,mid,H))
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return low;
    }
    
    public static int findMax(int[] piles)
    {
        int ans = piles[0];
        
        for(int num:piles)
            ans = Math.max(ans,num);
            
        return ans;
    }
    
    public static boolean isPossible(int[] piles,int mid, int H)
    {
        long count = 0;
        int length = piles.length;
        
        for(int i=0;i<length;i++)
        {
            count = count + (long)(Math.ceil((double)(piles[i] / (double)(mid))));
            
            if(count > H)
                return false;
        }
        
        return true;
    }
}
        
