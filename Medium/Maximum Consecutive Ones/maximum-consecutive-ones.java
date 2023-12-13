//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.longestOnes(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int longestOnes(int n, int[] nums, int k) {
        
        int result = 0;
        int left = 0;
        int right = 0;
        int length = nums.length;
        int zeroCount = 0;
        
        while(right<length)
        {
            if(nums[right] == 0)
            {
                zeroCount++;
            }
            if(zeroCount > k)
            {
                while(left < right)
                {
                    if(nums[left] == 0)
                    {
                        zeroCount--;
                    }
                    
                    left++;
                    
                    if(zeroCount == k)
                    {
                        break;
                    }
                }
            }
            
            result = Math.max(result,right-left+1);
            right++;
        }
        
        return result;
    }
}
        