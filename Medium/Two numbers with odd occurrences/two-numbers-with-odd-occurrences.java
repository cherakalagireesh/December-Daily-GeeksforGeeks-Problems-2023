//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        int left = 0;
        int right = 0;
        int count = 0;
        int result[] = new int[2];
        int index = 1;
        Arrays.sort(Arr);
        
        while(right < N)
        {
            if(Arr[left] != Arr[right])
            {
                if(count%2 == 1)
                {
                    result[index--] = Arr[left];
                }
               
               count=0;
               left = right--;
            }
            else
            {
                count++;
            }
            
            right++;
        }
        
        if(count%2 == 1)
        {
            result[index--] = Arr[left];
        }
        
        return result;
    }
}