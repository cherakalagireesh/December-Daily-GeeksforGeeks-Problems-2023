//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
         int length = s.length();
        int lpsArr[] = new int[length];
        Arrays.fill(lpsArr,0);
        int left = 0;
        int right =1;
        
        while(right < length)
        {
            
            if(s.charAt(left) == s.charAt(right))
            {
                left++;
                lpsArr[right] = left;
                right++;
            }
            else 
            {
                if(left != 0)
                {
                    left = lpsArr[left-1];
                }
                else
                {
                    lpsArr[right] = 0;
                    right++;
                }
            }
        }
        
        return lpsArr[length-1];
    }
}