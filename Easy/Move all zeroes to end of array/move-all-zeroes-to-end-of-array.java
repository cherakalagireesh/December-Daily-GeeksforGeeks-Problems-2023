//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        
       int left = -1;
       int length = arr.length;
       
       for( int i=0;i<length;i++)
       {
           if(arr[i] == 0)
           {
               left = i;
               break;
           }
       }
       
       if(left!=-1)
       {
           int right = left+1;
           while(right < length)
           {
               if(arr[right] != 0)
               {
                   int temp = arr[right];
                   arr[right] = arr[left];
                   arr[left] = temp;
                   left++;
               }
               right++;
           }
       }
    }
}