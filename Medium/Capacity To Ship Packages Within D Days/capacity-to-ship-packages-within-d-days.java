//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        
        int low = 1;
        int high = 0;
        
        for(int num:arr)
        {
            high += num;
        }
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            if(isPossible(arr, mid, D))
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return low;
    }
    
    public static boolean isPossible(int nums[], int mid, int D)
    {
        int count = 0;
        long sum = 0;
        int length = nums.length;
        
        for(int i=0;i<length;i++)
        {
            sum += nums[i];
            
            if(sum > mid)
            {
                count++;
                if(nums[i] > mid)
                    return false;
                else
                    sum = nums[i];
            }
        }
        
        if(sum != 0)
        {
            count++;
            if(nums[length-1] > mid)
                return false;
        }
        
        return count <= D;
    }
};