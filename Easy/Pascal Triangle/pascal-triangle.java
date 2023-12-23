//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        
         ArrayList<Long> al = new ArrayList<>();
        long mod = 1000000007; 
        
        long ans = 1;
        al.add(1L);
        
        for(int  i = 1; i < n; i++){
            ans = (ans * (n - i)) % mod;
            ans = (ans * modInverse(i, mod)) % mod;
            al.add(ans);
        }
        
        return al;
    }
    
    private static long modInverse(long n, long m) {
        long m0 = m;
        long a = Math.max(n, m);
        long b = Math.min(n, m);
        long q = 0;
        long r = 0;
        long t1 = 0;
        long t2 = 1;
        long t = 0;
        
        while(b > 0){
            q = a / b;
            r = a % b;
            
            t = t1 - t2 * q;
            
            a = b;
            b = r;
            
            t1 = t2;
            t2 = t;
        }
        
        if (t1 < 0)
            t1 += m0;
        
        return t1;
    }
}