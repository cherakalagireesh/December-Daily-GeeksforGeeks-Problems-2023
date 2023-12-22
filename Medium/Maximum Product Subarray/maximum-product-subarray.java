//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        
        long prefixProduct = 1;
        long suffixProduct = 1;
        long result = Long.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            if(prefixProduct == 0) prefixProduct = 1;
            if(suffixProduct == 0) suffixProduct = 1;
            
            prefixProduct = prefixProduct * arr[i];
            suffixProduct = suffixProduct * arr[n-1-i];
            
            result = Math.max(result,Math.max(prefixProduct,suffixProduct));
        }
        
        return result;
    }
}