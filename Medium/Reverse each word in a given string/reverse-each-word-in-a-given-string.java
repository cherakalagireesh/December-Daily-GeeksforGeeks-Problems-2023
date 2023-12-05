//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {
        
        StringBuilder result = new StringBuilder();
        StringBuilder currWord = new StringBuilder();
        
        for(char ch:S.toCharArray())
        {
            if(ch == '.')
            {
                result.append(currWord.reverse()).append(".");
                currWord.setLength(0);
            }
            else
            {
                currWord.append(ch);
            }
        }
        
        if(currWord.length()>=1)
        {
            result.append(currWord.reverse());
        }
        
        return result.toString();
        
    }
}